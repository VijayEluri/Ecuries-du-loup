package fr.ecuriesduloup.ecurieLoup.email.service.user;

import donnees.User;

public interface SendEmailUser {

	public void sendEmailRegistration(User user);
	
	public void sendEmailLosePassword(User user);
	
}
