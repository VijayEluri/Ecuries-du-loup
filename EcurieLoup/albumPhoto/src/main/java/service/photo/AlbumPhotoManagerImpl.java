package service.photo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import service.UtilisateurManager;
import util.PhotoUtil;
import album_photo.CommentaireDAO;
import album_photo.PhotoDAO;
import album_photo.TagDAO;
import dao.photo.AlbumDAO;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class AlbumPhotoManagerImpl implements AlbumPhotoManager {
	private AlbumDAO albumDAO;
	private PhotoDAO photoDAO;
	private CommentaireDAO commentaireDAO;
	private TagDAO tagDAO;
	
	private String pathPhotoInProjet;
	private PhotoUtil photoUtil;
	

	private UtilisateurManager utilisateurManager;
	
	//Is use to replace this and transaction is made
	private AlbumPhotoManager reflector;

	

	public void init(){
		
	}
	public void setReflector(AlbumPhotoManager reflector) {
		this.reflector = reflector;
	}



	public void setAlbumDAO(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}



	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
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



	public void setPhotoUtil(PhotoUtil photoUtil) {
		this.photoUtil = photoUtil;
	}




	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public void creerAlbum(Album album) {
		this.albumDAO.add(album);		
	}



	@Override
	public void creerPhoto(Photo photo, File fichierPhoto, String pathServeur) {
		this.photoDAO.add(photo);	
		this.photoUtil.creerFicherSurDisque(pathServeur+this.pathPhotoInProjet, ""+photo.getId(), fichierPhoto);


	}


	@Override
	public void modifierPhoto(Photo photo) {
		this.photoDAO.update(photo);
	}

	@Override
	public void modifierAlbum(Album album) {

		this.albumDAO.update(album);

	}

	@Override
	public void supprimerAlbum(Album album, String pathServeur) {
		for(Photo photo : album.getPhotos()){
			this.reflector.supprimerPhoto(photo, pathServeur);
		}
		this.albumDAO.remove(album);

	}

	@Override
	public void supprimerPhoto(Photo photo, String pathServeur) {
		for(Tag tag : photo.getTags()){
			this.supprimerTag(tag);
		}

		for(Commentaire commentaire : photo.getCommentaires()){
			this.supprimerCommentaire(commentaire);
		}
		String pathSortiePhoto = pathServeur+this.pathPhotoInProjet+photo.getId();
		this.photoUtil.supprimerFicherSurDisque(pathSortiePhoto);
		this.photoDAO.remove(photo);		
	}

	@Override
	public Photo recupererPhoto(long id) {
		Photo photo = this.photoDAO.findById(id);

		if(photo !=null){
			photo.setAlbum(this.gestionAlbum(photo.getAlbum()));
			photo = this.gestionTag(photo);
			photo = this.gestionCommentaire(photo);
		}
		return photo;
	}

	private Photo gestionTag(Photo photo){
		List<Tag> listeTag = new ArrayList<Tag>();
		for(Tag tag : photo.getTags()){
			if(tag != null){
				listeTag.add(tag);
				
			}
		}

		photo.setTags(listeTag);
		return photo;
	}

	private Photo gestionCommentaire(Photo photo){
		List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
		for(Commentaire commentaire : photo.getCommentaires()){
			if(commentaire != null){
				listeCommentaire.add(commentaire);
			}
		}

		photo.setCommentaires(listeCommentaire);
		return photo;
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

			List<Photo> nouvelleListePhotos = new ArrayList<Photo>();
			for(Photo photo : album.getPhotos()){
				if(photo != null){

					photo = this.gestionTag(photo);
					photo = this.gestionCommentaire(photo);
					nouvelleListePhotos.add(photo);
				}
			}
			album.setPhotos(nouvelleListePhotos);
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

		this.reflector.creerZipPhoto(fichierZip, album, posteur, pathServeur);

	}

	@Override
	public void creerZipPhoto(File fichierZip, Album album, User posteur, String pathServeur){
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

					Photo photo = new Photo();
					photo.setAlbum(album);
					photo.setPosteur(posteur);
					photo.setDescription("");
					photo.setDatePostage(new Date().getTime());
					photo.setTypeAdding("zip");
					
					File fichierPhoto = new File(entry.getName());
					this.reflector.creerPhoto(photo, fichierPhoto, pathServeur);
					fichierPhoto.delete();
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
	public boolean hasNouvellesPhotos() {
		boolean hasNouvellesPhotos = false;
		
		for(Album album : this.recupererTousLesAlbums()){
			if(album.isPhotoNonVu()){
				hasNouvellesPhotos = true;
				break;
			}
		}
		return hasNouvellesPhotos;
		
	}



	@Override
	public int getNombreNouvellesPhotos() {
		int nombrePhotosNonVue = this.recupererPhotosNonVu().size();
		return nombrePhotosNonVue;
	}



	@Override
	public List<Photo> recupererPhotosNonVu() {
		List<Photo> photosNonVu = new ArrayList<Photo>();
		
		for(Album album : this.recupererTousLesAlbums()){
			photosNonVu.addAll(album.getPhotoNonVu());
			
		}
		return photosNonVu;
	}
	@Override
	public Photo getLastPhoto() {
		List<Photo> photos = this.photoDAO.findAll();
		int indexLastPhoto = photos.size() -1;
		return photos.get(indexLastPhoto);
	}

}
