package fr.ecuriesduloup.edlwyswig.client.ui.board;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import fr.ecuriesduloup.edlwyswig.client.AbstractCompositeWithMouseHandler;
import fr.ecuriesduloup.edlwyswig.client.CssResources;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;

public class BoardElement extends AbstractCompositeWithMouseHandler implements PortletConstructor{
	private SimplePanel panel;
	private Board board;

	public BoardElement(Board board){
		this.board = board;
		this.panel = new SimplePanel();

		Image image = new Image("http://allen-sauer.com/com.allen_sauer.gwt.dnd.demo.DragDropDemo/images/99pumpkin2-65x58.jpg");
		this.panel.add(image);
		initWidget(this.panel);
		initStyle();
		//	super("http://allen-sauer.com/com.allen_sauer.gwt.dnd.demo.DragDropDemo/images/99pumpkin2-65x58.jpg");
	}

	private void initStyle(){
		BoardCss boardCss = CssResources.INSTANCE.boardCss();
		StyleInjector.inject(boardCss.getText());
		this.addStyleName(boardCss.boardElement());	
	}
	@Override
	public Portlet createAndAddPortletOnBoard(int x, int y) {		
		return this.board.addPortlet(x, y);
	}

	protected Board getBoard(){
		return this.board;
	}



}
