package util;

import java.io.File;

public interface PhotoUtil {
	public void creerFicherSurDisquePhoto(String emplacement, String nom, File fichier);
	public void creerFicherSurDisqueVideo(String emplacement, String nom, File fichier);
	public void supprimerFicherSurDisque(String emplacement);
	
}
