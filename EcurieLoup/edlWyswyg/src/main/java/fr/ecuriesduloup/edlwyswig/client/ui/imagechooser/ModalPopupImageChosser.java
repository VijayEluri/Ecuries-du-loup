package fr.ecuriesduloup.edlwyswig.client.ui.imagechooser;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LoadListener;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.Window;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portletAdder.PortletResources;
import fr.ecuriesduloup.edlwyswig.shared.Img;

public class ModalPopupImageChosser extends Window{
	private static Map<ImagePortlet, ModalPopupImageChosser> instance = new HashMap<ImagePortlet, ModalPopupImageChosser>();

	protected static final PortletResources portletResources = GWT.create(PortletResources.class);


	public static ModalPopupImageChosser getInstance(ImagePortlet imagePortlet) {
		if(!instance.containsKey(imagePortlet)){
			ModalPopupImageChosser modalPopup = new ModalPopupImageChosser(imagePortlet);
			instance.put(imagePortlet, modalPopup);
		}
		return instance.get(imagePortlet);
	}

	private Image preview;
	private ImagePortlet imagePortlet;
	private ImageSelector imageSelector;
	private Img selectedImage;

	public ModalPopupImageChosser(ImagePortlet imagePortlet) {

		this.imagePortlet = imagePortlet;
		this.imageSelector= new ImageSelector(this);
		this.setAutoSize(true);
		this.setWidth(ModalPopupSize.getGlobalSize());

		this.setTitle("Modal Window");  
		this.setShowMinimizeButton(false);  
		this.setShowCloseButton(false);
		// this.setIsModal(true);  
		this.setShowModalMask(true);  

		this.imageSelector.setWidth(ModalPopupSize.getTabPicturesSize());
		this.imageSelector.setHeight("50%");
		Panel previewPanel = this.createPreviewPanel();
		HorizontalPanel  horizontalPanel = new HorizontalPanel();		
		horizontalPanel.add(this.imageSelector);
		horizontalPanel.add(previewPanel);


		this.addItem(horizontalPanel);


		this.centerInPage();  

	}

	private Panel createPreviewPanel(){
		VerticalPanel panel = new VerticalPanel();
		panel.setWidth(ModalPopupSize.getPreviewPanelWidthSize());
		panel.setHeight(ModalPopupSize.getPreviewPanelHeightSize());
		
		this.preview = new Image(portletResources.emptyImagePortletImage());


		this.preview.addLoadListener(new LoadListener() {
			public void onError(Widget sender) {
				valideNotPossible();
			}

			public void onLoad(Widget sender) {
				defineSizeOfPreview();
			}
		});
		panel.add(this.preview);

		Button validButton = new Button("Valider");
		validButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				valid();  

			}
		});
		panel.add(validButton);

		return panel;

	}
	
	private void defineSizeOfPreview(){
		Size maxSize = new Size(ModalPopupSize.getPreviewImageMaxHeightSize(), ModalPopupSize.getPreviewImageMaxWidthSize());

		Size imageSize = new Size(preview.getHeight(), preview.getWidth());
		Size rezisedSize = imageSize.scaleWithMaxSize(maxSize);
		preview.setHeight(rezisedSize.getHeight()+"px");
		preview.setWidth(rezisedSize.getWidth()+"px");
	}

	public void showPopup() {
		this.show();  
	}


	private void valid(){
		imagePortlet.defineImage(this.selectedImage);
		this.hide();
	}

	private void valideNotPossible(){
		this.preview.setResource(portletResources.emptyImagePortletImage());
	}

	public void selectImage(Img selectedImage){
		valideNotPossible();
		this.selectedImage = selectedImage;
		if(this.selectedImage.isDefine()){
			if(this.selectedImage.isUrl()){

				this.preview.setUrl(selectedImage.getUrl());
			}else{
				this.valideNotPossible();
			}
		}else{

			this.valideNotPossible();
		}
	}
}
