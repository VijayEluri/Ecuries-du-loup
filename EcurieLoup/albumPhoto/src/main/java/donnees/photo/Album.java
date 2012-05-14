package donnees.photo;

import java.util.ArrayList;
import java.util.List;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Album extends DataWtihLongIdAbstract<Album> implements DataWithLongId{
	private String titre;
	private List<Media> medias;
	private boolean mediasNotSee;
	
	public Album(){
		this.medias = new ArrayList<Media>();
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Media> getMedias() {
		return this.medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	
	public boolean isMediasNotSee() {
		return mediasNotSee;
	}

	public void setMediasNotSee(boolean mediasNotSee) {
		this.mediasNotSee = mediasNotSee;
	}

	public String toString(){
		String retour = "";
		
		retour += "Album : \n";
		retour += "id : "+this.id+" \n";
		retour += "titre : "+this.titre+" \n";
		
		return retour;
	}
	
}
