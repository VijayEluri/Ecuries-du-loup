package fr.ecuriesduloup.secretflag.client.form;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import fr.ecuriesduloup.secretflag.client.form.data.Data;

public abstract class Field extends Composite{

	private Data data;
	protected HorizontalPanel panel;
	public Field(Data data){
		this.data = data;
		this.panel = new HorizontalPanel();

		this.panel.addStyleName("field");
		Label label = new Label(this.data.getLabel());
		panel.add(label);
		
	}
	
	
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}


	public abstract void majData();
}
