package service.photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import service.UtilisateurManager;
import album_photo.CommentaireDAO;
import album_photo.MediaDAO;
import album_photo.TagDAO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import dao.photo.AlbumDAO;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;

public class MediaManagerImpl implements MediaManager {
    private AlbumDAO albumDAO;
    private MediaDAO mediaDAO;
    private CommentaireDAO commentaireDAO;
    private TagDAO tagDAO;

    private String pathPhotoInProjet;

    private UtilisateurManager utilisateurManager;
    @Autowired
    private EdlCode edlCode;

    public void setEdlCode(EdlCode edlCode) {
	this.edlCode = edlCode;
    }

    public void setAlbumDAO(AlbumDAO albumDAO) {
	this.albumDAO = albumDAO;
    }

    public void setMediaDAO(MediaDAO mediaDAO) {
	this.mediaDAO = mediaDAO;
    }

    public void setCommentaireDAO(CommentaireDAO commentaireDAO) {
	this.commentaireDAO = commentaireDAO;
    }

    public void setTagDAO(TagDAO tagDAO) {
	this.tagDAO = tagDAO;
    }

    public void setPathPhotoInProjet(String pathPhotoInProjet) {
	this.pathPhotoInProjet = pathPhotoInProjet;
    }

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    @Override
    public void creerAlbum(Album album) {
	this.albumDAO.add(album);
    }

    @Override
    public void creerMedia(Media media, File fichierMedia, String pathServeur) {
	try {
	    media.setShotDate(this.extractImageDate(fichierMedia));
	} catch (ImageProcessingException e) {
	} catch (IOException e) {
	}
	this.mediaDAO.add(media);
	// addeur has already see the picture
	User connectedUser = this.utilisateurManager.getUtilisateurCourant();
	this.readMedia(media, connectedUser);

	String[] s = fichierMedia.getName().split("\\.");
	String extention = "";
	if (s.length > 1) {
	    extention = s[s.length - 1];
	}
	String location = pathServeur + this.pathPhotoInProjet;

	String name = media.getId() + "." + extention;

	File ancienFichier = new File(location + name);
	if (ancienFichier.exists()) {
	    ancienFichier.delete();

	}
	this.copierFichier(fichierMedia.getAbsolutePath(), location + name);

    }

    private Date extractImageDate(File fichierMedia) throws ImageProcessingException, IOException {
	Metadata metadata = ImageMetadataReader.readMetadata(fichierMedia);
	// obtain the Exif directory
	ExifSubIFDDirectory directory = metadata.getDirectory(ExifSubIFDDirectory.class);

	// query the tag's value
	Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);

	return date;
    }

    private void copierFichier(String entree, String sortie) {
	FileChannel in = null; // canal d'entrée
	FileChannel out = null; // canal de sortie

	try {
	    // Init
	    in = new FileInputStream(entree).getChannel();
	    out = new FileOutputStream(sortie).getChannel();

	    // Copie depuis le in vers le out
	    in.transferTo(0, in.size(), out);
	} catch (Exception e) {
	    e.printStackTrace(); // n'importe quelle exception
	} finally { // finalement on ferme
	    if (in != null) {
		try {
		    in.close();
		} catch (IOException e) {
		}
	    }
	    if (out != null) {
		try {
		    out.close();
		} catch (IOException e) {
		}
	    }
	}
    }

    @Override
    public void modifierMedia(Media media) {
	this.mediaDAO.update(media);
    }

    @Override
    public void modifierAlbum(Album album) {

	this.albumDAO.update(album);

    }

    @Override
    public void supprimerAlbum(Album album, String pathServeur) {
	for (Media media : album.getMedias()) {
	    this.supprimerMedia(media, pathServeur);
	}
	this.albumDAO.remove(album);

    }

    @Override
    public void supprimerMedia(Media media, String pathServeur) {
	for (Tag tag : media.getTags()) {
	    this.supprimerTag(tag);
	}

	for (Commentaire commentaire : media.getCommentaires()) {
	    this.supprimerCommentaire(commentaire);
	}
	this.mediaDAO.remove(media);
    }

    @Override
    public Media recupererMedia(long id) {
	Media media = this.getMedia(id);

	if (media != null) {
	    media.setAlbum(this.gestionAlbum(media.getAlbum()));
	    media = this.gestionTag(media);
	    // media = this.gestionCommentaire(media);
	}
	return media;
    }

    @Override
    public Media getMedia(long id) {
	Media media = this.mediaDAO.findById(id);
	return media;
    }

    private Media gestionTag(Media media) {
	List<Tag> listeTag = new ArrayList<Tag>();
	for (Tag tag : media.getTags()) {
	    if (tag != null) {
		listeTag.add(tag);

	    }
	}

	media.setTags(listeTag);
	return media;
    }

    private Commentaire formatedComment(Commentaire comment) {
	Commentaire formatedComment = new Commentaire(comment);
	try {
	    formatedComment.setContenu(this.edlCode.parse(formatedComment.getContenu()));
	} catch (EdlCodeEncodageException e) {
	}
	return formatedComment;

    }

    private Media gestionCommentaire(Media media) {
	List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
	for (Commentaire commentaire : media.getCommentaires()) {
	    if (commentaire != null) {
		listeCommentaire.add(this.formatedComment(commentaire));
	    }
	}

	media.setCommentaires(listeCommentaire);
	return media;
    }

    @Override
    public Album recupererAlbum(long id) {
	Album album = this.albumDAO.findById(id);

	if (album != null) {
	    album = this.gestionAlbum(album);
	}
	return album;
    }
    @Override
    public Album recupererAlbumLight(long id) {
		Album album = this.albumDAO.findById(id);
	
		if (album != null) {
			User connectedUser = this.utilisateurManager.getUtilisateurCourant();
			List<Media> mediasRead = this.albumDAO.getMediaReadForAlbum(album, connectedUser);
		   
			for(Media media : mediasRead){
				int index = album.getMedias().indexOf(media);
				album.getMedias().get(index).setReadByCurrentUser(true);
			}
			//delete null media
			List<Media> mediasNotNull = new ArrayList<Media>();
			for(Media media : album.getMedias()){
				if(media != null){
					mediasNotNull.add(media);
				}
			}
			album.setMedias(mediasNotNull);
			//sort media
		   Collections.sort(album.getMedias(), new Comparator<Media>() {

				@Override
				public int compare(Media arg0, Media arg1) {
				    if (arg0.getShotDate() == null) {
					if (arg1.getShotDate() == null) {
					    return 0;
					} else {
					    return -1;
					}
				    }
				    if (arg1.getShotDate() == null) {
					return 1;

				    }

				    int value = arg0.getShotDate().compareTo(arg1.getShotDate());
				    return value;
				}

			    });
		}
		return album;
    }

    private Album gestionAlbum(Album album) {
	if (album != null) {

	    User connectedUser = this.utilisateurManager.getUtilisateurCourant();

	    List<Media> nouvelleListePhotos = new ArrayList<Media>();
	    for (Media media : album.getMedias()) {
		if (media != null) {
				media = this.gestionTag(media);
				media = this.gestionCommentaire(media);
			
		    media = this.fillReading(media, connectedUser);
		    nouvelleListePhotos.add(media);
		}
	    }
	    
	    Collections.sort(nouvelleListePhotos, new Comparator<Media>() {

		@Override
		public int compare(Media arg0, Media arg1) {
		    if (arg0.getShotDate() == null) {
			if (arg1.getShotDate() == null) {
			    return 0;
			} else {
			    return -1;
			}
		    }
		    if (arg1.getShotDate() == null) {
			return 1;

		    }

		    int value = arg0.getShotDate().compareTo(arg1.getShotDate());
		    return value;
		}

	    });

	    album.setMedias(nouvelleListePhotos);
	    // add flag not see media in album
	    album.setMediasNotSee(this.albumDAO.isAlbumHasNotSeeMedia(album, connectedUser));
	}
	return album;
    }

    private Album albumManageLight(Album album) {
	if (album != null) {
	    User connectedUser = this.utilisateurManager.getUtilisateurCourant();
	    // add flag not see media in album
	    album.setMediasNotSee(this.albumDAO.isAlbumHasNotSeeMedia(album, connectedUser));
	}
	return album;
    }

    private Media fillReading(Media media, User connectedUser) {
	boolean see = this.mediaDAO.isMediaSee(media, connectedUser);
	media.setReadByCurrentUser(see);
	return media;
    }

    @Override
    public List<Album> recupererTousLesAlbums() {
	List<Album> albums = new ArrayList<Album>();
	for (Album album : this.albumDAO.findAll()) {
	    albums.add(this.gestionAlbum(album));
	}
	return albums;
    }

    @Override
    public List<Album> getAllAlbumsLigth() {
	List<Album> albums = new ArrayList<Album>();
	for (Album album : this.albumDAO.findAll()) {
	    albums.add(this.albumManageLight(album));
	}
	return albums;
    }

    @Override
    public Commentaire recupererCommentaire(long idCommentaire) {
	return this.formatedComment(this.commentaireDAO.findById(idCommentaire));
    }

    @Override
    public void creerCommentaire(Commentaire commentaire) {
	this.commentaireDAO.add(commentaire);
    }

    @Override
    public void modifierCommentaire(Commentaire commentaire) {
	this.commentaireDAO.update(commentaire);
    }

    @Override
    public void creerTag(Tag tag) {
	this.tagDAO.add(tag);
    }

    @Override
    public void supprimerCommentaire(Commentaire commentaire) {
	this.commentaireDAO.remove(commentaire);

    }

    @Override
    public void supprimerTag(Tag tag) {
	this.tagDAO.remove(tag);

    }

    @Override
    public boolean hasNouvellesMedias() {
	boolean hasNouvellesMedias = false;

	for (Album album : this.recupererTousLesAlbums()) {
	    if (album.isMediasNotSee()) {
		hasNouvellesMedias = true;
		break;
	    }
	}
	return hasNouvellesMedias;

    }

    @Override
    public int getNombreNouvellesMedias() {
	int nombrePhotosNonVue = this.recupererMediasNonVu().size();
	return nombrePhotosNonVue;
    }

    @Override
    public List<Media> recupererMediasNonVu() {
	User connectedUser = this.utilisateurManager.getUtilisateurCourant();
	List<Media> mediasNonVu = this.mediaDAO.getMediasNotSee(connectedUser);
	return mediasNonVu;
    }

    @Override
    public Media getLastMedia() {
	List<Media> medias = this.mediaDAO.findAll();
	int indexLastMedia = medias.size() - 1;
	return medias.get(indexLastMedia);
    }

    @Override
    public List<Media> getTagContent(User user) {
	List<Tag> tags = this.tagDAO.getTagOnUser(user);
	List<Media> medias = new ArrayList<Media>();
	for (Tag tag : tags) {
	    medias.add(tag.getPhoto());
	}
	return medias;
    }

    @Override
    public List<Media> getTagContent(long horseIdentifier) {
	User connectedUser = this.utilisateurManager.getUtilisateurCourant();
	List<Tag> tags = this.tagDAO.getTagOnHorse(horseIdentifier);
	List<Media> medias = new ArrayList<Media>();
	for (Tag tag : tags) {
	    medias.add(this.fillReading(tag.getPhoto(), connectedUser));
	}
	return medias;
    }

    @Override
    public void readMedia(final Media media, User user) {
	MediaManagerImpl.this.mediaDAO.seeMedia(media, user);

    }

    @Override
    public List<Tag> getMediasTags(long mediaId) {
	return this.mediaDAO.getMediasTags(mediaId);
    }

    @Override
    public List<Commentaire> getMediasComments(long mediaId) {
	return this.mediaDAO.getMediasComments(mediaId);
    }

    @Override
    public Tag getTag(long tagId) {
	return this.tagDAO.findById(tagId);
    }

}
