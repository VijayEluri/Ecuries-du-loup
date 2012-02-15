package fr.ecuriesduloup.imagechooser.client.ui.siteimage;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VStack;

import fr.ecuriesduloup.imagechooser.shared.Album;


public class AlbumPanel extends VStack {

	public AlbumPanel(Album album) {
		this.setBackgroundColor("#C3D9FF");
		this.setBorder("1px solid #808080");
		this.setAlign(Alignment.CENTER);
		
		VStack panel = new VStack();
		Label label = new Label(album.getName());
		label.setAlign(Alignment.CENTER);
		panel.addMember(label);
		
		this.addChild(panel);
	}

}
