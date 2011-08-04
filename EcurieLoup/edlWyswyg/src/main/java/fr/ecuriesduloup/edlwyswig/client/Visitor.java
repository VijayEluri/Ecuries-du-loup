package fr.ecuriesduloup.edlwyswig.client;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.TextPortlet;

public interface Visitor {

	public void visit(TextPortlet textPortlet);
	public void visit(ImagePortlet imagePortlet);

	public String getString();

}
