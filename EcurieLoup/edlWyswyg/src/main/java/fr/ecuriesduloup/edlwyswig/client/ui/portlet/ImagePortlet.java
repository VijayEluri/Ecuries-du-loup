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
	private boolean isDefineResize;

	public ImagePortlet() {
		super();
		this.imagePreview.setResource(portletResources.emptyImagePortletImage());
		this.addImageChooser();
		/*this.setShowCustomScrollbars(true);
		this.setScrollbarSize(0);*/
		this.addResizedHandler(new ResizedHandler() {
			
			@Override
			public void onResized(ResizedEvent event) {
				if(!isDefineResize){
					definePreviewImageSize();
				}
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
		this.imagePreview.setPixelSize(this.getWidth()-PORTLET_DIFF_WIDTH, this.getHeight()-PORTLET_DIFF_HEIGHT);
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
		if(this.image != null){
			if(this.image.isDefine()){
				if(this.image.isUrl()){
					this.imagePreview.setUrl(this.image.getUrl());
				}
			}
		}
		
		this.resizePortletAtImage();
	}

	private void resizePortletAtImage(){
		isDefineResize = true;
		if((this.imagePreview.getWidth() + PORTLET_DIFF_WIDTH) != this.getWidth()){
			this.imagePreview.setWidth((this.imagePreview.getWidth()-PORTLET_DIFF_WIDTH-1)+"px");
		}
		
		if((this.imagePreview.getHeight() + PORTLET_DIFF_HEIGHT) != this.getHeight()){
			this.imagePreview.setHeight((this.imagePreview.getHeight()-PORTLET_DIFF_HEIGHT-1)+"px");
		}
		this.redraw();
		this.setWidth(this.imagePreview.getWidth()+PORTLET_DIFF_WIDTH);
		this.setHeight(this.imagePreview.getHeight()+PORTLET_DIFF_HEIGHT);
		isDefineResize = false;
		
	}
	
	public Img getSelectedImage(){
		return this.image;	
	}

}
