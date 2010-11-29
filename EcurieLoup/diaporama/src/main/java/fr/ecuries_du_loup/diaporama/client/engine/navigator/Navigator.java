package fr.ecuries_du_loup.diaporama.client.engine.navigator;

import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePictures;


public interface Navigator {
	
	public void previous();
	public void next();
	
	
	public void loopStart();
	
	public void loopStop();
	
	public void setDataSourcePictures(DataSourcePictures dataSourcePictures);
	
	
}
