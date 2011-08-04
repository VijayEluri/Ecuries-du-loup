package fr.ecuriesduloup.edlwyswig.client.ui.board;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.events.DropEvent;
import com.smartgwt.client.widgets.events.DropHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;

import fr.ecuriesduloup.edlwyswig.client.TestVisitor;
import fr.ecuriesduloup.edlwyswig.client.Visitor;
import fr.ecuriesduloup.edlwyswig.client.WysiwygService;
import fr.ecuriesduloup.edlwyswig.client.WysiwygServiceAsync;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portletAdder.PortletAdder;

public class Board extends VStack{
	private Canvas workspace;
	private HStack header;
	private final WysiwygServiceAsync wysiwygService = GWT.create(WysiwygService.class);
	public Board(){
		Button button = new Button("vue");
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				wysiwygService.generateHtml(getEdlCode(), new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						Window.alert(result);
						HTMLPanel panel = new HTMLPanel(result);
						final com.smartgwt.client.widgets.Window winModal = new com.smartgwt.client.widgets.Window();  
		                winModal.setWidth100();  
		                winModal.setHeight100();  
		                winModal.setTitle("Modal Window");  
		                winModal.setShowMinimizeButton(false);  
		                winModal.setIsModal(true);  
		                winModal.setShowModalMask(true);  
		                winModal.centerInPage();  
		                winModal.addCloseClickHandler(new CloseClickHandler() {  
		                    public void onCloseClick(CloseClientEvent event) {  
		                        winModal.destroy();  
		                    }  
		                });  
						 winModal.addItem(panel);  
			                winModal.show();  
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("error "+caught.getMessage());
						
					}
				});
			
				
			}
		});
		
		this.workspace = new Canvas();

        this.setEdgeSize(6);  
        this.workspace.setEdgeSize(6);  
		this.header= new HStack();
		this.header.setLayoutMargin(20);  
		this.header.setMembersMargin(40); 
		this.header.setLayoutAlign(Alignment.CENTER);  
//		WindowsPortlet window = new WindowsPortlet();  
        
		//this.workspace.addChild(window);
		this.addChild(button);
		this.addChild(this.header);
		this.addChild(this.workspace);
        this.workspace.setHeight("500px");
        this.workspace.setWidth("500px");
        
        this.workspace.setCanAcceptDrop(true);
        this.workspace.setDropTypes("P");
        this.header.getElement().getStyle().setBackgroundColor("red");
        this.workspace.getElement().getStyle().setBackgroundColor("yellow");
        
        this.workspace.addDropHandler(new DropHandler() {  
            public void onDrop(DropEvent event) {  
            	int x = workspace.getOffsetX() - 15 - workspace.getEdgeSize();
            	int y = workspace.getOffsetY() - 15 - workspace.getEdgeSize() ;
                          
            	Portlet portlet = ((PortletAdder) EventHandler.getDragTarget()).createPorlet();  
            	Board.this.addPortlet(portlet, x, y);
            }  
        }); 
	}
	
	public void addPortlet(Portlet portlet, int x, int y){
		this.workspace.addChild(portlet);
		portlet.setLeft(x);
		portlet.setTop(y);
	}
	
	public void addPortletAdder(PortletAdder portletAdder){
		this.header.addMember(portletAdder);
	}
	
	public String getEdlCode(){
		Visitor visitor = new TestVisitor();
		Canvas[] canevas = this.workspace.getChildren();	
		for(Canvas caneva : canevas ){
			if(caneva instanceof Portlet){
				Portlet portlet = (Portlet)caneva;
				portlet.accept(visitor);
			}
		}
		return visitor.getString();
	}
}
