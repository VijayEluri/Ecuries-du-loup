package fr.ecuriesduloup.edlwyswig.client.visitor;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.imageportlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.textportlet.TextPortlet;

public interface Visitor {

	public void visit(TextPortlet textPortlet);
	public void visit(ImagePortlet imagePortlet);

	public String getString();

}
