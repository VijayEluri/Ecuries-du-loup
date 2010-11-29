package fr.ecuries_du_loup.diaporama.client.engine;

import java.util.ArrayList;
import java.util.List;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class DataSourcePicturesImpl implements DataSourcePictures {
	private List<Picture> pictures;
	private List<Integer> indexHistory;
	
	public DataSourcePicturesImpl() {
		this.pictures = new ArrayList<Picture>();
		this.indexHistory = new ArrayList<Integer>();
	}
	
	@Override
	public int PicturesNumber() {
		return this.pictures.size();
	}

	@Override
	public int getIndex() {
		
		if(this.indexHistory.size()==0){
			return -1;
		}
		int index = this.indexHistory.size() -1;
		if(index < 0){
			index = 0;
		}
		return this.indexHistory.get(index);
	}

	@Override
	public List<Integer> indexHistory() {		
		return this.indexHistory;
	}

	@Override
	public Picture setIndex(int index) {
		this.indexHistory.add(index);
		return this.pictures.get(index);

	}

	@Override
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;

	}

	@Override
	public Picture getHistory(int numberOfTime) {
		int indexHistory = this.indexHistory.size() - numberOfTime -1;
		int index = this.indexHistory.get(indexHistory);
		return this.pictures.get(index);
	}

}
