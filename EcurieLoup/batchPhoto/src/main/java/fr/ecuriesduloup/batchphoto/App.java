package fr.ecuriesduloup.batchphoto;

import java.io.File;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import service.photo.AlbumPhotoManager;
import service.photo.AlbumPhotoManagerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AlbumPhotoManager albumPhotoManager = new AlbumPhotoManagerImpl();
    	albumPhotoManager.recupererTousLesAlbums();
        System.out.println( "Hello World!" );
    }
}
