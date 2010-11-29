package donnees.photo;

import java.util.ArrayList;
import java.util.List;

import donnees.User;
import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Photo extends DataWtihLongIdAbstract<Photo> implements DataWithLongId{
	private String description;
	private User posteur;
	private long datePostage;
	private Album album;
	private List<Commentaire> commentaires;
	private List<Tag> tags;
	
	
	

	public Photo(){
		this.commentaires = new ArrayList<Commentaire>();
		this.tags = new ArrayList<Tag>();
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getPosteur() {
		return posteur;
	}
	public void setPosteur(User posteur) {
		this.posteur = posteur;
	}
	public long getDatePostage() {
		return datePostage;
	}

	public void setDatePostage(long datePostage) {
		this.datePostage = datePostage;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}	
	

	public String toString(){
		String retour = "";
		
		retour += "photo : \n";
		retour += "id : "+id+"\n";
		retour += "description : "+description+"\n";
		if(posteur!=null){
			retour += "posteur : "+posteur.getLogin()+"\n";
		}
		if(album!=null){
			retour += "album : "+album.getId()+"\n";
		}
		
		return retour;
	}
}
