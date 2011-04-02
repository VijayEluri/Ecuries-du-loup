package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuriesduloup.edlwyswig.client.CssResources;

public class ContentPortletPanel extends VerticalPanel {
	private HorizontalPanel headerContainer;	
	private PortletHeader headerWidget ;
	private Widget contentWidget;
	private PortletCss portletCss;
	
	public ContentPortletPanel(Portlet portlet){
		this.portletCss = CssResources.INSTANCE.portletCss();
		StyleInjector.inject(this.portletCss.getText());
		this.addStyleName(this.portletCss.portlet());
		
		// creer l'entete
		headerContainer = new HorizontalPanel();
		this.headerWidget = new PortletHeader(portlet);
		headerContainer.addStyleName(portletCss.porletHeader());
		headerContainer.add(headerWidget);
		
		this.add(headerContainer);
		
	}
		
	public void defineContentWidget(Widget contentWidget){
		this.contentWidget = contentWidget;
		this.add(contentWidget);
		
	}
	
	public void showHeader(){
		this.headerContainer.setVisible(true);

	}

	public void hideHeader(){
		this.headerContainer.setVisible(false);

	}
	
	public void setHeaderPixelSize(int width, int height){
		this.headerContainer.setPixelSize(width, height);	
	}
	public void setContentPixelSize(int width, int height){
		this.contentWidget.setPixelSize(width, height);	
	}
	public int getHeaderOffsetHeight(){
		return this.headerContainer.getOffsetHeight();
	}
	
	public int getHeaderOffsetWidth(){
		return this.headerContainer.getOffsetWidth();
	}
	
	public int getContentOffsetWidth(){
		return this.contentWidget.getOffsetWidth();
	}
	public int getContentOffsetHeight(){
		return this.contentWidget.getOffsetHeight();
	}
}


