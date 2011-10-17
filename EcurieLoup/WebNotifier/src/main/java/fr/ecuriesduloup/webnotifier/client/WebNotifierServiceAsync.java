package fr.ecuriesduloup.webnotifier.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WebNotifierServiceAsync {

	public void getNumberNotReadMedia(AsyncCallback<Integer> asyncCallback) ;
	public void getNumberNotReadForum(AsyncCallback<Integer> asyncCallback) ;
}
