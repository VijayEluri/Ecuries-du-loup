package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EdlWyswyg implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new ClientExceptionHandler());

		EdlWysiwygWidget edlWysiwygWidget = new EdlWysiwygWidget();
		
		Button view= edlWysiwygWidget.createButtonPreview();
		
		RootPanel.get("test").add(edlWysiwygWidget);
		RootPanel.get("test2").add(view);
		
	}
	
	public class ClientExceptionHandler implements GWT.UncaughtExceptionHandler {


		@Override
		public void onUncaughtException(Throwable cause) {
		cause.printStackTrace();
		}



		} 


}
