package fr.ecuriesduloup.edlwyswig.client.ui.board;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;

import fr.ecuriesduloup.edlwyswig.client.CssResources;

public class BoardTable extends Composite{
	private Panel elementPanel;
	private Board board;
	
	public BoardTable(Board board) {
		this.board = board;
		
		this.elementPanel = new HorizontalPanel();
		
		
		PickupDragController dragController = new PickupDragController(this.board.getTotalPanelOfBoard(), false);
		
		//garde le proxy en place 
		dragController.setBehaviorDragProxy(true);
		
		MyAbsolutePositionDropController dropController = new MyAbsolutePositionDropController(this.board.getBoardPanel(), this.board);
		dragController.registerDropController(dropController);
		
		
		BoardElement element = new BoardElement(this.board);
		this.elementPanel.add(element);
		dragController.makeDraggable(element);
		
		ImageBoardElement imageelement = new ImageBoardElement(this.board);
		this.elementPanel.add(imageelement);
		dragController.makeDraggable(imageelement);
		
		
		initWidget(this.elementPanel);
		initStyle();
	}
	
	private void initStyle(){
		BoardCss boardCss = CssResources.INSTANCE.boardCss();
		StyleInjector.inject(boardCss.getText());
		this.addStyleName(boardCss.boardTable());	
	}
}
