package fr.ecuries_du_loup.diaporama.shared.data;

import java.io.Serializable;

public class Picture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5127149919192298254L;
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
