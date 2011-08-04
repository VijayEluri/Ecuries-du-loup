package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WysiwygServiceAsync {

	public void generateHtml(String truc, AsyncCallback<String> asyncCallback) ;

}
