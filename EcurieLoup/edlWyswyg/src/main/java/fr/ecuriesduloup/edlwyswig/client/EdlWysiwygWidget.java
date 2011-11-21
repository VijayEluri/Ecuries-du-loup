package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletAdder;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.blockportlet.BlockPortletAdder;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.imageportlet.ImagePortletAdder;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.textportlet.TextPortletAdder;

public class EdlWysiwygWidget extends Composite{
	private Board board;
	
	public EdlWysiwygWidget() {
		CssResources.INSTANCE.boardCss().ensureInjected();
		CssResources.INSTANCE.portletCss().ensureInjected();

		this.board = new Board();	
		
		PortletAdder textPorlet = new TextPortletAdder();
		board.addPortletAdder(textPorlet);
		PortletAdder imagePorlet = new ImagePortletAdder();
		board.addPortletAdder(imagePorlet);
		PortletAdder blockPorlet = new BlockPortletAdder();
		board.addPortletAdder(blockPorlet);
		this.initWidget(board);
		
		this.addStyleName(CssResources.INSTANCE.boardCss().edlWysiwygWidget());
		
	}
	
	public Button createButtonPreview(){
		return this.board.createButtonPreview();
	}
}
