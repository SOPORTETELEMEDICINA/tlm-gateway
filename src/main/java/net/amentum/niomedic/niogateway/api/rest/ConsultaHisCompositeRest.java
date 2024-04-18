package net.amentum.niomedic.niogateway.api.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.medicos.views.MedicoPageView;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.expediente.ConsultaRest;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;
import net.amentum.niomedic.niogateway.api.rest.medicos.MedicosRest;
import net.amentum.niomedic.niogateway.views.ConsultaPacienteHis;
import net.amentum.niomedic.niogateway.views.PacienteHis;
import net.amentum.niomedic.pacientes.views.PacientePageView;
import net.amentum.niomedic.pacientes.views.PacienteView;

@RestController
@RequestMapping("consulta-his")
public class ConsultaHisCompositeRest {
	private final Logger logger = LoggerFactory.getLogger(ConsultaHisCompositeRest.class);

	@Autowired
	private ConsultaRest consultaRest;

	@Autowired
	private PacienteRest pacienteRest;

	@Autowired 
	private MedicosRest medicosRest;

	@Autowired
	private UserAppRest userAppRest;

	@PostMapping
	public Long createConsultaHis(@RequestBody @Validated ConsultaPacienteHis consulta) throws PacienteException {
		ConsultaView consultaView = new ConsultaView();
		Boolean error= Boolean.FALSE;
		//informacion de consulta
		consultaView.setEspecialidad(consulta.getConsultaHis().getEspecialidad());
		consultaView.setFechaInicio(consulta.getConsultaHis().getFechaInicio());
		consultaView.setFeachaFin(consulta.getConsultaHis().getFechaFin());
		consultaView.setMotivoConsulta(consulta.getConsultaHis().getMotivoConsulta());
		consultaView.setFechaConsulta(consulta.getConsultaHis().getFechaInicio());
		consultaView.setIdTipoConsulta(6);
		consultaView.setTipoConsulta("TELEMEDICINA");
		consultaView.setSubjetivo(consulta.getConsultaHis().getSintonmas());
		consultaView.setCanal("Video consulta");
		consultaView.setReferencia1(consulta.getConsultaHis().getIdConsulta());
		consultaView.setReferencia2(consulta.getPacienteHis().getIdPaciente());

		UUID idMedico= null;
		//busqueda de medico
		// GGR20200617 Agrego grupo seleccionado
		Page<MedicoPageView> medicoPage= new Page<MedicoPageView>();
		if(consulta.getConsultaHis().getMedicoSolicitante()!=null && !consulta.getConsultaHis().getMedicoSolicitante().isEmpty()) {
			medicoPage=medicosRest.getMedicoPage(consulta.getConsultaHis().getMedicoSolicitante(), true, 0, 1, "nombre", "asc",null);
			logger.info("createConsultaHis() - Buscando Medico con el nombre:{}", consulta.getConsultaHis().getMedicoSolicitante());

			List<MedicoPageView>medicoList=medicoPage.getContent();
			try {
				idMedico= UUID.fromString(medicoList.get(0).getIdMedico());
			}catch(Exception e){
				logger.error("createConsultaHis() - No se pudo convertir el id paciente de String a UUID - error{}",e);
			}
			consultaView.setIdMedico(idMedico);
			consultaView.setNombreMedico(medicoList.get(0).getNombre().replace("null", ""));
			consultaView.setIdUsuario(medicoList.get(0).getIdUsuario());
		}else {
			//si no se encuentra el medico se asigna al medico celene
			logger.info("createConsultaHis() - No se encontro Medico con el nombre:{}", consulta.getConsultaHis().getMedicoSolicitante());
			logger.info("createConsultaHis() - Buscando Medico por idUsuario:{}", 1);
			MedicoView medico= medicosRest.getDetailsByIdUsuario(103);
			logger.info("createConsultaHis() - Medico:{}",medico);
			try {
				idMedico= UUID.fromString(medico.getIdMedico());
			}catch(Exception e){
				logger.error("createConsultaHis() - No se pudo convertir el id paciente de String a UUID - error{}",e);
			}
			consultaView.setIdMedico(idMedico);
			consultaView.setNombreMedico(medico.getNombre()+" "+medico.getApellidoPaterno());
			consultaView.setIdUsuario(medico.getIdUsuario());
		}

		//busqueda Paciente
		String datosBusqueda="";
		if(consulta.getPacienteHis().getApellidoMaterno()!=null && !consulta.getPacienteHis().getApellidoMaterno().isEmpty()) {
			datosBusqueda=consulta.getPacienteHis().getNombrePaciente().trim()  +" "+   consulta.getPacienteHis().getApellidoPaterno().trim()+" "+consulta.getPacienteHis().getApellidoMaterno().trim();
		}else {
			datosBusqueda=consulta.getPacienteHis().getNombrePaciente().trim()  +" "+   consulta.getPacienteHis().getApellidoPaterno().trim();
		}

		logger.info("createConsultaHis() - Buscando Peciente con el nombre:{}",datosBusqueda);
		PacientePageView pv=buscarPaciente(datosBusqueda,consulta.getPacienteHis().getCurp());
		if(pv!=null) {
			logger.info("createConsultaHis() - paciente:{}",pv);
			consultaView.setNombrePaciente(pv.getNombre());
			Random random = new Random();
//			consultaView.setNumeroConsulta(random.nextInt(999)+"");
			UUID idpaciente= null;
			try {
				idpaciente= UUID.fromString(pv.getIdPaciente());
			}catch(Exception e){
				logger.error("createConsultaHis() - No se pudo convertir el id paciente de String a UUID - error{}",e);
			}
			consultaView.setIdPaciente(idpaciente);
		}else {
			UserAppView userAppView = new UserAppView();
			//informacion del paciente
			logger.info("createConsultaHis() - Creando Usuario:");
			//TODO falta agregar correo para el usuario
			String aux=generarUserName(consulta.getPacienteHis());
			userAppView.setUsername(aux);
			userAppView.setName(datosBusqueda);
			userAppView.setPassword("niomedic"+aux);
			userAppView.setStatus("ACTIVO");
			userAppView.setProfileId(27L);
			userAppView.setIdTipoUsuario(3);
			if(consulta.getPacienteHis().getEmail()!=null && !consulta.getPacienteHis().getEmail().isEmpty()) {
				userAppView.setEmail(consulta.getPacienteHis().getEmail());
			}
			List<Long> tempo = new ArrayList<>();
			tempo.add(2L);
			userAppView.setGroupList(tempo);
			Long idUsuario=0L;
			try {
				UserAppPageView userAppPageView = userAppRest.createUserApp(userAppView);
				PacienteView view =pacienteConverter(consulta.getPacienteHis(), new PacienteView());
				idUsuario=userAppPageView.getIdUserApp();
				view.setIdUsuario(userAppPageView.getIdUserApp());
				view.setUserName(userAppPageView.getUsername());
				logger.info("createConsultaHis() - Nuevo usuario:{}",userAppPageView);
				logger.info("createConsultaHis() - creando Paciente:{}",view);
				pacienteRest.createPaciente(view);
				logger.info("createConsultaHis() - Paciente Creado");
			}catch(Exception e) {
				error=Boolean.TRUE;
				logger.info("createConsultaHis() - ocurrio un error al guardar la consulta - error:{}",e);
				throw e;
			}
			if(!error) {
				logger.info("createConsultaHis() - Obteniendo paciente por idUsuario :{}",idUsuario);
				PacienteView pacienteView2=pacienteRest.getPacienteByIdUsuario(idUsuario.intValue());
				logger.info("createConsultaHis() - paciente:{}",pacienteView2);
				consultaView.setNombrePaciente(pacienteView2.getNombre()+" "+pacienteView2.getApellidoPaterno());
				Random random = new Random();
//				consultaView.setNumeroConsulta(random.nextInt(999)+"");
				UUID idpaciente= null;
				try {
					idpaciente= UUID.fromString(pacienteView2.getIdPaciente());
				}catch(Exception e){
					logger.error("createConsultaHis() - No se pudo convertir el id paciente de String a UUID - error{}",e);
				}
				consultaView.setIdPaciente(idpaciente);
			}else {
				error=Boolean.TRUE;
			}
		}
		if(!error) {
			consultaView.setConsultaHis(Boolean.TRUE);
			consultaView.setEstadoConsulta("Nueva");
			consultaView.setIdEstadoConsulta(1);
			logger.info("createConsultaHis() - Creando Consulta:{}",consultaView);
			ConsultaView consultaResponse=consultaRest.createdConsulta(consultaView);
			Long idConulta=consultaResponse.getIdConsulta();
			return idConulta;
		}
		return null;
	}

	private PacientePageView buscarPaciente(String datosBusqueda, String curp) throws PacienteException {
		Page<PacientePageView> pacientePage=null;
		if(!curp.isEmpty() && curp != null) {
			logger.info("buscarPaciente() - Buscando Paciente por curp:{}",curp);
			pacientePage=pacienteRest.getPacienteSearch(Boolean.TRUE, null, null, null, null, null, null, null, null, curp, null, null, null, null);
		}else {
			logger.info("buscarPaciente() - Buscando paciente por nombre:{}",datosBusqueda);
			pacientePage = pacienteRest.getPacienteSearch(Boolean.TRUE, datosBusqueda, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		PacientePageView pv = null;
		if(pacientePage.getNumberOfElements() > 0) {
			pv = pacientePage.getContent().get(0);
		}else {
			logger.info("buscarPaciente() -No se encontro paciente los datos nombre:{}, curp:{}", datosBusqueda, curp);
		}
		return pv;
	}

	private PacienteView pacienteConverter(PacienteHis pacientehis, PacienteView paciente) {
		paciente.setNombre(pacientehis.getNombrePaciente());
		paciente.setApellidoPaterno(pacientehis.getApellidoPaterno());
		paciente.setApellidoMaterno(pacientehis.getApellidoMaterno());
		paciente.setSexo(pacientehis.getSexo());
		paciente.setEstadoCivil(pacientehis.getEstadoCivil());
		paciente.setReligion(pacientehis.getReligion());
		paciente.setFechaNacimiento(pacientehis.getFechaNacimiento());
		paciente.setLugarNacimiento(pacientehis.getLugarDeNacimiento());
		paciente.setCurp(pacientehis.getCurp());
		paciente.setEmail(pacientehis.getEmail());
		paciente.setTelefonoCelular(pacientehis.getTelefonoCelular());
		paciente.setTelefonoLocal(pacientehis.getTelefonoLocal());
		paciente.setNumeroAfiliacion(pacientehis.getNumeroAfiliacion());
		paciente.setNumeroExpediente(pacientehis.getNumeroExpediente());
		paciente.setTipoSangre(pacientehis.getTipoSangre());
		paciente.setPacienteAtendido(paciente.getPacienteAtendido());
		return paciente;

	}

	private String generarUserName(PacienteHis pacientehis) {
		String username="";
		username= pacientehis.getNombrePaciente().substring(0, 2)+pacientehis.getApellidoPaterno().substring(0, 2);
		if(pacientehis.getApellidoMaterno()!= null && !pacientehis.getApellidoMaterno().isEmpty()) {
			username=pacientehis.getApellidoMaterno().substring(0, 2);
		}
		Random random = new Random();
		username+=""+random.nextInt(999);
		return username.toLowerCase();
	}


}
