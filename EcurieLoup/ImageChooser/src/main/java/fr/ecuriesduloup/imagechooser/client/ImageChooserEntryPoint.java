package fr.ecuriesduloup.imagechooser.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.imagechooser.shared.Img;

public class ImageChooserEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Img selectedImage = new Img();
		selectedImage.define("https://fbcdn-sphotos-a.akamaihd.net/hphotos-ak-ash4/397765_2991682119625_1489307025_33097171_1586448697_n.jpg");
		
		TabDisplay tabDisplay = new TabDisplay(true, true);
		
		ImageChooser imageChooser = new ImageChooser(selectedImage, tabDisplay, new ImageDefine() {
			
			@Override
			public void defineImage(Img chooseImage) {
			//	Window.alert(chooseImage.getUrl());
				
			}
		});
		
		RootPanel.get().add(imageChooser);

	}

}
