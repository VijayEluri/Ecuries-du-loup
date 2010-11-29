package fr.ecuriesduloup.ecurieLoup.email.type;

import javax.mail.MessagingException;

public class EmailHtml extends EmailAbstract implements Email{

	@Override
	public void setMessage(String message) {
		try {
			this.messageMime.setContent(message, "text/html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
