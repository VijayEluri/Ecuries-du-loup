package fr.ecuries_du_loup.diaporama.client.control;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePictures;
import fr.ecuries_du_loup.diaporama.client.engine.DataSourcePicturesImpl;
import fr.ecuries_du_loup.diaporama.client.engine.PictureLoaderAsync;
import fr.ecuries_du_loup.diaporama.client.engine.Scheduler;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.Navigator;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.NavigatorSelector;
import fr.ecuries_du_loup.diaporama.client.ihm.Ihm;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class DiaporamaControlImpl implements DiaporamaControl {
	private Ihm ihm;
	private Navigator navigator;
	private PictureLoaderAsync pictureLoader;
	private Scheduler scheduler;
	
	
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;		
	}
	public void setIhm(Ihm ihm) {
		this.ihm = ihm;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

	public void setPictureLoader(PictureLoaderAsync pictureLoader) {
		this.pictureLoader = pictureLoader;
	}

	@Override
	public void loadAlbum(long id) {
		this.pictureLoader.loadAlbum(id, new AsyncCallback<List<Picture>>() {
			
			@Override
			public void onSuccess(List<Picture> result) {
				DataSourcePictures dataSourcePictures = new DataSourcePicturesImpl();
				dataSourcePictures.setPictures(result);
				DiaporamaControlImpl.this.navigator.setDataSourcePictures(dataSourcePictures);
				DiaporamaControlImpl.this.navigator.next();
			}
			
			@Override
			public void onFailure(Throwable caught) {
			//	Window.alert(caught.getMessage());
				
			}
		});

	}

	@Override
	public void loadAllPicture() {
		this.pictureLoader.loadAllPicture(new AsyncCallback<List<Picture>>() {
			
			@Override
			public void onSuccess(List<Picture> result) {
				DataSourcePictures dataSourcePictures = new DataSourcePicturesImpl();
				dataSourcePictures.setPictures(result);
				DiaporamaControlImpl.this.navigator.setDataSourcePictures(dataSourcePictures);
				DiaporamaControlImpl.this.navigator.next();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
				
			}
		});
	}

	@Override
	public void loopStart() {
		this.navigator.loopStart();

	}

	@Override
	public void loopStop() {
		this.navigator.loopStop();

	}

	@Override
	public void next() {
		this.navigator.next();
		this.scheduler.reinitializeWanted();
	}

	@Override
	public void previous() {
		this.navigator.previous();
		this.scheduler.reinitializeWanted();

	}

	@Override
	public void setPicture(Picture picture) {
		this.ihm.setPicture(picture);

	}
	@Override
	public void disableNext() {
		this.ihm.disableNext();
	}
	@Override
	public void disablePrevious() {
		this.ihm.disablePrevious();
	}
	@Override
	public void enableNext() {
		this.ihm.enableNext();
	}
	@Override
	public void enablePrevious() {
		this.ihm.enablePrevious();
	}

	@Override
	public void startTimer() {
		this.scheduler.start();
		
	}

	@Override
	public void stopTimer() {
		this.scheduler.stop();
		
	}
	@Override
	public void randomReading() {
		((NavigatorSelector)this.navigator).setNavigator("random");
		
	}
	@Override
	public void sequentialReading() {
		((NavigatorSelector)this.navigator).setNavigator("sequential");
		
	}

	
	
	

}
