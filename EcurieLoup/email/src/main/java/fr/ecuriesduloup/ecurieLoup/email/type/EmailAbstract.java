package fr.ecuriesduloup.ecurieLoup.email.type;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class EmailAbstract implements Email{
	protected MimeMessage messageMime;
	private final static String HOST_SMTP = "localhost"; 
	
	public EmailAbstract() {
		Properties props = System.getProperties(); // laisser "mail.smtp.host" en dur 
		props.put("mail.smtp.host", EmailAbstract.HOST_SMTP);
		
		Session maSession = Session.getDefaultInstance(props, null);
		this.messageMime =  new MimeMessage(maSession);
	}

	@Override
	public void addReceiver(String emailAdressReceveiver) {
		try {
			this.messageMime.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAdressReceveiver));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addReceivers(List<String> emailAdressReceveivers) {
		for(String emailAdressReceveiver : emailAdressReceveivers){
			this.addReceiver(emailAdressReceveiver);
		}
		
	}

	@Override
	public void sendEmail() {
		try {
			Transport.send(messageMime);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setFrom(String emailAdressSender) {
		try {
			this.messageMime.setFrom(new InternetAddress(emailAdressSender));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
	}

	

	@Override
	public void setSubject(String subject) {
		try {
			this.messageMime.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	

}
