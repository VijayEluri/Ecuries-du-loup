package fr.ecuriesduloup.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.ecuries_du_loup.diaporama.client.Diaporama;
import fr.ecuriesduloup.imagechooser.client.ImageChooser;
import fr.ecuriesduloup.imagechooser.client.ImageDefine;
import fr.ecuriesduloup.imagechooser.client.TabDisplay;
import fr.ecuriesduloup.imagechooser.shared.Img;
import fr.ecuriesduloup.secretflag.client.SecretFlag;
import fr.ecuriesduloup.webnotifier.client.ui.news.Notifier;

public class Gwt implements EntryPoint{

	@Override
	public void onModuleLoad() {


		//media notifier
		this.addElement("mediaNotifier", new Test() {
			private Notifier notifier;
			@Override
			public Widget getWidget() {
				notifier =  Notifier.createMediaNotifier();
				return notifier;
			}

			@Override
			public void run() {
				notifier.run();

			}
		});


		//forum notifier
		this.addElement("forumNotifier", new Test() {
			private Notifier notifier;
			@Override
			public Widget getWidget() {
				notifier =  Notifier.createForumNotifier();
				return notifier;
			}

			@Override
			public void run() {
				notifier.run();

			}
		});

		this.addElement("secretFlag", new Test() {
			@Override
			public Widget getWidget() {
				return  new SecretFlag();
			}

			@Override
			public void run() {				
			}
		});

		this.addElement("nameFieldContainer", new Test() {
			@Override
			public Widget getWidget() {
				return new Diaporama();
			}

			@Override
			public void run() {				
			}
		});


		
		addImageSelector("imageHeadHorse", "fieldHeadPicture");
		
		addImageSelector("imageBodyHorse", "fieldBodyPicture");
	}
	
	private void addImageSelector(String idDivToAdd, final String idFieldToFill){
		this.addElement(idDivToAdd, new Test() {

			@Override
			public Widget getWidget() {
				
				TabDisplay tabDisplay = new TabDisplay(false, true, true);
				
				InputElement element =InputElement.as(DOM.getElementById(idFieldToFill));

				Img img = new Img();
				img.define(Long.parseLong(element.getValue()));
				ImageChooser imageChooser = new ImageChooser(img,tabDisplay, new ImageDefine() {

					@Override
					public void defineImage(Img chooseImage) {
						if(chooseImage.isDefine()){
							InputElement element =InputElement.as(DOM.getElementById(idFieldToFill));
							if(chooseImage.isPhotoAlbum()){
								element.setValue(chooseImage.getPhotoAlbum()+"");
							}else if(chooseImage.isEmptyImage()){
								element.setValue("0");
							}
						}

					}
				});
				return imageChooser;
			}

			@Override
			public void run() {				
			}
		});
		
	}

	private void addElement(String id, Test element){
		if(RootPanel.get(id)!= null){
			RootPanel.get(id).add(element.getWidget());
			element.run();
		}
	}

	private interface Test{
		public Widget getWidget();
		public void run();
	}
}
