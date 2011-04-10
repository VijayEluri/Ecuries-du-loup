package fr.ecuriesduloup.secretflag.client.form.data;

import java.io.Serializable;

public abstract class Data  implements Serializable{
	private String label;
	private String name;
	private String value;
	
	
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract boolean isValid();
	
}
