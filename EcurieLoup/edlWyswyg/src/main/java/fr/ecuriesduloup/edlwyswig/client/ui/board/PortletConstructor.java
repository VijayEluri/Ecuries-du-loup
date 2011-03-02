package fr.ecuriesduloup.edlwyswig.client.ui.board;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;

public interface PortletConstructor {

	public Portlet createAndAddPortletOnBoard(int x, int y);
}
