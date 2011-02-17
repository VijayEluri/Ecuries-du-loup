package fr.ecuriesduloup.ws.albumPhoto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import donnees.photo.Album;

@XStreamAlias("album")
public class AlbumWs {

	private long id;
	private String name;
	
	public AlbumWs(Album album){
		this.id = album.getId();
		this.name = album.getTitre();
	
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
	
	
}
