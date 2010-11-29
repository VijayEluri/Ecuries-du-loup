package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

public class ImagePanel extends SimplePanel {
	private Image image;
	
	public ImagePanel() {
		this.image = new Image();
		this.setStyleName("image");
		this.add(image);
	}
	
	public void setUrl(String urlImage){
		this.image.setUrl(urlImage);
	}
}
