package fr.ecuries_du_loup.diaporama.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DiaporamaEngineAsync {
	

	public void getIdPhoto(AsyncCallback<List<Integer>> callback);
}
