package service.photo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import service.UtilisateurManager;
import album_photo.CommentaireDAO;
import album_photo.MediaDAO;
import album_photo.TagDAO;
import dao.photo.AlbumDAO;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class MediaManagerImpl implements MediaManager {
	private AlbumDAO albumDAO;
	private MediaDAO mediaDAO;
	private CommentaireDAO commentaireDAO;
	private TagDAO tagDAO;

	private String pathPhotoInProjet;


	private UtilisateurManager utilisateurManager;

	//Is use to replace this and transaction is made
	private MediaManager reflector;



	public void init(){

	}
	public void setReflector(MediaManager reflector) {
		this.reflector = reflector;
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
		this.mediaDAO.add(media);
		String[] s = fichierMedia.getName().split("\\.");
		String extention = "";
		if(s.length > 1){	
			extention = s[s.length -1];
		}
		String location = pathServeur+this.pathPhotoInProjet;
		
		String name = media.getId()+"."+extention;
		
		
		File ancienFichier = new File(location+name);
		if(ancienFichier.exists()){
			ancienFichier.delete();

		}
		this.copierFichier(fichierMedia.getAbsolutePath(),  location+name);
	}
	
	private void copierFichier(String entree, String sortie){
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
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {}
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
		for(Media media : album.getMedias()){
			this.reflector.supprimerMedia(media, pathServeur);
		}
		this.albumDAO.remove(album);

	}

	@Override
	public void supprimerMedia(Media media, String pathServeur) {
		for(Tag tag : media.getTags()){
			this.supprimerTag(tag);
		}

		for(Commentaire commentaire : media.getCommentaires()){
			this.supprimerCommentaire(commentaire);
		}		
		this.mediaDAO.remove(media);		
	}

	@Override
	public Media recupererMedia(long id) {
		Media media = this.mediaDAO.findById(id);

		if(media !=null){
			media.setAlbum(this.gestionAlbum(media.getAlbum()));
			media = this.gestionTag(media);
			media = this.gestionCommentaire(media);
		}
		return media;
	}

	private Media gestionTag(Media media){
		List<Tag> listeTag = new ArrayList<Tag>();
		for(Tag tag : media.getTags()){
			if(tag != null){
				listeTag.add(tag);

			}
		}

		media.setTags(listeTag);
		return media;
	}

	private Media gestionCommentaire(Media media){
		List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
		for(Commentaire commentaire : media.getCommentaires()){
			if(commentaire != null){
				listeCommentaire.add(commentaire);
			}
		}

		media.setCommentaires(listeCommentaire);
		return media;
	}

	@Override
	public Album recupererAlbum(long id) {
		Album album = this.albumDAO.findById(id);

		if(album != null){
			album = this.gestionAlbum(album);
		}
		return album;
	}
	private Album gestionAlbum(Album album){
		if(album != null){

			List<Media> nouvelleListePhotos = new ArrayList<Media>();
			for(Media media : album.getMedias()){
				if(media != null){

					media = this.gestionTag(media);
					media = this.gestionCommentaire(media);
					nouvelleListePhotos.add(media);
				}
			}
			album.setMedias(nouvelleListePhotos);
			User utilisateurCourant = this.utilisateurManager.getUtilisateurCourant();
			if(utilisateurCourant != null){
				long dateLecture = this.albumDAO.getReadingDate(album, utilisateurCourant);
				album.setDateLecture(dateLecture);
			}
		}
		return album;
	}

	@Override
	public List<Album> recupererTousLesAlbums() {
		List<Album> albums = new ArrayList<Album>();
		for(Album album : this.albumDAO.findAll()){
			albums.add(this.gestionAlbum(album));
		}
		return albums;
	}

	@Override
	public Commentaire recupererCommentaire(long idCommentaire) {
		return this.commentaireDAO.findById(idCommentaire);
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
	public void creerAlbum(File fichierZip, User posteur, String pathServeur) {
		String nom = fichierZip.getName();
		nom = nom.split("_tmpZip_")[0];
		nom = nom.split("\\.")[0];

		Album album = new Album();
		album.setTitre(nom);

		this.reflector.creerAlbum(album);

		this.reflector.creerZipMedia(fichierZip, album, posteur, pathServeur);

	}

	@Override
	public void creerZipMedia(File fichierZip, Album album, User posteur, String pathServeur){
		final int BUFFER = 2048;
		byte data[] = new byte[BUFFER];
		//TODO : faire un zip manager
		BufferedOutputStream dest = null;
		try {
			FileInputStream fis = new FileInputStream(fichierZip.getAbsolutePath());
			BufferedInputStream buffi = new BufferedInputStream(fis);
			ZipInputStream zis = new ZipInputStream(buffi);
			ZipEntry entry;
			try {
				while((entry = zis.getNextEntry()) != null) {
					FileOutputStream fos = new FileOutputStream(entry.getName());
					dest = new BufferedOutputStream(fos, BUFFER);
					int count;
					while ((count = zis.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, count);
					}
					dest.flush();
					dest.close();

					Media media = new Media();
					media.setAlbum(album);
					media.setPosteur(posteur);
					media.setDescription("");
					media.setDatePostage(new Date().getTime());
					media.setTypeAdding("zip");

					File fichierMedia = new File(entry.getName());
					this.reflector.creerMedia(media, fichierMedia, pathServeur);
					fichierMedia.delete();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					zis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void visionnnageAlbum(Album album) {
		User utilisateurCourant = this.utilisateurManager.getUtilisateurCourant();
		if(utilisateurCourant!= null){
			this.albumDAO.seeAlbum(album, utilisateurCourant);
		}

	}



	@Override
	public boolean hasNouvellesMedias() {
		boolean hasNouvellesMedias = false;

		for(Album album : this.recupererTousLesAlbums()){
			if(album.isPhotoNonVu()){
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
		List<Media> mediasNonVu = new ArrayList<Media>();

		for(Album album : this.recupererTousLesAlbums()){
			mediasNonVu.addAll(album.getPhotoNonVu());

		}
		return mediasNonVu;
	}
	@Override
	public Media getLastMedia() {
		List<Media> medias = this.mediaDAO.findAll();
		int indexLastMedia = medias.size() -1;
		return medias.get(indexLastMedia);
	}
	
	
	@Override
	public List<Media> getTagContent(User user) {
		List<Tag> tags = this.tagDAO.getTagOnUser(user);
		List<Media> medias = new ArrayList<Media>();
		for(Tag tag : tags){
			medias.add(tag.getPhoto());
		}
		return medias;
	}
	@Override
	public List<Media> getTagContent(long horseIdentifier) {
		List<Tag> tags = this.tagDAO.getTagOnHorse(horseIdentifier);
		List<Media> medias = new ArrayList<Media>();
		for(Tag tag : tags){
			medias.add(tag.getPhoto());
		}
		return medias;
	}

}
