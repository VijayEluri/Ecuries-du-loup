package fr.ecuriesduloup.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuries_du_loup.diaporama.client.Diaporama;
import fr.ecuriesduloup.secretflag.client.SecretFlag;
import fr.ecuriesduloup.webnotifier.client.ui.news.Notifier;

public class Gwt implements EntryPoint{

	@Override
	public void onModuleLoad() {
		try{
			//media notifier
			Notifier mediaNotifer = Notifier.createMediaNotifier();
			RootPanel.get("mediaNotifier").add(mediaNotifer);
			mediaNotifer.run();		
		}catch (Exception e) {
		}

		try{
			//forum notifier
			Notifier forumNotifer = Notifier.createForumNotifier();
			RootPanel.get("forumNotifier").add(forumNotifer);
			forumNotifer.run();
		}catch (Exception e) {
		}
		try{
			SecretFlag secretFlag = new SecretFlag();
			RootPanel.get("secretFlag").add(secretFlag);
		}catch (Exception e) {
		}
		try{
			Diaporama diaporama = new Diaporama();
			RootPanel.get("nameFieldContainer").add(diaporama);
		}catch (Exception e) {
		}
	}
}
