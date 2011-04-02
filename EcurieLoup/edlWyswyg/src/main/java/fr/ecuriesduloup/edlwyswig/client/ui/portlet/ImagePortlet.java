package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;

import fr.ecuriesduloup.edlwyswig.client.ui.board.Board;

public class ImagePortlet extends Portlet {

	public ImagePortlet(PortletController windowController, Board board) {
		super(windowController, board);
		Image image = new Image("http://allen-sauer.com/com.allen_sauer.gwt.dnd.demo.DragDropDemo/images/99pumpkin2-65x58.jpg");
		image.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				select();
			}
		}
		);
		
		image.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Window.alert("choix");
				
			}
		});
		this.defineCenter(image);
		
		this.setContentSize(500, 250);
	}

}
