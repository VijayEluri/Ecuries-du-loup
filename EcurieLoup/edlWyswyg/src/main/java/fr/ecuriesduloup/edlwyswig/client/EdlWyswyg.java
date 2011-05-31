package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;
import fr.ecuriesduloup.edlwyswig.client.ui.portletAdder.BlockPortletAdder;
import fr.ecuriesduloup.edlwyswig.client.ui.portletAdder.ImagePortletAdder;
import fr.ecuriesduloup.edlwyswig.client.ui.portletAdder.TextPortletAdder;



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


		Board board = new Board();

		
		
		
		
		TextPortletAdder testAdder = new TextPortletAdder();
		board.addPortletAdder(testAdder);
		ImagePortletAdder testAdder2 = new ImagePortletAdder();
		board.addPortletAdder(testAdder2);
		BlockPortletAdder testAdder3 = new BlockPortletAdder();
		board.addPortletAdder(testAdder3);
		

		RootPanel.get("test").add(board);
		
	}


}
