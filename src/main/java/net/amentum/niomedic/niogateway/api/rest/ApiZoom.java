package net.amentum.niomedic.niogateway.api.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import net.amentum.niomedic.niogateway.exception.ZoomException;

@Component
@Slf4j
public class ApiZoom {
	private Date fechaTocken;
	private String TockenUtil="";

	//Se crea un JWT el cual zoom valida y nos da acceso para consumir sus servicios
	private String createJWT() throws Exception {
		final String SECRETKEY="LaMvSRrrktYdFk01AS2H2Sl85EirVre8RTzE";
		final String HEADER = "{\"typ\":\"JWT\",\"alg\":\"HS256\"}";
		String base64UrlHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(HEADER.getBytes());

		Long timeSecs = (System.currentTimeMillis() / 1000) + 10;
		Long tiempo = (timeSecs - 2) * 1000;
		fechaTocken= new Date(tiempo);

		String payload = "{\"iss\":\"FNv8ipUNSS6lIF7mXM9DUg\",\"exp\":" + String.valueOf(timeSecs) + "}";
		String base64UrlPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());
		try {
			String base64UrlSignature = hmacEncode(base64UrlHeader + "." + base64UrlPayload, SECRETKEY);
			String token=base64UrlHeader + "." + base64UrlPayload + "." + base64UrlSignature;
			return token;
		} catch (Exception e) {
			ZoomException ee = new ZoomException("Error inesperado al crear el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
			ee.addError("Error al crear token de zoom");
			log.error("Error inesperado al crear el token de zoom, error:{}",e);
			throw ee;
		}
	}
	private String hmacEncode(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(sha256_HMAC.doFinal(data.getBytes()));
	}
	private ObjectMapper mapp= new ObjectMapper();
	public Map<String, Object> crearMeeting(String topic, Date StartTime, String Agenda, String idUsuarioZoom) throws ZoomException, Exception {

		JsonRequest jr = new JsonRequest();
		jr.setTopic(topic);
		jr.setType(2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String fachaInicio=sdf.format(StartTime);
		//StartTime
		jr.setStart_time(fachaInicio);
		jr.setDuration(30);
		jr.setTimezone("America/Mexico_City");
		jr.setAgenda(Agenda);

		JsonNode body=mapp.convertValue(jr, JsonNode.class);

		Boolean reitento=Boolean.FALSE;
		Integer count= 0;
		do {
			URL url = new URL("https://api.zoom.us/v2/users/"+idUsuarioZoom+"/meetings");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			String token="";
			if(fechaTocken==null) {
				token = "bearer "+createJWT();
				TockenUtil = token;
				log.debug("Creando token fechaToken = null");
			}else if(new Date().getTime() < fechaTocken.getTime()  && !TockenUtil.isEmpty()) {
				token = TockenUtil;
				log.debug("Reutilizando token");
			}else {
				token = "bearer "+createJWT();
				TockenUtil = token;
				log.debug("Creando token");
			}
			conn.setRequestProperty("Authorization", token);
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(body.toString().getBytes());
			os.flush();
			if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				System.out.println(conn.getResponseMessage());
				BufferedReader  br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				StringBuilder response = new StringBuilder();
				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					response.append(currentLine);
				}

				br.close();
				Map<String, Object> JsonResponse= mapp.readValue(response.toString(), Map.class);
				try {
					Integer code = (Integer) JsonResponse.get("code");
					String message = (String) JsonResponse.get("message");
					if(code==124) {
						reitento= Boolean.TRUE;
						count++;
						if(count>=3) {
							reitento= Boolean.FALSE;
						}
					}else {
						ZoomException ee = new ZoomException("Ocurrio un error al crear el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
						ee.addError("Code:"+code+", message:"+message);
						throw ee;
					}
				}catch(Exception e){
					System.out.println(e);
				} 
			}else {

				BufferedReader  br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder response = new StringBuilder();
				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					response.append(currentLine);
				}
				System.out.println(response.toString());
				br.close();
				Map<String, Object> JsonResponse= mapp.readValue(response.toString(), Map.class);
				Map<String, Object> infoMeeting = new HashMap<String, Object>();
				infoMeeting.put("join_url", (String) JsonResponse.get("join_url"));
                // Sre20042020 Inicia el id puede ser un long
				//infoMeeting.put("id", (Integer)JsonResponse.get("id"));
                infoMeeting.put("id", new Long(((Number)JsonResponse.get("id")).longValue()));
                // Sre20042020 Termina
				log.info("crearMeeting() - Se Creo evento en Zoom");
				return infoMeeting;
			}
		}while(reitento);
		if(count>=3) {
			ZoomException ee = new ZoomException("Ocurrio un error al crear el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
			ee.addError("Se supero el numero maximo de reintentos para crear el evento" );
			throw ee;
		}
		return null;

	}

	public void reagedarMeeting(Long idMeeting, Date StartTime) throws ZoomException, Exception{
		JsonRequest jr = new JsonRequest();
		jr.setTopic(null);
		jr.setType(null);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String fachaInicio=sdf.format(StartTime);
		//StartTime
		jr.setStart_time(fachaInicio);
		jr.setDuration(30);
		jr.setTimezone("America/Mexico_City");
		jr.setAgenda(null);

		JsonNode body=mapp.convertValue(jr, JsonNode.class);

		Boolean reitento=Boolean.FALSE;
		Integer count= 0;
		do {
			HttpPatch httpPatch = new HttpPatch(new URI("https://api.zoom.us/v2/meetings/"+idMeeting));
			StringEntity inputData= new StringEntity(body.toString());
			httpPatch.setEntity(inputData);
			httpPatch.addHeader("Content-Type", "application/json");
			String token="";
			if(fechaTocken==null) {
				token = "bearer "+createJWT();
				TockenUtil = token;
			}else if(new Date().getTime() < fechaTocken.getTime()  && !TockenUtil.isEmpty()) {
				token = TockenUtil;		
			}else {
				token = "bearer "+createJWT();
				TockenUtil = token;
			}
			httpPatch.addHeader("Authorization", token);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse response = httpClient.execute(httpPatch);
			if(response.getStatusLine().getStatusCode() != 204 ) {
				String respuesta = EntityUtils.toString(response.getEntity());
				Map<String, Object> JsonResponse= mapp.readValue(respuesta, Map.class);
				try {
					Integer code = (Integer) JsonResponse.get("code");
					String message = (String) JsonResponse.get("message");
					if(code==124) {
						reitento= Boolean.TRUE;
						count++;
						if(count>=3) {
							reitento= Boolean.FALSE;
						}
					}else if(code==404) {
						ZoomException ee = new ZoomException("Ocurrio un error al reagendar el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
						ee.addError("Meeting no fue encontrado");
						log.info("reagedarMeeting() - El meeting con el iD:{} no fue encontrado",idMeeting);
						throw ee;
					}else {
						ZoomException ee = new ZoomException("Ocurrio un error al Eliminar el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
						ee.addError("Code:"+code+", message:"+message);
						throw ee;
					}
				}catch(Exception e){
					log.error("No se pudo mappear la respuesta de la Api de Zoom -  error:{}", e);
				} 
			}else {
				reitento = Boolean.FALSE;
				log.info("reagedarMeeting() - Se reagendo el evento en Zoom");
			}
		}while(reitento);
		if(count>=3) {
			ZoomException ee = new ZoomException("Ocurrio un error al crear el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
			ee.addError("Se supero el numero maximo de reintentos para crear el evento" );
			throw ee;
		}
	}


	public void cancelarMeeting(Long idMeeting) throws ZoomException, Exception {
		Boolean reitento=Boolean.FALSE;
		Integer count= 0;
		do {
			URL url = new URL("https://api.zoom.us/v2/meetings/"+idMeeting);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			String token="";
			if(fechaTocken==null) {
				token = "bearer "+createJWT();
				TockenUtil = token;
				log.debug("Creando token fechaToken = null");
			}else if(new Date().getTime() < fechaTocken.getTime()  && !TockenUtil.isEmpty()) {
				token = TockenUtil;
				log.debug("Reutilizando token");
			}else {
				token = "bearer "+createJWT();
				TockenUtil = token;
				log.debug("Creando token");
			}
			conn.setRequestProperty("Authorization", token);
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.flush();
			if(conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
				System.out.println(conn.getResponseMessage());
				BufferedReader  br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				StringBuilder response = new StringBuilder();
				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					response.append(currentLine);
				}

				br.close();
				Map<String, Object> JsonResponse= mapp.readValue(response.toString(), Map.class);
				try {
					Integer code = (Integer) JsonResponse.get("code");
					String message = (String) JsonResponse.get("message");
					if(code==124) {
						reitento= Boolean.TRUE;
						count++;
						if(count>=3) {
							reitento= Boolean.FALSE;
						}
					}else if(code==404) {
						ZoomException ee = new ZoomException("Ocurrio un error al reagendar el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
						ee.addError("Meeting no fue encontrado");
						log.info("reagedarMeeting() - El meeting con el iD:{} no fue encontrado",idMeeting);
						throw ee;
					}else {
						ZoomException ee = new ZoomException("Ocurrio un error al Eliminar el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
						ee.addError("Code:"+code+", message:"+message);
						throw ee;
					}
				}catch(Exception e){
					log.error("No se pudo mapear la respuesta de la Api de Zoom -  error:{}", e);
				} 
			}else {
				reitento= Boolean.FALSE;
				log.info("cancelarMeeting() - Se cancelo el evento en Zoom");
			}
		}while(reitento);
		if(count>=3) {
			ZoomException ee = new ZoomException("Ocurrio un error al crear el evento en Zoom", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
			ee.addError("Se supero el numero maximo de reintentos para crear el evento" );
			throw ee;
		}
	}



	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	private  class JsonRequest{
		private String topic;
		private Integer type; 
		private String start_time; 
		private Integer duration; 
		private String timezone; 
		private String agenda;
		private Settings settings = new Settings();
	}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	private class Settings{
		private Boolean host_video= Boolean.TRUE;
		private Boolean waiting_room= Boolean.TRUE;
	}


}
