package fr.ecuriesduloup.imagechooser.client;


import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import fr.ecuriesduloup.imagechooser.shared.Img;

public class ImageSelector extends Canvas {
	private ModalPopupImageChosser chosser;
	public ImageSelector(ModalPopupImageChosser chosser) {
		this.chosser =chosser;
		TabSet pictureTabSet = new TabSet(); 
		pictureTabSet.setTabBarPosition(Side.TOP);  

		Tab tTab1 = new Tab("Url");  
		tTab1.setPane(this.createUrlPanel());
		pictureTabSet.addTab(tTab1);
		
		pictureTabSet.setWidth("100%");
		pictureTabSet.setHeight("100%");

		this.addChild(pictureTabSet);
	}

	private Canvas createUrlPanel(){
		DynamicForm form = new DynamicForm();  
		form.setHeight100();  
		form.setWidth100();  
		form.setPadding(5);  
		form.setLayoutAlign(VerticalAlignment.BOTTOM);  
		final TextItem textItem = new TextItem();  
		textItem.setTitle("Url"); 
		textItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				Img image = new Img();
				image.define(textItem.getValueAsString());
				chosser.selectImage(image);
				
			}
		});
		form.setFields(textItem);  
		return form;

	}
}
