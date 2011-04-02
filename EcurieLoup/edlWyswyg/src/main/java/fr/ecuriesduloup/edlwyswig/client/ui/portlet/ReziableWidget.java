package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuriesduloup.edlwyswig.client.CssResources;
import fr.ecuriesduloup.edlwyswig.client.DirectionConstant;
import fr.ecuriesduloup.edlwyswig.shared.exception.NoManageCaseException;

public class ReziableWidget extends Composite {

	private static final int BORDER_THICKNESS = 5;
	private Grid grid = new Grid(3, 3);
	

	private Widget northWidget;
	private Widget southWidget;
	private Widget westWidget;
	private Widget eastWidget;
	

	private int contentHeight;

	private int contentWidth;



	private boolean initialLoad = false;

	private PortletCss portletCss;
	private ContentPortletPanel content;
	private PortletController windowController;
	private SimplePanel panel;
	
	public ReziableWidget(ContentPortletPanel content, PortletController windowController) {
		this.content = content;
		this.windowController = windowController;
		this.panel = new SimplePanel();
		this.portletCss = CssResources.INSTANCE.portletCss();
		StyleInjector.inject(this.portletCss.getText());
		this.createResizeBorder();
		initWidget(panel);

	}
	
	private void createResizeBorder(){

		grid.setCellSpacing(0);
		grid.setCellPadding(0);
		panel.add(grid);

		setupCell(0, 0, DirectionConstant.NORTH_WEST);
		northWidget = setupCell(0, 1, DirectionConstant.NORTH);
		setupCell(0, 2, DirectionConstant.NORTH_EAST);
		
		westWidget = setupCell(1, 0, DirectionConstant.WEST);
		grid.setWidget(1, 1, this.content);
		eastWidget = setupCell(1, 2, DirectionConstant.EAST);

		setupCell(2, 0, DirectionConstant.SOUTH_WEST);
		southWidget = setupCell(2, 1, DirectionConstant.SOUTH);
		setupCell(2, 2, DirectionConstant.SOUTH_EAST);
	}
	
	
	
	private Widget setupCell(int row, int col, DirectionConstant direction) {
		FocusPanel widget = new FocusPanel();
		widget.setPixelSize(BORDER_THICKNESS, BORDER_THICKNESS);
		grid.setWidget(row, col, widget);
		windowController.getResizeDragController().makeDraggable(widget, direction);

		this.defineCss(row, col, direction, widget);

		return widget;
	}
	
	private void defineCss(int row, int col, DirectionConstant direction, Widget widget){

		this.defineCss(row, col, widget, this.portletCss.porletResizeBorder());

		if(direction.equals(DirectionConstant.NORTH)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderNorth());			
		}else if(direction.equals(DirectionConstant.NORTH_EAST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderNorthEast());
		}else if(direction.equals(DirectionConstant.EAST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderEast());
		}else if(direction.equals(DirectionConstant.SOUTH_EAST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderSouthEast());
		}else if(direction.equals(DirectionConstant.SOUTH)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderSouth());
		}else if(direction.equals(DirectionConstant.SOUTH_WEST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderSouthWest());
		}else if(direction.equals(DirectionConstant.WEST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderWest());
		}else if(direction.equals(DirectionConstant.NORTH_WEST)){
			this.defineCss(row, col, widget, this.portletCss.porletResizeBorderNorthWest());
		}else{
			throw new NoManageCaseException();
		}

	}

	private void defineCss(int row, int col, Widget widget, String style){
		widget.addStyleName( style);
		grid.getCellFormatter().addStyleName(row, col, style);
	}
	
	public void setContentSize(int width, int height) {
		System.out.println("ReziableWidget.setContentSize ("+width+", "+height+")");
		if (width != contentWidth) {
			contentWidth = width;
			northWidget.setPixelSize(contentWidth, BORDER_THICKNESS);
			southWidget.setPixelSize(contentWidth, BORDER_THICKNESS);
		}
		if (height != contentHeight) {
			contentHeight = height;
			int headerHeight = this.content.getHeaderOffsetHeight();
			westWidget.setPixelSize(BORDER_THICKNESS, contentHeight + headerHeight);
			eastWidget.setPixelSize(BORDER_THICKNESS, contentHeight + headerHeight);
		}
	}	
}
