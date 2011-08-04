package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuriesduloup.edlwyswig.client.Visitor;


public class TextPortlet extends Portlet {
	private TextArea textArea;
	
	public TextPortlet() {
		super();
	}
	
	@Override
	protected Widget getContentWidget() {
		this.textArea =new TextArea();
		textArea.setHeight("97%");
		textArea.setWidth("97%");
		textArea.setFocus(true);
		return textArea;
	}
	
	@Override
	protected String getPortletTitle(){
		return "Texte";
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
	public String getContent(){
		return this.textArea.getValue();
	
	}
}
