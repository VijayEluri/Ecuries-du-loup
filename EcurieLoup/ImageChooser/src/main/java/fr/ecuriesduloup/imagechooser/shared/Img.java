package fr.ecuriesduloup.imagechooser.shared;

public class Img {
	private boolean define;
	private String url;

	public boolean isDefine() {
		return define;
	}

	public boolean isUrl() {
		return url != null;
	}

	public String getUrl() {
		return this.url;
	}
	
	public void define(String url){
		this.clean();
		this.define = true;
		this.url = url;
	}

	private void clean(){
		this.define = false;
		this.url = null;
	}
}
