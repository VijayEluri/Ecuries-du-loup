package fr.ecuriesduloup.secretflag.server;

import java.util.ArrayList;
import java.util.List;


import fr.ecuriesduloup.secretflag.client.SecretFlagService;
import fr.ecuriesduloup.secretflag.client.form.data.Choise;
import fr.ecuriesduloup.secretflag.client.form.data.Data;
import fr.ecuriesduloup.secretflag.client.form.data.MultipleData;
import fr.ecuriesduloup.secretflag.client.form.data.TypeMultipleData;
import fr.ecuriesduloup.siteoptions.data.Option;
import fr.ecuriesduloup.siteoptions.service.OptionsService;

public class SecretFlagServiceImpl implements SecretFlagService {

	private OptionsService optionsService;

	private final static String NAME_BIGADIN_OPTION = "bigadin";

	public void setOptionsService(OptionsService optionsService) {
		this.optionsService = optionsService;
	}

	public List<Data> tryPassword(String password)  {
		try{
		List<Data> datas = new ArrayList<Data>();


		if(password.endsWith("85b")){
			Option option = this.optionsService.get(NAME_BIGADIN_OPTION);

			MultipleData data = new MultipleData();
			data.setLabel("Remplacement des équidés par Bigadin : ");
			data.setName(NAME_BIGADIN_OPTION);
			if(option == null){
				data.setValue("0");
			}else{
				data.setValue(option.getValue());
			}
			data.setType(TypeMultipleData.Radio);
			data.addChoise(new Choise("Activé", "1"));
			data.addChoise(new Choise("Désactivé", "0"));
			datas.add(data);	
		}
		return datas;	
		}catch (Exception e) {
			e.printStackTrace();
		return null;	
		}
	}

	@Override
	public void saveData(List<Data> datas) {
		try{
		for(Data data : datas){
			this.optionsService.save(data.getName(), data.getValue());
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
