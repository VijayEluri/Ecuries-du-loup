package fr.ecuriesduloup.secretflag.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuriesduloup.secretflag.client.form.Form;
import fr.ecuriesduloup.secretflag.client.form.FormPopup;
import fr.ecuriesduloup.secretflag.client.form.FormValidHandler;
import fr.ecuriesduloup.secretflag.client.form.data.Data;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SecretFlagEntryPoint implements EntryPoint {


	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private static final SecretFlagServiceAsync secretFlagService = GWT.create(SecretFlagService.class);
	private static final ImageResources imageResources = GWT.create(ImageResources.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ImageResource bretonFlag = SecretFlagEntryPoint.imageResources.bretonFlag();
		Image img = new Image();
		img.setUrl(bretonFlag.getURL());
		final AsyncCallback<List<Data>> callBack =  new AsyncCallback<List<Data>>() {
			
			@Override
			public void onSuccess(List<Data> datas) {

				if(!datas.isEmpty()){
					Form form = new Form();
					for(Data data : datas){
						form.add(data);
					}

					FormPopup popup = new FormPopup(form);
					popup.addValidHandler(new FormValidHandler() {
						
						@Override
						public void valid(List<Data> datas) {
							SecretFlagEntryPoint.secretFlagService.saveData(datas, new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Internal error : "+caught.getMessage());									
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
				Window.alert("Internal error : "+arg0.getMessage());
				
			}
		};

		PasswordSender passwordSender = new PasswordSender() {
			
			@Override
			public void send(String password) {
				secretFlagService.tryPassword(password, callBack);
			}
		}; 
		img.addClickHandler(new BretonImageClickHandler(img, passwordSender));
		
		img.setHeight("100%");
		img.setWidth("100%");
		RootPanel.get("secretFlag").add(img);
	}
}
