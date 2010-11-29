package fr.ecuriesduloup.ecurieLoup.email.service.user;

import donnees.User;
import fr.ecuriesduloup.ecurieLoup.email.type.EmailHtmlCustom;
import fr.ecuriesduloup.util.message.MessageI18nManager;

public class SendEmailUserImpl implements SendEmailUser {
	private String adresseEmailUser;
	private MessageI18nManager i18nManager;


	public void setI18nManager(MessageI18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	public void setAdresseEmailUser(String adresseEmailUser) {
		this.adresseEmailUser = adresseEmailUser;
	}

	

	@Override
	public void sendEmailRegistration(User user) {
		EmailHtmlCustom email = new EmailHtmlCustom(user);
		
		email.setFrom(this.adresseEmailUser);
		email.setSubject("Inscription sur ecuriesduloup.fr");
		email.addReceiver(user.getEmail());
		email.setMessage(this.i18nManager.getMessage("email.user.registration"));
		
		email.sendEmail();
		
	}

	@Override
	public void sendEmailLosePassword(User user) {
		EmailHtmlCustom email = new EmailHtmlCustom(user);
		
		email.setFrom(this.adresseEmailUser);
		email.setSubject("Demande de mot de passe sur ecuriesduloup.fr");
		email.addReceiver(user.getEmail());
		email.setMessage(this.i18nManager.getMessage("email.user.losePassword"));
		
		email.sendEmail();
		
	}

}
