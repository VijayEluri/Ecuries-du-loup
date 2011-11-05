package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;


public class Diaporama extends Composite {
	
	public Diaporama() {
		DiaporamaResources.INSTANCE.DiaporamaCss().ensureInjected();
		ImageResource imageResource = DiaporamaResources.INSTANCE.diaporamaIcon(); 
		Image img = new Image(imageResource);
		
		
		img.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DiaporamaPopup diapoPopup = new DiaporamaPopup();
				diapoPopup.show();
				
			}
		});
		
		this.initWidget(img);
	}
}
