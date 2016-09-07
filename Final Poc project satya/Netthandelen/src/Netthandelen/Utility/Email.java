package Netthandelen.Utility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;





public class Email {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 execute("Report.zip");
	  }
	  
	  //reportFileName = "C:\\JAVA_PROJECTS\\Demo\\Reports.zip";
	  public static void execute(String reportFileName) throws Exception

	  {
	  String Report="C://Users\\satyanand.patel\\workspace\\Netthandelen\\Reports.zip";

	  String[] to={"ravinder.kumar@espire.com"};
	  String[] cc={};
	  String[] bcc={"satyanand.patel@espire.com"};

	  Email.sendMail("satyanand.patel@espire.com",
	  "Espires@345",
	  "outlook.office365.com",
	  "587",
	  "true",
	  "true",
	  true,
	  
	  "false",
	  to,
	  cc,
	  bcc,
	  "Selenium Report",
	  "Please find the attached report for selenium test run",
	  Report,
	  reportFileName);
	  }

	  public static boolean sendMail(String userName,
	  String passWord,
	  String host,
	  String port,
	  String starttls,
	  String auth,
	  boolean debug,
	  
	  String fallback,
	  String[] to,
	  String[] cc,
	  String[] bcc,
	  String subject,
	  String text,
	  String attachmentPath,
	  String attachmentName){

	  //Object Instantiation of a properties file.
	  Properties props = new Properties();

	  props.put("mail.smtp.user", "satyanand.patel@espire.com");
	  

	  props.put("mail.smtp.host", "outlook.office365.com");

	  if(!"".equals(port)){
	  props.put("mail.smtp.port", "587");
	  }

	  if(!"".equals(starttls)){
	  props.put("mail.smtp.starttls.enable",starttls);
	  props.put("mail.smtp.auth", auth);
	  }

	  if(debug){

	  props.put("mail.smtp.debug", "true");

	  }else{

	  props.put("mail.smtp.debug", "false");

	  }

	  if(!"".equals(port)){
	  props.put("mail.smtp.socketFactory.port", port);
	  }
	  
	  if(!"".equals(fallback)){
	  props.put("mail.smtp.socketFactory.fallback", fallback);
	  }

	  try{
		  
		 /* SMTPAuthenticator authenticator = new SMTPAuthenticator(userName, passWord);
	      props.put("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
	      Session session = Session.getInstance(props, authenticator);*/

	  Session session = Session.getDefaultInstance(props, null);

	  session.setDebug(debug);

	  MimeMessage msg = new MimeMessage(session);

	  msg.setText(text);

	  msg.setSubject(subject);

	  Multipart multipart = new MimeMultipart();
	  MimeBodyPart messageBodyPart = new MimeBodyPart();
	  DataSource source = new FileDataSource(attachmentPath);
	  messageBodyPart.setDataHandler(new DataHandler(source));
	  messageBodyPart.setFileName(attachmentName);
	  multipart.addBodyPart(messageBodyPart);

	  msg.setContent(multipart);
	  msg.setFrom(new InternetAddress(userName));

	  for(int i=0;i<to.length;i++){
	  msg.addRecipient(Message.RecipientType.TO, new
	  InternetAddress(to[i]));
	  }

	  for(int i=0;i<cc.length;i++){
	  msg.addRecipient(Message.RecipientType.CC, new
	  InternetAddress(cc[i]));
	  }

	  for(int i=0;i<bcc.length;i++){
	  msg.addRecipient(Message.RecipientType.BCC, new
	  InternetAddress(bcc[i]));
	  }

	  msg.saveChanges();

	  Transport transport = session.getTransport("smtp");
	  
	  
	  
	    
	  transport.connect(host, userName, passWord);

	  transport.sendMessage(msg, msg.getAllRecipients());
	  
	  transport.close();

	  return true;

	  } catch (Exception mex){
	  mex.printStackTrace();
	  return false;
	  }
	  }

	 }