package fr.ecuries_du_loup.diaporama.client.control;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public interface DiaporamaControl {

	public void setPicture(Picture picture);
	
	
	public void previous();
	public void next();
	
	public void loopStart();
	public void loopStop();
	
	public void loadAllPicture();
	public void loadAlbum(long id);
	
	public void enableNext();
	public void disableNext();
	
	public void enablePrevious();
	public void disablePrevious();
	
	public void startTimer();
	public void stopTimer();
	
	public void randomReading();
	public void sequentialReading();
}
