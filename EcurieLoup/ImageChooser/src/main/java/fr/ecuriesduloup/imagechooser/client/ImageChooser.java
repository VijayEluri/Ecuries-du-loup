package fr.ecuriesduloup.imagechooser.client;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

import fr.ecuriesduloup.imagechooser.client.ui.ModalPopupImageChosser;
import fr.ecuriesduloup.imagechooser.client.ui.SelectImage;
import fr.ecuriesduloup.imagechooser.shared.Img;

public class ImageChooser extends FlowPanel implements ImageDefine {
	private ImageDefine imageDefine;
	private TabDisplay tabDisplay;
	private SelectImage image;
	private Img img;

	public ImageChooser(ImageDefine imageDefine, TabDisplay tabDisplay) {
		this.imageDefine = imageDefine;
		this.tabDisplay = tabDisplay;
		this.addEmptyImage();		
	}
	public ImageChooser(Img selectImage, TabDisplay tabDisplay,  ImageDefine imageDefine) {
		this(imageDefine, tabDisplay);

		this.defineImage(selectImage);		
	}

	private void addEmptyImage(){
		this.image = new SelectImage(400, 300);
		this.add(image);
		this.image.addDoubleClickHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent arg0) {
				ModalPopupImageChosser popin = ModalPopupImageChosser.getInstance(ImageChooser.this, tabDisplay);

				popin.showPopup();	

				if(image !=null){
					popin.defineImage(img);
				}
			}
		});
	}

	@Override
	public void defineImage(Img chooseImage) {
		if(chooseImage.isDefine()){
			this.img = chooseImage;
			this.image.setImg(chooseImage);
			this.imageDefine.defineImage(chooseImage);
		}
	}




}
