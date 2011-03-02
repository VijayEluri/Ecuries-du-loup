package fr.ecuriesduloup.edlwyswig.client.ui.board;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletController;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.TextPortlet;

public class Board extends Composite implements NativePreviewHandler{
	private AbsolutePanel panel;
	private AbsolutePanel boardPanel;
	private PortletController portletController ;
	private BoardTable boardTable;
	
	private List<Portlet> portlets;

	public Board() {
		this.portlets = new ArrayList<Portlet>();
		
		this.panel  = new AbsolutePanel();
		this.boardPanel = new AbsolutePanel();

		this.boardTable = new BoardTable(this);

		panel.add(this.boardTable);
		
		this.portletController = new PortletController(this.boardPanel);
		this.boardPanel.setPixelSize(1000, 1000);
		PickupDragController dragController = new PickupDragController(this.boardPanel, true);
		this.panel.add(this.boardPanel);
		initWidget(this.panel);
		

		

		Event.addNativePreviewHandler(this);
	}

	public Portlet addPortlet(int x, int y){
	
		Portlet windowPanel1 = new TextPortlet(this.portletController, this);
		this.boardPanel.add(windowPanel1, x, y);
		this.portlets.add(windowPanel1);
		return windowPanel1;
	}
	
	public Portlet addImagePortlet(int x, int y){
		
		ImagePortlet windowPanel1 = new ImagePortlet(this.portletController, this);
		this.boardPanel.add(windowPanel1, x, y);
		this.portlets.add(windowPanel1);
		return windowPanel1;
	}
	
	

	public AbsolutePanel getTotalPanelOfBoard(){
		return this.panel;
	}

	public AbsolutePanel getBoardPanel(){
		return this.boardPanel;
	}
	
	public void unSelectAllPortlets(){
		for(Portlet portlet : this.portlets){
			portlet.unSelect();
		}
	}

	public void removePortlet(Portlet portlet) {
		this.portlets.remove(portlet);
		this.boardPanel.remove(portlet);
		
	}
	
	@Override
	public void onPreviewNativeEvent(NativePreviewEvent event) {
		
		int type = event.getTypeInt();
		switch (type) {
			case Event.ONCLICK:	
				this.unSelectAllPortlets();
				break;
		}
		
	}
}
