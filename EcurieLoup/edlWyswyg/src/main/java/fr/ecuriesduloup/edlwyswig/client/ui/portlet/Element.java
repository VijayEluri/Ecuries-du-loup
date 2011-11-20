package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import fr.ecuriesduloup.edlwyswig.client.visitor.Visitor;

public interface Element {
	
	public void accept(Visitor visitor);
	
	public int getBlockWidth();
	public int getBlockHeight();
	
	public int getBlockTop();	
	public int getBlockLeft();
}
