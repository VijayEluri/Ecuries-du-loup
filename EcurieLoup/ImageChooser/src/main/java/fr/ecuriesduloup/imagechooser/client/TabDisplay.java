package fr.ecuriesduloup.imagechooser.client;

public class TabDisplay {

	private boolean url = false;
	private boolean album = false;
	private boolean allowEmptyImage = false;
	
	
	
	public TabDisplay(boolean url, boolean album, boolean allowEmptyImage) {
		this.url = url;
		this.album = album;
		this.allowEmptyImage = allowEmptyImage;
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
	public boolean isAllowEmptyImage() {
		return allowEmptyImage;
	}
	public void setAllowEmptyImage(boolean allowEmptyImage) {
		this.allowEmptyImage = allowEmptyImage;
	}
}
