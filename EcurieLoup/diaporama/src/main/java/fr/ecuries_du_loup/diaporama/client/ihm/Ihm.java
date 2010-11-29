package fr.ecuries_du_loup.diaporama.client.ihm;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public interface Ihm {

	public void setPicture(Picture picture);
	
	public void enableNext();
	public void disableNext();
	
	public void enablePrevious();
	public void disablePrevious();
	
	
}
