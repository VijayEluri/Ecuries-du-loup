package fr.ecuriesduloup.imagechooser.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LoadListener;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuriesduloup.imagechooser.client.ImageChooserResources;
import fr.ecuriesduloup.imagechooser.shared.Img;

public class SelectImage extends Image {

	protected static final ImageChooserResources resources = GWT.create(ImageChooserResources.class);

	private Size maxSize;
	
	public SelectImage(int maxHeight, int maxWidth) {
		super(resources.emptyImage());
		this.maxSize = new Size(maxHeight, maxWidth);
		this.defineSizeOfPreview();
		this.addLoadListener(new LoadListener() {
			public void onError(Widget sender) {
				valideNotPossible();
			}

			public void onLoad(Widget sender) {
				defineSizeOfPreview();
			}
		});
	}
	private void valideNotPossible(){
		this.setResource(resources.emptyImage());
	}
	
	private void defineSizeOfPreview(){

		Size imageSize = new Size(this.getHeight(), this.getWidth());
		Size rezisedSize = imageSize.scaleWithMaxSize(this.maxSize);
		this.setHeight(rezisedSize.getHeight()+"px");
		this.setWidth(rezisedSize.getWidth()+"px");
	}
	
	
	public void setImg(Img image) {
		this.valideNotPossible();
		if(image.isDefine()){
			if(image.isUrl()){
				super.setUrl(image.getUrl());
			}else if(image.isPhotoAlbum()){
				super.setUrl(getUrlPhoto(image.getPhotoAlbum()));
			}
		}
	}
	
	private String getUrlPhoto(long photoId){
		String[] urls = GWT.getHostPageBaseURL().split("/");
		return urls[0]+"//"+urls[2]+"/"+urls[3]+"/images/albumPhoto/view/"+photoId;
	}
	
}
