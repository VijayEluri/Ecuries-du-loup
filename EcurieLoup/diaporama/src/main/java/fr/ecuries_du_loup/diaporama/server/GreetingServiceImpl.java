package fr.ecuries_du_loup.diaporama.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.ecuries_du_loup.diaporama.client.engine.PictureLoader;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
PictureLoader {


	public List<Integer> getIdPhoto() {
		List<Integer> idPictures = new ArrayList<Integer>();
		for(int i = 1; i <= 4; i++){
			idPictures.add(i);
		}
		idPictures.add(8);
		for(int i = 12; i <= 80; i++){
			idPictures.add(i);
		}
		idPictures.add(1041);
		idPictures.add(1253);
		idPictures.add(2694);
		return idPictures;
	}

	@Override
	public List<Picture> loadAlbum(long idAlbum) {
		List<Picture> liste = new ArrayList<Picture>();
		for(Integer i : this.getIdPhoto()){
			Picture picture = new Picture();
			picture.setId(i);
			liste.add(picture);
		}
		return liste;
	}

	@Override
	public List<Picture> loadAllPicture() {
		List<Picture> liste = new ArrayList<Picture>();
		for(Integer i : this.getIdPhoto()){
			Picture picture = new Picture();
			picture.setId(i);
			liste.add(picture);
		}
		return liste;
	}

	
}
