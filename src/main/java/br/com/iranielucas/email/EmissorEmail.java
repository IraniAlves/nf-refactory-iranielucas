package br.com.iranielucas.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.iranielucas.config.ApplicationConfiguration;
import br.com.iranielucas.entidade.Fatura;

public class EmissorEmail {
	String STR_USERNAME = ApplicationConfiguration.getInstance().getMailUserName();
	String STR_PASSWORD = ApplicationConfiguration.getInstance().getMailPassWord();
	String STR_SMTP = ApplicationConfiguration.getInstance().getMailHostName();
	String STR_FROM = ApplicationConfiguration.getInstance().getMailFrom();
	String STR_TO = ApplicationConfiguration.getInstance().getMailTo();
	
	public void enviarEmail(Fatura f) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", STR_SMTP);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(STR_USERNAME, STR_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(STR_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(STR_TO));
			message.setSubject("Titulo");
			message.setText("Mensagem");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
