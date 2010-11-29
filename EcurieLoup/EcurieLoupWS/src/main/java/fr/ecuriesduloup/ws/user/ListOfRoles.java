package fr.ecuriesduloup.ws.user;

import java.util.ArrayList;
import java.util.Collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("roles")
public class ListOfRoles {
	
	private Collection<String> roles;

	public ListOfRoles(){
		this.roles = new ArrayList<String>();		
	}
	
	public Collection<String> getRoles() {
		return roles;
	}
	
	public void add(String role) {
		this.roles.add(role);
		
	}
	
}
