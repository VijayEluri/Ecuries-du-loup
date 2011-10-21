package fr.ecuriesduloup.secretflag.client.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.ecuriesduloup.secretflag.client.CssResources;
import fr.ecuriesduloup.secretflag.client.form.data.Data;

public class FormPopup extends PopupPanel {

	private VerticalPanel verticalPanel;
	private Form form;
	private Collection<FormValidHandler> validHandlers;
	public FormPopup(Form form) {
		this.form = form;
		
		this.validHandlers = new ArrayList<FormValidHandler>();
		
		this.verticalPanel = new VerticalPanel();
		
		
		this.verticalPanel.add(this.form);
		
		this.addActionPanel();
		this.add(this.verticalPanel);
		this.setWidth("400px");
		this.addStyleName(CssResources.R.SecretFlag().field());
		
		this.centerPopup();
	}
	
	private void centerPopup(){
		
		int witdhDiff = 400/2;
		int left = Window.getClientWidth() /2 - witdhDiff;
		this.setPopupPosition(left, 50);
	}
	
	public void addActionPanel(){
		
		HorizontalPanel actionPanel = new HorizontalPanel();
		actionPanel.addStyleName("test");
		actionPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Button cancel = new Button("Anuler");
		cancel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide(true);
			}
		});
		actionPanel.add(cancel);
		
		Button valid = new Button("Valider");
		valid.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				List<Data> datas = form.getDatas();				
				fireValidHandler(datas);
				hide(true);
			}
		});
		actionPanel.add(valid);
		actionPanel.setWidth("100%");
		
		this.verticalPanel.add(actionPanel);
	}
	
	private void fireValidHandler(List<Data> datas){
		for(FormValidHandler formValidHandler : this.validHandlers){
			formValidHandler.valid(datas);
		}
	}
	
	public void addValidHandler(FormValidHandler formValidHandler){
		this.validHandlers.add(formValidHandler);
	}
}
