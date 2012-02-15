package fr.ecuriesduloup.imagechooser.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable{
	private long id;
	private String name;
	private List<Photo> photos;
	
	public Album() {
		this.photos = new ArrayList<Photo>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPhoto(Photo photo) {
		this.photos.add(photo);
	}
	public Photo getPhoto(int i){
		return this.photos.get(i);
	}
	public int getSizePhotos(){
		return this.photos.size();	
	}
}
