package fr.ecuriesduloup.ws.albumPhoto.tag;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import donnees.photo.Tag;

@XStreamAlias("tag")
public class TagDto {
	private long id;
	private double x;
	private double y;
	private String name;
	private long mediaId;
	
	private String path;
	private String display;
	
	public TagDto(Tag tag) {
		this.id = tag.getId();
		this.x = tag.getX();
		this.y = tag.getY();
		this.name = tag.getNom();
		this.mediaId = tag.getPhoto().getId();
		this.path = tag.getPath();
		this.display = tag.getDisplay();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMedia() {
		return mediaId;
	}

	public void setMedia(long media) {
		this.mediaId = media;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
	
}
