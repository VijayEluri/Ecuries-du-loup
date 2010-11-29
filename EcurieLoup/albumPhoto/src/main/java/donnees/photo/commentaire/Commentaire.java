package donnees.photo.commentaire;

import donnees.User;
import donnees.photo.Photo;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Commentaire extends DataWtihLongIdAbstract<Commentaire> implements DataWithLongId{
	private long id;
	private Photo photo;
	private User posteur;
	private long date;
	private String contenu;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public User getPosteur() {
		return posteur;
	}
	public void setPosteur(User posteur) {
		this.posteur = posteur;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Commentaire))
			return false;
		Commentaire commentaire = (Commentaire) obj;
		return commentaire.id == this.id;
	}
}
