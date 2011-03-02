package fr.ecuriesduloup.edlwyswig.client.ui.board;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;

public class ImageBoardElement extends BoardElement implements PortletConstructor{


	public ImageBoardElement(Board board){
		super(board);
	}


	@Override
	public Portlet createAndAddPortletOnBoard(int x, int y) {		
		return this.getBoard().addImagePortlet(x, y);
	}



}
