package fr.ecuriesduloup.webnotifier.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("webnotifier")
public interface WebNotifierService extends RemoteService{

	public int getNumberNotReadMedia();
	public int getNumberNotReadForum();
}
