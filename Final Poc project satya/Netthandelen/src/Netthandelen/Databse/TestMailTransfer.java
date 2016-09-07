package Netthandelen.Databse;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class TestMailTransfer {
	
	public static void main(String[] args) {
		
		
		  // Get the session object

          String to = "ravinder.kumar@espire.com";
		  Properties props = new Properties ();		  
		  props.put("mail.smtp.host", "mail.espire.com");
		  props.put("mail.smtp.socketFactory.port", "443");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "443");
		  
Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		  {
		   protected PasswordAuthentication getPasswordAuthentication() 
		   {
		   return new PasswordAuthentication("satyanand.patel@espire.com", "Espires123");		   
		   }
		  });		  
		  
		  // compose message for email 
		 
		try 
		  {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("satyanand.patel@espire.com"));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		   message.setSubject("Hello ");
		   message.setText("Please check");
		   
		   // send message
		   Transport.send(message);
		   System.out.println("mail  sent successfully");

		  } 
		  catch (MessagingException e) 
		  {
		   throw new RuntimeException(e);
		  }
		  
	}



}
