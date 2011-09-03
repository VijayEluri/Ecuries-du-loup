package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

import fr.ecuriesduloup.edlwyswig.client.ui.board.BoardCss;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletCss;

public interface CssResources extends ClientBundle {
	public static final CssResources INSTANCE =GWT.create(CssResources.class);
	
	@Source("portlet.css")
	public PortletCss portletCss();
	@Source("board.css")
	public BoardCss boardCss();
}
