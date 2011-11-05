package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControl;
import fr.ecuries_du_loup.diaporama.client.ihm.Ihm;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class DiaporamaPanel extends Composite implements Ihm{
	private DockLayoutPanel panel;
	private ImagePanel imagePanel;
	private TelecommandePanel telecommandePanel;
	private DiaporamaControl diaporamaControl;
	

	public DiaporamaPanel(DiaporamaControl diaporamaControl){
		this.diaporamaControl = diaporamaControl;
		this.panel = new DockLayoutPanel(Unit.PC);
		this.panel.setStyleName(DiaporamaResources.INSTANCE.DiaporamaCss().panel());
		
		this.createImage();
		this.createTelecommande();
		
		initWidget(panel);
		
		
	}
	
	private void createImage(){
		this.imagePanel = new ImagePanel();
		this.panel.add(this.imagePanel);
		
	}
	
	private void createTelecommande(){
		this.telecommandePanel = new TelecommandePanel(this.diaporamaControl);
		this.panel.addEast(telecommandePanel, 15);
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
