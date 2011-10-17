package fr.ecuriesduloup.webnotifier.client.ui.news;

import com.google.gwt.core.client.GWT;

import fr.ecuriesduloup.webnotifier.client.WebNotifierService;
import fr.ecuriesduloup.webnotifier.client.WebNotifierServiceAsync;

public class ForumNotifierService implements NotifierService{
	private final WebNotifierServiceAsync webNotifer = GWT.create(WebNotifierService.class);
	private Notifier notifier;
	
	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}
	
	
	@Override
	public void maj() {
		if(this.notifier==null) return;
		
		this.webNotifer.getNumberNotReadForum(new NotifierAsyncCallback(this.notifier));
	}

}
