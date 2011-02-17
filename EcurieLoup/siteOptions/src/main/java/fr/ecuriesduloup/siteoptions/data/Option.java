package fr.ecuriesduloup.siteoptions.data;

import donnees.User;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Option extends DataWtihLongIdAbstract<Option> implements DataWithLongId{

	private User user;
	private String name;
	private String value;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Option : "+this.id+" - for "+user.getLogin()+" : "+this.name+" => "+this.value+";";
	}
	
	
}
