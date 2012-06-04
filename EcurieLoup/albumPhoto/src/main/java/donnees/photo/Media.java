package donnees.photo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import donnees.User;
import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Media extends DataWtihLongIdAbstract<Media> implements DataWithLongId {
    private String description;
    private TypeMedia type;
    private User posteur;
    private long datePostage;
    private Date shotDate;
    private Album album;
    private List<Commentaire> commentaires;
    private List<Tag> tags;
    private String typeAdding;

    private boolean readByCurrentUser;

    public Media() {
	this.commentaires = new ArrayList<Commentaire>();
	this.tags = new ArrayList<Tag>();
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public User getPosteur() {
	return this.posteur;
    }

    public void setPosteur(User posteur) {
	this.posteur = posteur;
    }

    public long getDatePostage() {
	return this.datePostage;
    }

    public void setDatePostage(long datePostage) {
	this.datePostage = datePostage;
    }

    public Date getShotDate() {
	return this.shotDate;
    }

    public void setShotDate(Date shotDate) {
	this.shotDate = shotDate;
    }

    public Album getAlbum() {
	return this.album;
    }

    public void setAlbum(Album album) {
	this.album = album;
    }

    public List<Commentaire> getCommentaires() {
	return this.commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
	this.commentaires = commentaires;
    }

    public List<Tag> getTags() {
	return this.tags;
    }

    public void setTags(List<Tag> tags) {
	this.tags = tags;
    }

    public String getTypeAdding() {
	return this.typeAdding;
    }

    public void setTypeAdding(String typeAdding) {
	this.typeAdding = typeAdding;
    }

    public int getType() {
	if (this.type != null) {
	    return this.type.ordinal();
	} else {
	    return 0;
	}
    }

    public void setType(int type) {
	if (type == 0) {
	    this.type = TypeMedia.Photo;
	} else if (type == 1) {
	    this.type = TypeMedia.Video;
	} else {

	    throw new RuntimeException("case not manage");
	}

    }

    public boolean isReadByCurrentUser() {
	return this.readByCurrentUser;
    }

    public void setReadByCurrentUser(boolean readByCurrentUser) {
	this.readByCurrentUser = readByCurrentUser;
    }

    @Override
    public String toString() {
	String retour = "";

	retour += "photo : \n";
	retour += "id : " + this.id + "\n";
	retour += "description : " + this.description + "\n";
	if (this.posteur != null) {
	    retour += "posteur : " + this.posteur.getLogin() + "\n";
	}
	if (this.album != null) {
	    retour += "album : " + this.album.getId() + "\n";
	}

	return retour;
    }
}
