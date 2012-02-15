package fr.ecuriesduloup.imagechooser.shared;

public class Img {
	private boolean define;
	private String url;
	private long photoOfAlbum = 0;

	public boolean isDefine() {
		return define;
	}

	public boolean isUrl() {
		return url != null;
	}

	public String getUrl() {
		return this.url;
	}
	
	public boolean isPhotoAlbum() {
		return photoOfAlbum != 0;
	}

	public long getPhotoAlbum() {
		return this.photoOfAlbum;
	}
	
	public void define(String url){
		this.clean();
		this.define = true;
		this.url = url;
	}
	
	public void define(long idPhotoOfAlbum){
		this.clean();
		this.define = true;
		this.photoOfAlbum = idPhotoOfAlbum;
	}

	private void clean(){
		this.define = false;
		this.url = null;
	}
}
