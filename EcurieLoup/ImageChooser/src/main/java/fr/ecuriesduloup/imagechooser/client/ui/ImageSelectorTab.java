package fr.ecuriesduloup.imagechooser.client.ui;


import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import fr.ecuriesduloup.imagechooser.client.ImageDefine;
import fr.ecuriesduloup.imagechooser.client.TabDisplay;
import fr.ecuriesduloup.imagechooser.client.ui.siteimage.SiteImageTab;
import fr.ecuriesduloup.imagechooser.shared.Img;

public class ImageSelectorTab extends Canvas {
	private ImageDefine imageDefine;
	private TextItem textItem;
	private SiteImageTab siteImageTab;

	public ImageSelectorTab(ImageDefine imageDefine, TabDisplay tabDisplay) {
		this.imageDefine =imageDefine;

		TabSet pictureTabSet = new TabSet(); 
		pictureTabSet.setTabBarPosition(Side.TOP); 
		pictureTabSet.setWidth("100%");
		pictureTabSet.setHeight("100%"); 

		if(tabDisplay.isUrl()){
			pictureTabSet.addTab(createUrlTab());
		}
		if(tabDisplay.isAlbum()){
			this.siteImageTab = new SiteImageTab(imageDefine);
			pictureTabSet.addTab(siteImageTab);
		}

		this.addChild(pictureTabSet);

		if(siteImageTab != null){
			siteImageTab.load();
		}
	}

	private Tab createUrlTab(){
		DynamicForm form = new DynamicForm();  
		form.setHeight100();  
		form.setWidth100();  
		form.setPadding(5);  
		form.setLayoutAlign(VerticalAlignment.BOTTOM);  
		this.textItem = new TextItem();  
		this.textItem.setTitle("Url"); 
		this.textItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				Img image = new Img();
				image.define(textItem.getValueAsString());
				imageDefine.defineImage(image);

			}
		});

		form.setFields(textItem);  
		Tab tTab1 = new Tab("Url");  
		tTab1.setPane(form);

		return tTab1;

	}

	public void define(Img img){
		if(img.isDefine()){
			if(img.isUrl()){
				this.textItem.setValue(img.getUrl());
			}else{
				this.textItem.setValue("");
			}
		}else{
			this.textItem.setValue("");
		}
		if(siteImageTab != null){
			this.siteImageTab.define(img);
		}
	}


}
