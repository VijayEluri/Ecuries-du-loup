package fr.ecuries_du_loup.diaporama.client.engine;

import java.util.List;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public interface DataSourcePictures {

	public void setPictures(List<Picture> pictures);
	
	public int PicturesNumber();
	
	public Picture setIndex(int index);
	
	public int getIndex();
	
	public List<Integer> indexHistory();
	
	public Picture getHistory(int numberOfTime);
	
	
}
