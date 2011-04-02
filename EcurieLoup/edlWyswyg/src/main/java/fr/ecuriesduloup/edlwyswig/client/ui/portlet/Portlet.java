package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.allen_sauer.gwt.dnd.client.util.Location;
import com.allen_sauer.gwt.dnd.client.util.WidgetLocation;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuriesduloup.edlwyswig.client.CssResources;
import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;

public abstract class Portlet extends FocusPanel  {


	private int contentHeight;

	private int contentWidth;



	private final PortletController windowController;

	

	private PortletCss portletCss;
	private Board board;
	private ContentPortletPanel contentPortlet;
	private 	ReziableWidget reziableWidget;

	public Portlet(PortletController windowController, Board board) {
		super();
		this.windowController = windowController;
		this.board = board;

		this.portletCss = CssResources.INSTANCE.portletCss();

		StyleInjector.inject(this.portletCss.getText());

		this.addStyleName(this.portletCss.portlet());

		
		this.contentPortlet = new ContentPortletPanel(this);
		
		reziableWidget = new ReziableWidget(this.contentPortlet, windowController);

		this.add(reziableWidget);
		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				select();
			}
		});

	}
	
	protected void select() {
		setAtTheFistPlan();
		this.contentPortlet.showHeader();
	}
	
	private void setAtTheFistPlan(){
		AbsolutePanel boundaryPanel = windowController.getBoundaryPanel();
		if (boundaryPanel.getWidgetIndex(Portlet.this) < boundaryPanel.getWidgetCount() - 1) {
			// force our panel to the top of our z-index context
			WidgetLocation location = new WidgetLocation(Portlet.this, boundaryPanel);
			boundaryPanel.add(Portlet.this, location.getLeft(), location.getTop());
		}
	}
	
	protected void defineCenter(Widget widget) {
		this.contentPortlet.defineContentWidget(widget);
	}


	public void unSelect(){
		System.out.println("unSelect");
		this.contentPortlet.hideHeader();
	}

	public int getContentHeight() {
		return contentHeight;
	}

	public int getContentWidth() {
		return contentWidth;
	}

	public void moveBy(int right, int down) {
		AbsolutePanel parent = (AbsolutePanel) getParent();
		Location location = new WidgetLocation(this, parent);
		int left = location.getLeft() + right;
		int top = location.getTop() + down;
		parent.setWidgetPosition(this, left, top);
	}

	public void setContentSize(int width, int height) {
		System.out.println("Portlet.setContentSize("+width+", "+height+")");
		if (width != contentWidth) {
			contentWidth = width;
			this.contentPortlet.setHeaderPixelSize(contentWidth, this.contentPortlet.getHeaderOffsetHeight());
		//	northWidget.setPixelSize(contentWidth, BORDER_THICKNESS);
		//	southWidget.setPixelSize(contentWidth, BORDER_THICKNESS);
		}
		if (height != contentHeight) {
			contentHeight = height;
		//	int headerHeight = this.contentPortlet.getHeaderOffsetHeight();
		//	westWidget.setPixelSize(BORDER_THICKNESS, contentHeight + headerHeight);
		//	eastWidget.setPixelSize(BORDER_THICKNESS, contentHeight + headerHeight);
		}
		this.contentPortlet.setContentPixelSize(contentWidth, contentHeight);
		this.reziableWidget.setContentSize(width, contentHeight);
	}

	void makeDraggableBy(Widget dragHandle){
		this.windowController.getPickupDragController().makeDraggable(this, dragHandle);
	}

	public void remove(){
		this.board.removePortlet(this);
	}
	
	protected ContentPortletPanel getContentPortlet(){
		return this.contentPortlet;
	}
	
	
	public void onPreviewDragStart(){
	}
	
	public void onPreviewDragEnd(){
	}
	
	public void onDragStart(){
	}
	
	public void onDragEnd(){
	}
	
	public boolean isInPortlet(int x, int y){
		if((this.getAbsoluteLeft() <= x) && ((this.getAbsoluteLeft()+ this.contentWidth)>= x)){
			if((this.getAbsoluteTop() <= y) && ((this.getAbsoluteTop()+ this.contentHeight)>= y)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}		
	}
	
}
