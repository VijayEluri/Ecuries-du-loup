package fr.ecuriesduloup.imagechooser.client;

public class TabDisplay {

	private boolean url = false;
	private boolean album = false;
	
	
	
	public TabDisplay(boolean url, boolean album) {
		this.url = url;
		this.album = album;
	}
	public boolean isUrl() {
		return url;
	}
	public void setUrl(boolean url) {
		this.url = url;
	}
	public boolean isAlbum() {
		return album;
	}
	public void setAlbum(boolean album) {
		this.album = album;
	}
	
	
}
