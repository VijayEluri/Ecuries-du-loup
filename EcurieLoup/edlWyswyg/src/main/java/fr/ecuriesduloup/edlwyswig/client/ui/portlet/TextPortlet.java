package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;

public class TextPortlet extends Portlet {
	private RichTextEditor richTextEditor;
	private Canvas htmlCanvas;
	private HorizontalPanel panel;
	
	public TextPortlet(PortletController windowController, Board board) {
		super(windowController, board);
		
		this.panel = new HorizontalPanel();
		
		this.createTextArea();
		this.createCanevas();
		

		this.defineCenter(this.panel);

		this.setContentSize(540, 200);
	}
	
	private void createTextArea(){
		this.richTextEditor  = new RichTextEditor();  
		 
		this.richTextEditor.setCanDragResize(true);  
		//this.richTextEditor.setShowEdges(true);  
		
		this.richTextEditor.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				select();
				
			}
		});
		
		//this.richTextEditor.setVisible(false);
		//this.panel.add(this.richTextEditor);
	}
	
	private void createCanevas(){
		this.htmlCanvas = new Canvas();  
		//this. htmlCanvas.setHeight(130);  
		this. htmlCanvas.setPadding(2);  
		
		this. htmlCanvas.setCanDragResize(true);  
    //    this.htmlCanvas.setShowEdges(true);  
        this.panel.add(this.htmlCanvas);
		
	}
	
	@Override
	protected void select() {
		super.select();
		//this.richTextEditor.setVisible(true);
		//this.htmlCanvas.setVisible(false);
		this.panel.remove(this.htmlCanvas);
		this.panel.add(this.richTextEditor);
		
		String content = this.richTextEditor.getValue();
		htmlCanvas.setContents(content);
	}
	@Override
	public void unSelect() {
		super.unSelect();

		String content = this.richTextEditor.getValue();

		this.panel.add(this.htmlCanvas);
		this.panel.remove(this.richTextEditor);
		
		System.out.println(content);
		htmlCanvas.setContents(content);
	}

	@Override
	public void setContentSize(int width, int height) {
		super.setContentSize(width, height);
		
		int contentHeight = height - 10 - this.getContentPortlet().getHeaderOffsetHeight();
		System.out.println(height +" "+ contentHeight);
		this.htmlCanvas.setHeight(contentHeight);
		this.htmlCanvas.setWidth(width);
		
		this.richTextEditor.setHeight(contentHeight);
		this.richTextEditor.setWidth(width);
	}


}
