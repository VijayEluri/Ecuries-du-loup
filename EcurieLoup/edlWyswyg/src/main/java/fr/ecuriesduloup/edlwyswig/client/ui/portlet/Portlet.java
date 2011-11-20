package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;


public abstract class Portlet extends Window implements Element{
	protected static final PortletResources portletResources = GWT.create(PortletResources.class);
	protected static final int PORTLET_DIFF_WIDTH = 14;
	protected static final int PORTLET_DIFF_HEIGHT = 30;
	
	
	public Portlet(){

		this.setTitle(this.getPortletTitle());  
		//this.setWidth(200);  
		//this.setHeight(200);  
		this.setCanDragResize(true); 
		//resize and move is borned at the parent
		this.setKeepInParentRect(true);
		this.setShowMinimizeButton(false);




		this.addItem(this.getContentWidget());  
	}

	protected Widget getContentWidget() {
		Label label = new Label();  
		label.setContents("Click Me");  
		label.setAlign(Alignment.CENTER);  
		label.setPadding(5);  
		label.setHeight100();  
		label.addClickHandler(new ClickHandler() {  
			public void onClick(ClickEvent event) {  
				Portlet.this.setStatus("Click at: " + event.getX() + ", " + event.getY());  
			}  
		});  
		return label;
	}
	
	protected String getPortletTitle(){
		return "Window with footer";
	}
	
	public int getBlockWidth(){
		return this.getOffsetWidth();
	}
	public int getBlockHeight(){
		return this.getOffsetHeight();
	}
	
	public int getBlockTop(){
		return this.getTop();
	}
	
	public int getBlockLeft(){
		return this.getLeft();
	}

	
}
