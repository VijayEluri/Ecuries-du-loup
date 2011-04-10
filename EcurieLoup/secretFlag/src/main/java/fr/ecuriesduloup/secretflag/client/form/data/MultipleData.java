package fr.ecuriesduloup.secretflag.client.form.data;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MultipleData extends Data implements IsSerializable{

	private List<Choise> choises;
	private TypeMultipleData type;
	public MultipleData() {
		this.choises = new ArrayList<Choise>();
	}
	
	public List<Choise> getChoise() {
		return choises;
	}

	public void addChoise(Choise choise) {
		this.choises.add(choise);
	}

	
	public TypeMultipleData getType() {
		return type;
	}
	public void setType(TypeMultipleData type) {
		this.type = type;
	}

	@Override
	public boolean isValid() {
		return this.getValue() != null && this.choises.contains(new Choise(this.getValue()));
	}

}
