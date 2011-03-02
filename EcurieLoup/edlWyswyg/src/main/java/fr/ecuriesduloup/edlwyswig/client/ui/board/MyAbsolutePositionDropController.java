package fr.ecuriesduloup.edlwyswig.client.ui.board;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.AbsolutePositionDropController;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class MyAbsolutePositionDropController extends AbsolutePositionDropController {
	private Board board;

	public MyAbsolutePositionDropController(AbsolutePanel dropTarget, Board board) {
		super(dropTarget);
		this.board = board;
	}

	@Override
	public void onDrop(DragContext context) {
		
		int x = context.desiredDraggableX - context.boundaryPanel.getAbsoluteLeft();
		int y = context.desiredDraggableY - this.board.getBoardPanel().getAbsoluteTop();

		BoardElement element = (BoardElement)context.draggable;
		element.createAndAddPortletOnBoard(x, y);
	}

}
