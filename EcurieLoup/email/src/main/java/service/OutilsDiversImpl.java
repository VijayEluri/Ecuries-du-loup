package service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OutilsDiversImpl implements OutilsDivers {
	private String hostSmtp = "localhost"; 
	@Override
	public void envoyerEmail(String adresseDestinataire,
			String adresseEmettreur, String sujet, String message) {

		try { 
			Properties props = System.getProperties(); // laisser "mail.smtp.host" en dur 
			props.put("mail.smtp.host", hostSmtp);

			// javax.mail.Session pour que ça fonctionne aussi avec WebObjects
			Session maSession = Session.getDefaultInstance(props, null);
			MimeMessage	messageMime = new MimeMessage(maSession);
			messageMime.setFrom(new InternetAddress(adresseEmettreur));
			messageMime.addRecipient(Message.RecipientType.TO, new InternetAddress(adresseDestinataire));
			//message.addRecipient(Message.RecipientType.CC, newInternetAddress(emailCc));
			messageMime.setSubject(sujet);
			messageMime.setContent(message, "text/html");
			Transport.send(messageMime);
		} catch (AddressException e) {
			e.printStackTrace(); 
		} catch (MessagingException e) {
			e.printStackTrace(); 
		}

	}

	public static void main(String[] args) {
		OutilsDivers outils = new OutilsDiversImpl();
		outils.envoyerEmail("la_miss_oriane@hotmail.fr", "krack_6@ecuriesduloup.fr",
				"sujet test", "Est ce que t'a recu ce message ?? <br /> plus une petite pub : <a href=\"http://www.ecuriesduloup.fr\">http://www.ecuriesduloup.fr</a> lol");
	}

}
