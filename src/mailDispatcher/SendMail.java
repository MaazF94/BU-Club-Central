package mailDispatcher;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.simplejavamail.*;
//import org.simplejavamail.util.*;
//import org.simplejavamail.email.Email;
//import org.simplejavamail.mailer.Mailer;
//import org.simplejavamail.mailer.config.TransportStrategy;

public class SendMail {
	public static void email(String fromEmail, final String username, final String password, String toEmail, String subject,
			String content) {
		//set properties to send email by
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(fromEmail));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(toEmail));

	         // Set Subject: header field
	         message.setSubject(subject);
	         
	         // Now set the actual message
	         message.setContent(content, "text/html");

	         // Send message
	         Transport.send(message);

	        // System.out.println("Sent message successfully...");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	}
}
//	public static void email(String fromEmail, String username, String password, String toEmail, String subject,
//			String content) {
//		Email email = new Email();
//        email.setFromAddress(username, fromEmail);
//        email.setSubject(subject);
//        email.addRecipient(toEmail, toEmail, Message.RecipientType.TO);
//        email.setTextHTML(content);
//
//        new Mailer("smtp.gmail.com", 587, username, password, TransportStrategy.SMTP_TLS).sendMail(email);
//	}
//}
