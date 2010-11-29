package donnees.photo;

import java.util.ArrayList;
import java.util.List;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Album extends DataWtihLongIdAbstract<Album> implements DataWithLongId{
	private String titre;
	private List<Photo> photos;

	//hors persistance
	private long dateLecture;
	
	public Album(){
		this.photos = new ArrayList<Photo>();
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
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
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
		
		for(Photo photo : this.photos){
			if(photo != null){
				if(photo.getDatePostage() > this.getDateLecture()){
					hasPhotoNonVu = true;
					break;
				}
			}
		}
		return hasPhotoNonVu;
	}

	public List<Photo> getPhotoNonVu() {
		List<Photo> photosNonVu = new ArrayList<Photo>();
		
		for(Photo photo : this.photos){
			if(photo != null){
				if(photo.getDatePostage() > this.getDateLecture()){
					photosNonVu.add(photo);
				}
			}
		}
		return photosNonVu;
	}
	
}
