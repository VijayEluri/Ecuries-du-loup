package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class PortletHeader extends FocusPanel{

	public PortletHeader(final Portlet portlet) {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		Label labelEspace = new Label("----------------");
		horizontalPanel.add(labelEspace);
		Label label = new Label("<-->");
		horizontalPanel.add(label);
		portlet.makeDraggableBy(label);
		Label close = new Label("x");
		
		close.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				portlet.remove();
				
			}
		});
		horizontalPanel.add(close);
		this.add(horizontalPanel);
	}
}
