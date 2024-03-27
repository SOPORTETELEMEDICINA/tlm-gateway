package net.amentum.niomedic.niogateway.api.rest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class Email {

    public boolean sendEmail(String title, String recipient, Map<String, String> replacements) throws Exception {
        String message = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\t<head>\n" +
                "\t\t<title>CSS Template</title>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<header style=\"background-color: #7CB1C2;\">\n" +
                "\t\t\t<h1 style=\"font-size: 20px; letter-spacing: 1px; text-transform: uppercase; text-align: center; \">Generaci&#243;n de nuevo usuario</h1>\n" +
                "\t\t</header>\n" +
                "\t\t<section>\n" +
                "\t\t\t<h3 style=\"font-size: 17px; letter-spacing: 1px; text-transform: uppercase;  color: #25ad9c;\">  EL PRESENTE CORREO ES PARA NOTIFICAR LA GENERACI&#211;N DE SU NUEVO USUARIO.</h3><br></br>\n" +
                "\t\t\t<h3 style=\"font-size: 15px; letter-spacing: 1px; color: #25ad9c;\">   USUARIO: <STRONG>{{username}}</STRONG></h3>\n" +
                "\t\t\t<h3 style=\"font-size: 15px; letter-spacing: 1px; color: #25ad9c;\">   CORREO:  <STRONG>{{email}}</STRONG></h3>\n" +
                "\t\t\t<h3 style=\"font-size: 15px; letter-spacing: 1px; color: #25ad9c;\">   CONTRASE&#209;A: <STRONG>{{code}}</STRONG></h3>\n" +
                "<br></br><br></br><br></br><br></br>\n" +
                "\t\t\t<h1 style=\"font-size: 25px; letter-spacing: 1px; text-transform: uppercase;  color: #25ad9c;\">   <STRONG>Android:</STRONG></h1>\n" +
                "\t\t\t<a href=\"https://play.google.com/store/apps/details?id=com.tmesalud.telemetria\" style=\"font-size: 40px; text-align: center;\">Play Store</a>\n" +
                "<br></br><br></br><br></br>\n" +
                "\t\t\t<h1 style=\"font-size: 25px; letter-spacing: 1px; text-transform: uppercase;  color: #25ad9c;\">   <STRONG>iPhone:</STRONG></h1>\n" +
                "\t\t\t<a href=\"https://apps.apple.com/mx/app/cm-monitoreo-pacientes/id1585180778\" style=\"font-size: 40px; text-align: center;\">App Store</a>\n" +
                "\t\t</section>\t  \n" +
                "\t</body>\n" +
                "</html>";
        for (Map.Entry<String, String> entry : replacements.entrySet())
            message = message.replace("{{" + entry.getKey() + "}}", entry.getValue());
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.host", "mail.telemedicina.lat");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("noresponder@telemedicina.lat", "Z{hcvq1x}T9.");
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("noresponder@telemedicina.lat", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            msg.setSubject(title);
            msg.setContent(message, "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            Transport.send(msg);
            return true;
        }catch (Exception ex) {
            throw ex;
        }
    }

}
