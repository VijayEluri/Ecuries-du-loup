package util;

public interface MiniatureUtil {
	/**
	 * Reads an image in a file and creates 
	 * a thumbnail in another file.
	 * @param fichierPhotoOriginal The name of image file.
	 * @param emplacementMiniature The name of thumbnail file. Will be created if necessary.
	 * @param dimentionMaximal The width and height of the thumbnail must be maxDim pixels or less.
	 */
	public void creerMiniaturesPhoto(String fichierPhotoOriginal, String emplacementMiniature, int dimentionMaximal);
}
