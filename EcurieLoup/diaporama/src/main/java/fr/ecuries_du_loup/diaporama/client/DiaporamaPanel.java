package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControl;
import fr.ecuries_du_loup.diaporama.client.ihm.Ihm;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class DiaporamaPanel extends Composite implements Ihm{
	private DockPanel panel;
	private ImagePanel imagePanel;
	private TelecommandePanel telecommandePanel;
	private DiaporamaControl diaporamaControl;
	

	public DiaporamaPanel(DiaporamaControl diaporamaControl){
		this.diaporamaControl = diaporamaControl;
		this.panel = new DockPanel();
		this.panel.setStyleName("panel");
		
		this.createImage();
		this.createTelecommande();
		
		initWidget(panel);
		
		
	}
	
	private void createImage(){
		this.imagePanel = new ImagePanel();
		this.panel.add(this.imagePanel, DockPanel.CENTER);
		
	}
	
	private void createTelecommande(){
		this.telecommandePanel = new TelecommandePanel(this.diaporamaControl);
		this.panel.add(telecommandePanel, DockPanel.EAST);
	}
	

	@Override
	public void setPicture(Picture picture) {
		this.imagePanel.setUrl("../images/albumPhoto/"+picture.getId());
	}

	@Override
	public void disableNext() {
		this.telecommandePanel.disableNext();
		
	}

	@Override
	public void disablePrevious() {
		this.telecommandePanel.disablePrevious();
		
	}

	@Override
	public void enableNext() {
		this.telecommandePanel.enableNext();
		
	}

	@Override
	public void enablePrevious() {
		this.telecommandePanel.enablePrevious();
		
	}
}
