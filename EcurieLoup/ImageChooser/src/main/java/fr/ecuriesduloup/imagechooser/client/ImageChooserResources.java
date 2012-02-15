package fr.ecuriesduloup.imagechooser.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageChooserResources extends ClientBundle{
	public static final ImageChooserResources imageChooserResources = GWT.create(ImageChooserResources.class);

	
	@Source("emptyImage.jpg")
	public ImageResource emptyImage();

}
