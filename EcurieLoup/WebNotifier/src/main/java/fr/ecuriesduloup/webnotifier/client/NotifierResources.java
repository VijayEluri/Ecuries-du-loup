package fr.ecuriesduloup.webnotifier.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface NotifierResources extends ClientBundle {
	
	@Source("nonLu.png")
	@ImageOptions(height = 15, width = 15)
	public ImageResource notRead();

}
