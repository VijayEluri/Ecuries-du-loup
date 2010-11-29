package fr.ecuriesduloup.ecurieLoup.email.type;

import java.util.List;

public interface Email {
	
	public void setFrom(String emailAdressSender);
	
	public void addReceivers(List<String> emailAdressReceveivers);
	public void addReceiver(String emailAdressReceveiver);
	
	public void setSubject(String subject);
	
	public void setMessage(String message);
	
	public void sendEmail();
}
