package fr.ecuriesduloup.edlwyswig.client.ui.portletAdder;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;

public class ImagePortletAdder extends PortletAdder{

	@Override
	public Portlet createPorlet() {
		return new ImagePortlet();
	}
	
	@Override
	protected  Image getImage() {
		ImageResource img = portletResources.imagePortletAdder();
		return new Image(img);
	}

}
