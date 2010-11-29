package fr.ecuries_du_loup.diaporama.client.engine.navigator;

import java.util.HashMap;
import java.util.Map;

import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePictures;

public class NavigatorSelector implements Navigator {

	private Map<String, Navigator> navigators;
	private String selectedNavigator;
	
	public NavigatorSelector() {
		this.navigators = new HashMap<String, Navigator>();
	}
	
	@Override
	public void loopStart() {
		for(Navigator navigator : this.navigators.values()){
			navigator.loopStart();
		}
		
	}

	@Override
	public void loopStop() {
		for(Navigator navigator : this.navigators.values()){
			navigator.loopStop();
		}
	}

	@Override
	public void next() {
		this.navigators.get(this.selectedNavigator).next();
	}

	@Override
	public void previous() {
		this.navigators.get(this.selectedNavigator).previous();
	}

	public void addNavigator(String navigatorName, Navigator navigator) {
		this.navigators.put(navigatorName, navigator);		
	}
	
	public void setNavigator(String name){
		this.selectedNavigator = name;
	}

	@Override
	public void setDataSourcePictures(DataSourcePictures dataSourcePictures) {	
		for(Navigator navigator : this.navigators.values()){
			navigator.setDataSourcePictures(dataSourcePictures);
		}
	}
}
