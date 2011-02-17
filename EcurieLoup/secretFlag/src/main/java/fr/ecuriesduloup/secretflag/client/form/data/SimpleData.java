package fr.ecuriesduloup.secretflag.client.form.data;


public class SimpleData extends Data{

	private TypeSimpleData type;
	
	public TypeSimpleData getType() {
		return type;
	}
	public void setType(TypeSimpleData type) {
		this.type = type;
	}
	
	@Override
	public boolean isValid() {
		return this.getValue() != null && (!this.getValue().equals(""));
	}

}
