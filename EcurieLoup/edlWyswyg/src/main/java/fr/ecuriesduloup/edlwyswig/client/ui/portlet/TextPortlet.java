package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;

public class TextPortlet extends Portlet {
	private RichTextSwitcher richTextSwitcher;
	private HorizontalPanel panel;
	
	public TextPortlet(PortletController windowController, Board board) {
		super(windowController, board);
		
		this.panel = new HorizontalPanel();
		
		this.createTextArea();
		

		this.defineCenter(this.panel);

		this.setContentSize(540, 200);
	}
	
	private void createTextArea(){
		this.richTextSwitcher  = new RichTextSwitcher(); 
		this.panel.add(this.richTextSwitcher);
		this.richTextSwitcher .switchText(RichTextBoxSwitcherValue.VIEW);
	}
	
	
	/*@Override
	protected void select() {
		super.select();
		this.richTextSwitcher.switchText(RichTextBoxSwitcherValue.EDIT);
	}*/
	@Override
	public void unSelect() {
		super.unSelect();
		this.richTextSwitcher.switchText(RichTextBoxSwitcherValue.VIEW);
	}

	@Override
	public void setContentSize(int width, int height) {
		super.setContentSize(width, height);
		
		int contentHeight = height - this.getContentPortlet().getHeaderOffsetHeight();
		System.out.println(height +" "+ contentHeight);
		this.richTextSwitcher.setContentSize(width, contentHeight);
	}
	
	@Override
	public void onPreviewDragStart() {
		
		super.onPreviewDragStart();
		
		this.richTextSwitcher.saveState();
	}

	@Override
	public void onPreviewDragEnd() {
		super.onPreviewDragEnd();
		this.richTextSwitcher.restoreState();
	}

}
