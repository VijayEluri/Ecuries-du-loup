package donnees.photo;

import java.util.ArrayList;
import java.util.List;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Album extends DataWtihLongIdAbstract<Album> implements DataWithLongId{
	private String titre;
	private List<Media> medias;

	//hors persistance
	private long dateLecture;
	
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
	

	public long getDateLecture() {
		return dateLecture;
	}

	public void setDateLecture(long dateLecture) {
		this.dateLecture = dateLecture;
	}
	
	public String toString(){
		String retour = "";
		
		retour += "Album : \n";
		retour += "id : "+this.id+" \n";
		retour += "titre : "+this.titre+" \n";
		
		return retour;
	}
	
	public boolean isPhotoNonVu(){
		boolean hasPhotoNonVu = false;
		
		for(Media media : this.medias){
			if(media != null){
				if(media.getDatePostage() > this.getDateLecture()){
					hasPhotoNonVu = true;
					break;
				}
			}
		}
		return hasPhotoNonVu;
	}

	public List<Media> getPhotoNonVu() {
		List<Media> photosNonVu = new ArrayList<Media>();
		
		for(Media media : this.medias){
			if(media != null){
				if(media.getDatePostage() > this.getDateLecture()){
					photosNonVu.add(media);
				}
			}
		}
		return photosNonVu;
	}
	
}
