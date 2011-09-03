package fr.ecuriesduloup.edlwyswig.client.ui.portletAdder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;

public abstract class PortletAdder extends Canvas{
	protected static final PortletResources portletResources = GWT.create(PortletResources.class);

	public PortletAdder() {
		this.addChild(this.getImage());
		this.setCanDrag(true);  
		this.setCanDrop(true);  
		this.setDragType("P");
		this.setDragAppearance(DragAppearance.TRACKER);  
	}

	protected abstract Image getImage();

	public abstract Portlet createPorlet() ;

	@Override  
	protected boolean setDragTracker() {  
		EventHandler.setDragTracker(Canvas.imgHTML(this.getImage().getUrl(), 25, 25), 25, 25, 15, 15);  
		return false;  
	}  

}
