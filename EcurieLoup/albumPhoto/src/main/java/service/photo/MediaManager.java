package service.photo;

import java.io.File;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public interface MediaManager {

    public List<Album> recupererTousLesAlbums();

    public List<Album> getAllAlbumsLigth();

    public Album recupererAlbum(long id);

    public void creerAlbum(Album album);

    public void modifierAlbum(Album album);

    public void supprimerAlbum(Album album, String pathServeur);

    public Media recupererMedia(long id);

    public Media getMedia(long id);

    public void creerMedia(Media media, File fichierMedia, String pathServeur);

    public void modifierMedia(Media media);

    public void supprimerMedia(Media media, String pathServeur);

    public Commentaire recupererCommentaire(long idCommentaire);

    public void creerCommentaire(Commentaire commentaire);

    public void modifierCommentaire(Commentaire commentaire);

    public void supprimerCommentaire(Commentaire commentaire);

    public void creerTag(Tag tag);

    public void supprimerTag(Tag tag);

    public List<Media> getTagContent(User user);

    // TODO : change long in fiche horse
    public List<Media> getTagContent(long horseIdentifier);

    public boolean hasNouvellesMedias();

    public int getNombreNouvellesMedias();

    public List<Media> recupererMediasNonVu();

    public void readMedia(Media media, User user);

    public Media getLastMedia();

}
