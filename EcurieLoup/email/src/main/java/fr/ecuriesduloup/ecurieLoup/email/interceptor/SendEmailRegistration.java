package fr.ecuriesduloup.ecurieLoup.email.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import donnees.User;
import fr.ecuriesduloup.ecurieLoup.email.service.user.SendEmailUser;

public class SendEmailRegistration implements MethodInterceptor{
	private List<User> emailSendFor;
	private SendEmailUser sendEmailUser;

	public SendEmailRegistration() {
		this.emailSendFor = new ArrayList<User>();
	}
	public void setSendEmailUser(SendEmailUser sendEmailUser) {
		this.sendEmailUser = sendEmailUser;
	}
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		method.proceed();

		User user = (User)method.getArguments()[0];
		if(!this.emailSendFor.contains(user)){
			this.emailSendFor.add(user);
			this.sendEmailUser.sendEmailRegistration(user);			
		}


		return null;
	}








}
