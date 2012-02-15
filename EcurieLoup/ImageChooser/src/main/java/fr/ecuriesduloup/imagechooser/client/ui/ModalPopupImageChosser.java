package fr.ecuriesduloup.imagechooser.client.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.Window;

import fr.ecuriesduloup.imagechooser.client.ImageChooserResources;
import fr.ecuriesduloup.imagechooser.client.ImageDefine;
import fr.ecuriesduloup.imagechooser.client.TabDisplay;
import fr.ecuriesduloup.imagechooser.shared.Img;

public class ModalPopupImageChosser extends Window implements ImageDefine{
	private static Map<ImageDefine, ModalPopupImageChosser> instance = new HashMap<ImageDefine, ModalPopupImageChosser>();

	public static ModalPopupImageChosser getInstance(ImageDefine imageDefine, TabDisplay tabDisplay) {

		if(!instance.containsKey(imageDefine)){
			ModalPopupImageChosser modalPopup = new ModalPopupImageChosser(imageDefine, tabDisplay);
			instance.put(imageDefine, modalPopup);
		}
		return instance.get(imageDefine);
	}
	
	protected static final ImageChooserResources portletResources = GWT.create(ImageChooserResources.class);


	private SelectImage preview;
	private ImageDefine imagePortlet;
	private ImageSelectorTab imageSelector;
	private Img selectedImage;

	public ModalPopupImageChosser(ImageDefine imageDefine, TabDisplay tabDisplay) {
		this.imagePortlet = imageDefine;
		
		this.defineWindowsOption();

		this.imageSelector =  this.createImageSelector(tabDisplay);
		Panel previewPanel = this.createPreviewPanel();

		
		HorizontalPanel  horizontalPanel = new HorizontalPanel();		
		horizontalPanel.add(this.imageSelector);
		horizontalPanel.add(previewPanel);
		this.addItem(horizontalPanel);
		
		this.centerInPage();  
	}
	
	private void defineWindowsOption(){
		this.setTitle("Choix d'image");  
		this.setShowMinimizeButton(false);  
		this.setShowCloseButton(false);
		// this.setIsModal(true);  
		this.setShowModalMask(true);  
}
	
	private ImageSelectorTab createImageSelector(TabDisplay tabDisplay){

		this.imageSelector= new ImageSelectorTab(this, tabDisplay);
		this.setAutoSize(true);
		this.setWidth("600px");
		this.imageSelector.setWidth("400px");
;
		this.imageSelector.setHeight("50%");
		
		return imageSelector;
	
	}

	private Panel createPreviewPanel(){
		VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setSize("220px", "300px");
		panel.getElement().getStyle().setMarginTop(25, Unit.PX);
		
		this.preview = new SelectImage(200, 200);

		
		panel.add(this.preview);

		HorizontalPanel buttonPanel = new HorizontalPanel();

		
		
		Button cancelButton = new Button("Annuler");
		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				cancel();  

			}
		});
		buttonPanel.add(cancelButton);
		
		Button validButton = new Button("Valider");
		validButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				valid();  

			}
		});
		buttonPanel.add(validButton);
		
		
		panel.add(buttonPanel);

		return panel;

	}
	
	

	public void showPopup() {
		this.show();  
	}


	private void valid(){
		imagePortlet.defineImage(this.selectedImage);
		this.hide();
	}
	
	private void cancel(){
		this.hide();
	}

	
	
	@Override
	public void defineImage(Img selectedImage){
		if(selectedImage.isDefine()){
			this.preview.setImg(selectedImage);
			this.selectedImage = selectedImage;
			this.imageSelector.define(selectedImage);
		}
	}
}
