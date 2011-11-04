package fr.ecuriesduloup.secretflag.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

import fr.ecuriesduloup.secretflag.client.form.Form;
import fr.ecuriesduloup.secretflag.client.form.FormPopup;
import fr.ecuriesduloup.secretflag.client.form.FormValidHandler;
import fr.ecuriesduloup.secretflag.client.form.data.Data;

public class SecretFlag extends Image{

	private static final SecretFlagServiceAsync secretFlagService = GWT.create(SecretFlagService.class);
	private static final ImageResources imageResources = GWT.create(ImageResources.class);
	
	public SecretFlag() {
		StyleInjector.inject(CssResources.R.SecretFlag().getText());
		CssResources.R.SecretFlag().ensureInjected();
		ImageResource bretonFlag = SecretFlag.imageResources.bretonFlag();		
		this.setUrl(bretonFlag.getURL());
		
		final AsyncCallback<List<Data>> callBack =  new AsyncCallback<List<Data>>() {
			
			@Override
			public void onSuccess(List<Data> datas) {

				if(!datas.isEmpty()){
					Form form = new Form();
					for(Data data : datas){
						form.add(data);
					}

					FormPopup popup = new FormPopup(form);
					popup.addStyleName(CssResources.R.SecretFlag().popupPanel());
					popup.addValidHandler(new FormValidHandler() {
						
						@Override
						public void valid(List<Data> datas) {
							SecretFlag.secretFlagService.saveData(datas, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									//Window.alert("Internal error : "+caught.getMessage());									
								}

								@Override
								public void onSuccess(Void result) {									
								}
							});
							
						}
					});
					popup.show();
				}
				
			}
			
			@Override
			public void onFailure(Throwable arg0) {
			//	Window.alert("Internal error : "+arg0.getMessage());
				
			}
		};

		PasswordSender passwordSender = new PasswordSender() {
			
			@Override
			public void send(String password) {
				secretFlagService.tryPassword(password, callBack);
			}
		}; 
		this.addClickHandler(new BretonImageClickHandler(this, passwordSender));
		
		//img.setHeight("100%");
		this.setWidth("100%");
	}
}
