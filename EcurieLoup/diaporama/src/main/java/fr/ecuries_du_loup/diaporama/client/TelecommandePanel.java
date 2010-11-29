package fr.ecuries_du_loup.diaporama.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControl;

public class TelecommandePanel extends VerticalPanel {
	private DiaporamaControl diaporamaControl;
	private Button previousButton;
	private Button nextButton;
	
	private HorizontalPanel navigationPanel;
	private VerticalPanel optionPanel;
	
	private VerticalPanel readMode;
	
	public TelecommandePanel(DiaporamaControl diaporamaControl) {
		this.diaporamaControl = diaporamaControl;
		this.setStyleName("telecommande");
		
		this.navigationPanel = new HorizontalPanel();
		this.add(this.navigationPanel);		
		this.createPreviousButton();
		this.createNextButton();
		
		this.createReadModePanel();
		
		this.optionPanel = new VerticalPanel();
		this.add(this.optionPanel);
		this.createloopStartButton();
		this.createTimer();
	}
	


	private void createPreviousButton(){
		this.previousButton = new Button("<");
		this.navigationPanel.add(previousButton);
		previousButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				TelecommandePanel.this.diaporamaControl.previous();
			}
		});
		
	}
	private void createNextButton(){
		this.nextButton = new Button(">");
		this.navigationPanel.add(nextButton);
		nextButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				TelecommandePanel.this.diaporamaControl.next();
			}
		});
		
	}
	
	private void createReadModePanel(){
		this.readMode = new VerticalPanel();
		this.add(this.readMode);
		
		Label title = new Label("Défilement");
		this.readMode.add(title);
		RadioButton rbSequential = new RadioButton("readMode", "Séquentiel");
		this.readMode.add(rbSequential);
	    RadioButton rbRandom = new RadioButton("readMode", "Aléatoire");
	    this.readMode.add(rbRandom);
	    rbSequential.setValue(true);

	    
	    rbSequential.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				TelecommandePanel.this.diaporamaControl.sequentialReading();
				
			}
		});
	    rbRandom.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				TelecommandePanel.this.diaporamaControl.randomReading();
				
			}
		});
	    
		
	}
	
	private void createloopStartButton(){
		CheckBox loopStartCb = new CheckBox("en boucle");
		this.optionPanel.add(loopStartCb);
		loopStartCb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if(event.getValue()){
					
					TelecommandePanel.this.diaporamaControl.loopStart();
				}else{
					TelecommandePanel.this.diaporamaControl.loopStop();
				}
			}
		});
		
	}
	
	private void createTimer() {
		CheckBox loopStartCb = new CheckBox("défilement automatique");
		this.optionPanel.add(loopStartCb);
		loopStartCb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if(event.getValue()){
					
					TelecommandePanel.this.diaporamaControl.startTimer();
				}else{
					TelecommandePanel.this.diaporamaControl.stopTimer();
				}
			}
		});
		
	}
	public void enableNext(){
		this.nextButton.setEnabled(true);
	}
	public void disableNext(){
		this.nextButton.setEnabled(false);
	}
	
	public void enablePrevious(){
		this.previousButton.setEnabled(true);
		
	}
	public void disablePrevious(){
		this.previousButton.setEnabled(false);
		
	}
	
	
}
