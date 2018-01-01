package com.java.Controller;
import java.util.Properties;
import java.util.Random;

import com.java.Bean.RegistrationBean;
import com.java.DaoImpl.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import org.apache.log4j.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

@Path("/email")
public class MailService {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	RegistrationDAOImpl registerdao = new RegistrationDAOImpl();
	static Logger logger = Logger.getLogger(MailService.class);

 
	@GET
    @Path("/send/{uname}")
	public  void generateAndSendEmail(@Context HttpServletRequest request, @PathParam("uname") String uname) throws AddressException, MessagingException {
		String email = registerdao.getEmailByUserName(uname);
		logger.info("email retrieved:"+ email);
		
		String name = registerdao.getNameByUserName(uname);
        
		// Step1
		logger.info("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		logger.info("Mail Server Properties have been setup successfully..");
 
		// Step2
		logger.info("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("webspidersdev@gmail.com"));
		generateMailMessage.setSubject("Payment Succesful.");
		String emailBody = "Hi "+name+ "<br><br>Greetings from Ebookstore. Thank for your order." + "<br><br> Regards, <br>EcommerceBookstore Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		logger.info("Mail Session has been created successfully..");
 
		// Step3
		logger.info("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "webspidersdev@gmail.com", "lolocarrotpappu");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}