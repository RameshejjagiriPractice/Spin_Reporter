package com.spin.main.service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.spin.main.model.usermaster;



@Service
public class EmailService {
	// @Autowired
	private Properties emailProperties;
	// @Autowired
	private Session mailSession;
	// @Autowired
	private MimeMessage emailMessage;

	private static String otp;


	//this one api
	public void sendEmail(usermaster usermaster, String verficationCode) {

		//System.out.println("verification after email:-----" + verficationCode);
		this.otp = verficationCode;
		EmailService javaEmail = new EmailService();

		javaEmail.setMailServerProperties();
		try {
			javaEmail.createEmailMessage(usermaster.getEmailid(), usermaster.getEmailid());
			javaEmail.sendEmail();
		} catch (MessagingException e) {
			// TODO: handle exception
			System.out.println("messaging exception");
			e.printStackTrace();
		}
	}

	
	//this one web
		public void sendEmailWeb(usermaster usermaster) {

			EmailService javaEmail = new EmailService();

			javaEmail.setMailServerProperties();
			try {
				javaEmail.createWebEmailMessage(usermaster.getEmailid(), usermaster.getEmailid());
				javaEmail.sendEmail();
			} catch (MessagingException e) {
				// TODO: handle exception
				System.out.println("messaging exception");
				e.printStackTrace();
			}
		}
	public void setMailServerProperties() {

		String emailPort = "587";// gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		// emailProperties.put("mail.smtp.starttls.required", "true");
	}

	public void createEmailMessage(String toEmail, String name) throws AddressException, MessagingException {
		// String[] toEmails = { toEmail };
		String toEmails2 = toEmail;
		
		String emailSubject = "Welcome!";
		String emailBody = "<p>Hi <h3>" + name + "</h3></p><br><p>Thanks for registering with us.</p>"
				+ "<p>your verfication code is: <span>" + otp + "</span></p>" + "<p>Warm Regards</p>"
				+ "<p>Spin Reporter Team</p>";
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails2));

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");// for a html email
		// emailMessage.setText(emailBody);// for a text email

	}
	
	
	public void createWebEmailMessage(String toEmail, String name) throws AddressException, MessagingException {
		// String[] toEmails = { toEmail };
		//http://14.98.166.66:9090/Spin_Reporter/reset_password
		//http://localhost:9092/reset_password
		String toEmails2 = toEmail;
		
		String emailSubject = "Welcome!";
		String emailBody = "<p>Hi <h3>" + name + "</h3></p><br><p>Thanks for registering with us.</p>"
				+ "<p>your reset password link: <span>" +"http://14.98.166.66:9090/Spin_Reporter/reset_password" + "</span></p>" + "<p>Warm Regards</p>"
				+ "<p>Spin Reporter Team</p>";
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails2));

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");// for a html email
		// emailMessage.setText(emailBody);// for a text email

	}

	// collegeconnectap@gmail.com
	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		/*String fromUser = "collegeconnectap@gmail.com";// just the id alone without @gmail.com
		String fromUserEmailPassword = "qwz123456789";*/

		String fromUser = "spinreporter@gmail.com";// just the id alone without @gmail.com
		String fromUserEmailPassword = "great5067";
		
		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}
}
