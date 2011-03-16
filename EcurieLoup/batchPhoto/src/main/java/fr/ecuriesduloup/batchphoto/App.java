package fr.ecuriesduloup.batchphoto;

import service.photo.MediaManager;
import service.photo.MediaManagerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MediaManager mediaManager = new MediaManagerImpl();
    	mediaManager.recupererTousLesAlbums();
        System.out.println( "Hello World!" );
    }
}
