package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface WysiwygService extends RemoteService{

	public String generateHtml(String text);
}
