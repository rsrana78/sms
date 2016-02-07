package com.ayp.sms.email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.ayp.sms.log.SMSLogger;
import com.sun.mail.smtp.SMTPTransport;

/**
 * 
 * @author rana
 *
 */

public class Email {
	
	private static final Logger LOGGER = Logger.getLogger(SMSLogger.class.getName());
	
	private String host;
	private String user;
	private String password;
	private String protocol;
	private String emailFrom;
	private String emailReply;
	private Integer port;
	private boolean verbose;

	private Properties emailHostProperties;
	private Properties smtpProperties;

	private Session session;

	public Email() throws IOException, FileNotFoundException {
		emailHostProperties = new Properties();
		smtpProperties = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream("/email.properties");
		emailHostProperties.load(inputStream);
		if (inputStream != null){
			inputStream.close();
		}
		user = (String) emailHostProperties.get("mail.user");
		password = (String) emailHostProperties.get("mail.password");
		host = (String) emailHostProperties.get("mail.smtp.host");
		emailFrom = (String) emailHostProperties.get("mail.from");
		emailReply = (String) emailHostProperties.get("mail.reply");
		protocol = (String) emailHostProperties.get("mail.transport.protocol");
		port = Integer.parseInt((String) emailHostProperties.get("mail.port"));
		verbose = Boolean.parseBoolean((String) emailHostProperties.get("mail.verbose"));
		// Configuration for Session instance
		smtpProperties.put("mail.smtp.host", emailHostProperties.get("mail.smtp.host"));
		smtpProperties.put("mail.debug", emailHostProperties.get("mail.debug"));
		smtpProperties.put("mail.smtps.auth", emailHostProperties.get("mail.smtps.auth"));
		smtpProperties.put("mail.smtp.starttls.enable", emailHostProperties.get("mail.smtp.starttls.enable"));
		smtpProperties.put("mail.smtp.ssl.trust", emailHostProperties.get("mail.smtp.host"));
		if (port.equals(587)) {
			smtpProperties.put("mail.smtp.port", port);
			smtpProperties.put("mail.smtp.socketFactory.port", port.toString());
		}
		session = Session.getInstance(smtpProperties);
	}
	
	public boolean sendNormalEmail(String to, String cc, String bcc,String replyEmail, String subject, String body) throws MessagingException {
		MimeMessage message = createMimeMessage(to, cc, bcc, replyEmail,	subject);
		message.setHeader("Content-Type", "text/html; charset=UTF-8");
		message.setHeader("Content-Transfer-Encoding", "quoted-printable");
		message.setContent(body, "text/html; charset=UTF-8");
		sendMessage(message);
		LOGGER.info("Mail sent successfully.");
		return true;
	}

	public boolean sendEmailwithAttachments(String to, String cc, String bcc, String subject, String body, List<String> fullFilesPathsToAttach)
			throws MessagingException {
		MimeMessage message = createMimeMessage(to, cc, bcc, emailReply, subject);
		message.setHeader("Content-Type", "text/html; charset=UTF-8");
		message.setHeader("Content-Transfer-Encoding", "quoted-printable");
		Multipart multipart = new MimeMultipart();
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(body, "text/html; charset=UTF-8");
		multipart.addBodyPart(bodyPart);
		MimeBodyPart attachmentPart = null;
		FileDataSource fileDataSource = null;
		if (fullFilesPathsToAttach != null) {
			for (String fileToAttach : fullFilesPathsToAttach) {
				attachmentPart = new MimeBodyPart();
				fileDataSource = new FileDataSource(fileToAttach);
				attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				attachmentPart.setFileName(fileDataSource.getName());
				multipart.addBodyPart(attachmentPart);
			}
		}
		message.setContent(multipart, "text/html; charset=UTF-8");
		sendMessage(message);
		LOGGER.info("Mail sent successfully");
		return true;
	}

	private MimeMessage createMimeMessage(String to, String cc, String bcc, String emailReply, String Subject) throws MessagingException {
		MimeMessage msg = new MimeMessage(session);
		if(emailReply != null)
			msg.setReplyTo(new javax.mail.Address[] { new javax.mail.internet.InternetAddress(emailReply) });
		msg.setFrom(new InternetAddress(emailFrom));
		loadEmailTo(msg, to, cc, bcc);
		msg.setSentDate(new Date());
		msg.setSubject(Subject, "utf-8");
		return msg;
	}

	private Message loadEmailTo(Message msg, String to, String cc, String bcc) throws AddressException, MessagingException {
		String[] toList = null;
		String[] ccList = null;
		String[] bccList = null;
		InternetAddress[] toAddress = null;
		InternetAddress[] ccAddress = null;
		InternetAddress[] bccAddress = null;
		int count = 0;
		if (to != null && to.length() > 0) {
			toList = to.trim().split(",");
			toAddress = new InternetAddress[toList.length];
			for (String email : toList) {
				toAddress[count] = new InternetAddress(email.trim());
				count++;
			}
			msg.setRecipients(Message.RecipientType.TO, toAddress);
		}
		if (cc != null && cc.length() > 0) {
			ccList = cc.trim().split(",");
			ccAddress = new InternetAddress[ccList.length];
			count = 0;
			for (String email : ccList) {
				ccAddress[count] = new InternetAddress(email.trim());
				count++;
			}
			msg.setRecipients(Message.RecipientType.CC, ccAddress);
		}
		if (bcc != null && bcc.length() > 0) {
			bccList = bcc.trim().split(",");
			bccAddress = new InternetAddress[bccList.length];
			count = 0;
			for (String email : bccList) {
				bccAddress[count] = new InternetAddress(email.trim());
				count++;
			}
			msg.setRecipients(Message.RecipientType.BCC, bccAddress);
		}
		return msg;
	}

	private void sendMessage(MimeMessage msg) throws MessagingException {
		SMTPTransport smtpTransport = (SMTPTransport) session.getTransport(protocol);
		smtpTransport.connect(host, port, user, password);
		smtpTransport.sendMessage(msg, msg.getAllRecipients());
		if (verbose) {
			LOGGER.info("Response: " + smtpTransport.getLastServerResponse());
		}
		smtpTransport.close();
	}

}
