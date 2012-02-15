package fr.ecuriesduloup.imagechooser.shared;

import java.io.Serializable;

public class Photo implements Serializable{
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
