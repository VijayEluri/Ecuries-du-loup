package fr.ecuriesduloup.edlwyswig.client.ui.portlet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;

import fr.ecuriesduloup.edlwyswig.client.Visitor;
import fr.ecuriesduloup.edlwyswig.client.ui.imagechooser.ImageChooserConteneur;
import fr.ecuriesduloup.edlwyswig.client.ui.imagechooser.ModalPopupImageChosser;
import fr.ecuriesduloup.edlwyswig.shared.Img;


public class ImagePortlet extends Portlet  implements ImageChooserConteneur{
	private Img image;
	private Image imagePreview;

	public ImagePortlet() {
		super();
		

		

		
		this.imagePreview.setUrl("http://www.smartclient.com/smartgwt/showcase/images/animals/Zebra.jpg");
		this.addImageChooser();
		/*this.setShowCustomScrollbars(true);
		this.setScrollbarSize(0);*/
		this.addResizedHandler(new ResizedHandler() {
			
			@Override
			public void onResized(ResizedEvent event) {
				definePreviewImageSize();
			}
		});
	}

	@Override
	protected Widget getContentWidget() {
		this.imagePreview =new Image();
		//this.definePreviewImageSize();
		return this.imagePreview;
	}

	private void addImageChooser(){
		this.imagePreview.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ModalPopupImageChosser chooser = ModalPopupImageChosser.getInstance(ImagePortlet.this);
				chooser.showPopup();
			}
		});

	}
	
	private void definePreviewImageSize(){
		//this.imagePreview.setWidth((this.getWidth()-this.diffWidth)+"px");
		//this.imagePreview.setHeight((this.getHeight()-this.diffHeight)+"px");
		//this.setPixelSize(this.getWidth(), this.getHeight());
		this.imagePreview.setPixelSize(this.getWidth(), this.getHeight());
		System.out.println(this.getWidth()+"-"+this.getHeight());
	}

	@Override
	protected String getPortletTitle(){
		return "Image";
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}

	@Override
	public void defineImage(Img chooseImage) {
		this.image = chooseImage;	
		if(chooseImage.isDefine()){
			if(chooseImage.isUrl()){
				this.imagePreview.setUrl(chooseImage.getUrl());
			}
		}
	}

	public Img getSelectedImage(){
		return this.image;	
	}

}
