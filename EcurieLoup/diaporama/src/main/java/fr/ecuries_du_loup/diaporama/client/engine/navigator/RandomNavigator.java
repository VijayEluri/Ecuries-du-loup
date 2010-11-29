package fr.ecuries_du_loup.diaporama.client.engine.navigator;

import java.util.ArrayList;
import java.util.List;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControl;
import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePictures;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class RandomNavigator implements Navigator {
	private DataSourcePictures dataSourcePictures;
	private DiaporamaControl diaporamaControl;
	private List<Integer> pictureNotView;
	private int retourHistory;
	
	private boolean loop;

	public RandomNavigator() {
		this.pictureNotView = new ArrayList<Integer>();
	}

	@Override
	public void loopStart() {
		this.loop = true;
		this.manageEnable();
	}

	@Override
	public void loopStop() {
		this.loop = false;
		this.manageEnable();
	}

	@Override
	public void next() {
		Picture picture;
		if(this.loop){
			picture = this.loopChoiseNext();
		}else{
			picture = this.notLoopChoiseNext();
		}
		this.diaporamaControl.setPicture(picture);
		this.manageEnable();

	}
	
	private Picture loopChoiseNext(){
		int number = this.dataSourcePictures.PicturesNumber();
		int index = (int)( Math.random() * number);
		return this.dataSourcePictures.setIndex(index);
		
	}
	
	private Picture notLoopChoiseNext(){
		Picture picture;
		if(this.isInHistory()){
			this.retourHistory--;
			picture = this.dataSourcePictures.getHistory(this.retourHistory);
			
		
		}else{
			int number = this.pictureNotView.size();
			
			int index = (int)( Math.random() * number);
	
			picture = this.dataSourcePictures.setIndex(this.pictureNotView.get(index));
			
			this.pictureNotView.remove(index);
			
			
		}
		return picture;
	}
	private boolean isInHistory(){
		return this.retourHistory != 0;
	}

	@Override
	public void previous() {
		this.retourHistory++;
		Picture picture = this.dataSourcePictures.getHistory(this.retourHistory);
		this.diaporamaControl.setPicture(picture);
		this.manageEnable();

	}

	@Override
	public void setDataSourcePictures(DataSourcePictures dataSourcePictures) {
		this.dataSourcePictures = dataSourcePictures;
		for(int i = 0; i < this.dataSourcePictures.PicturesNumber(); i++){
			this.pictureNotView.add(i);
		}

	}

	public void setDiaporamaControl(DiaporamaControl diaporamaControl) {
		this.diaporamaControl = diaporamaControl;
	}
	
	private void manageEnable(){		
		this.diaporamaControl.enableNext();
		this.diaporamaControl.enablePrevious();
		
		if(!loop){
			if(this.pictureNotView.size() ==0 && !this.isInHistory()){

				this.diaporamaControl.disableNext();
			}		
		}
		if(this.retourHistory == this.dataSourcePictures.indexHistory().size() -1 ){
			this.diaporamaControl.disablePrevious();
		}
	}

}
