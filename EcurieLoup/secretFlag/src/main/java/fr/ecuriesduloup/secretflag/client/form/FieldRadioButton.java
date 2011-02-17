package fr.ecuriesduloup.secretflag.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.ecuriesduloup.secretflag.client.form.data.Choise;
import fr.ecuriesduloup.secretflag.client.form.data.MultipleData;

public class FieldRadioButton extends Field {

	private List<RadioButton> radioButtons;
	private Map<RadioButton, Choise> mappingRadioButtonChoise;
	
	public FieldRadioButton(MultipleData data) {
		super(data);
		this.radioButtons = new ArrayList<RadioButton>();
		this.mappingRadioButtonChoise = new HashMap<RadioButton, Choise>();
		String uniqueString = this.toString();
		VerticalPanel choisesPanel = new VerticalPanel();
		for(Choise choix : data.getChoise()){
			RadioButton radioButton = new RadioButton(uniqueString, choix.getLabel());
			this.radioButtons.add(radioButton);
			choisesPanel.add(radioButton);
			this.mappingRadioButtonChoise.put(radioButton, choix);
			
			if(choix.getValue().equals(data.getValue())){
				radioButton.setValue(true);				
			}
		}
		
		this.panel.add(choisesPanel);
		this.initWidget(this.panel);
	}
	@Override
	public void majData() {
		for(RadioButton radioButton: this.radioButtons){
			if(radioButton.getValue()){
				Choise selectedChoise = this.mappingRadioButtonChoise.get(radioButton);
				this.getData().setValue(selectedChoise.getValue());
			}
		}
		
	}


}
