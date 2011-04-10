package fr.ecuriesduloup.secretflag.client.form.data;

import java.io.Serializable;

public class Choise implements Serializable{
	private String label;
	private String value;
		
	public Choise(){
		this("", "");
	}
	public Choise(String value){
		this("", value);
	}
	public Choise(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
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



	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Choise)){
			return false;
		}
		Choise ChoiseEquals = (Choise)obj;
		return this.getValue().equals(ChoiseEquals.getValue());
	}
	
	@Override
	public int hashCode() {
		return this.getValue().hashCode();
	}
}
