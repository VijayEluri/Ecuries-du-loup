package fr.ecuriesduloup.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.webnotifier.client.ui.news.Notifier;

public class Gwt implements EntryPoint{
	
	@Override
	public void onModuleLoad() {
		//media notifier
		Notifier mediaNotifer = Notifier.createMediaNotifier();
		RootPanel.get("mediaNotifier").add(mediaNotifer);
		mediaNotifer.run();		
		
		//forum notifier
		Notifier forumNotifer = Notifier.createForumNotifier();
		RootPanel.get("forumNotifier").add(forumNotifer);
		forumNotifer.run();
	}
}
