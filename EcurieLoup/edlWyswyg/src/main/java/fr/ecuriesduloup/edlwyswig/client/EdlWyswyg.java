package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EdlWyswyg implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
	.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		Board board = new Board();


		RootPanel.get("test").add(board);
		/*AbsolutePanel boundaryPanel = new AbsolutePanel();
		boundaryPanel.setSize("500px", "500px");
		//boundaryPanel.getElement().getStyle().setBackgroundColor("yellow");
		
		AbsolutePanel targetPanel = new AbsolutePanel();
		targetPanel.setSize("100px,", "100px");
		targetPanel.getElement().getStyle().setBackgroundColor("red");
		
		RootPanel.get().add(boundaryPanel);
		boundaryPanel.add(targetPanel, 10, 10);
		
		PickupDragController dragController = new PickupDragController(boundaryPanel, true);
		
		dragController.setBehaviorConstrainedToBoundaryPanel(false);
		
		dragController.setBehaviorMultipleSelection(true);
		
		DropController dropController = new AbsolutePositionDropController(targetPanel);
		dragController.registerDropController(dropController);
		
		Label label = new Label("Label à déplacer");
		targetPanel.add(label, 0, 0);
		
		dragController.makeDraggable(label);*/
		
	}


}
