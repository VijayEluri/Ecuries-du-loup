package fr.ecuries_du_loup.diaporama.client.engine.navigator;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControl;
import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePictures;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class SequentialNavigator implements Navigator{
	private boolean loop;
	private DataSourcePictures dataSourcePictures;
	private DiaporamaControl diaporamaControl;
	
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
		int index = this.dataSourcePictures.getIndex();
		int number = this.dataSourcePictures.PicturesNumber();
		Picture picture = null;

		this.diaporamaControl.enablePrevious();
		if(index >= number-1 && loop){
			picture= this.dataSourcePictures.setIndex(0);
		}else if(index < number){
			index++;
			picture = this.dataSourcePictures.setIndex(index);
		}
		this.diaporamaControl.setPicture(picture);
		this.manageEnable();
	}

	@Override
	public void previous() {
		int index = this.dataSourcePictures.getIndex();
		int number = this.dataSourcePictures.PicturesNumber();
		Picture picture = null;
		this.diaporamaControl.enableNext();
		if(index <= 0 && loop){
			picture = this.dataSourcePictures.setIndex(number-1);
		}else if(index > 0){
			index--;
			picture = this.dataSourcePictures.setIndex(index);
		
			
		}
		this.diaporamaControl.setPicture(picture);
		this.manageEnable();
		
	}

	
	
	@Override
	public void setDataSourcePictures(DataSourcePictures dataSourcePictures) {
		this.dataSourcePictures = dataSourcePictures;
	}

	public void setDiaporamaControl(DiaporamaControl diaporamaControl) {
		this.diaporamaControl = diaporamaControl;
	}

	
	private void manageEnable(){
		int index = this.dataSourcePictures.getIndex();

		int number = this.dataSourcePictures.PicturesNumber();

		
		this.diaporamaControl.enableNext();
		this.diaporamaControl.enablePrevious();
		
		if(!loop){
			if(index==0){
				this.diaporamaControl.disablePrevious();
			}
			
			if(index == number-1){
				this.diaporamaControl.disableNext();
			}
		}
	}
}
