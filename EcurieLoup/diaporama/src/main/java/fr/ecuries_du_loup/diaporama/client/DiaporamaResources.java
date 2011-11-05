package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DiaporamaResources extends ClientBundle {

	public static final DiaporamaResources INSTANCE =GWT.create(DiaporamaResources.class);
	
	@Source("icone_visionneuse.gif")
	public ImageResource diaporamaIcon();
	
	@Source("Diaporama.css")
	public DiaporamaCss DiaporamaCss();
}
