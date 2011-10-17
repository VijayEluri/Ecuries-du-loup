package fr.ecuriesduloup.webnotifier.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.webnotifier.client.ui.news.Notifier;

public class NotifierEntryPoint implements EntryPoint{
		
	@Override
	public void onModuleLoad() {
		Notifier mediaNotifer = Notifier.createMediaNotifier();
		RootPanel.get("test").add(mediaNotifer);
		mediaNotifer.run();
		
	}

}
