package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class PhotoUtilImpl implements PhotoUtil {
	private MiniatureUtil miniatureUtil;


	public void setMiniatureUtil(MiniatureUtil miniatureUtil) {
		this.miniatureUtil = miniatureUtil;
	}

	@Override
	public void creerFicherSurDisquePhoto(String emplacement, String nom, File fichier) {
		File ancienFichier = new File(emplacement+nom);
		if(ancienFichier.exists()){
			ancienFichier.delete();

		}
		this.copierFichier(fichier.getAbsolutePath(),  emplacement+nom);
		this.miniatureUtil.creerMiniaturesPhoto(emplacement+nom, emplacement+"/view/"+nom, 500);
		this.miniatureUtil.creerMiniaturesPhoto(emplacement+nom, emplacement+"/miniatures/"+nom, 100);

	}

	@Override
	public void creerFicherSurDisqueVideo(String emplacement, String nom, File fichier) {
		File ancienFichier = new File(emplacement+nom);
		if(ancienFichier.exists()){
			ancienFichier.delete();

		}
		this.copierFichier(fichier.getAbsolutePath(),  emplacement+nom);
		
		this.miniatureUtil.creerMiniaturesVideo(emplacement+nom, emplacement+"/miniatures/"+nom.replace(".ogv", ""));

		this.createMP4File(emplacement+nom);


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

	private void createMP4File(String ogvFile){
		String command = "ffmpeg -i %s -acodec aac -strict experimental -ac 2 -ab 160k -vcodec libx264 -vpre slow -f mp4 -crf 22 %s";
		String mp4FilePath = ogvFile.replace(".ogv", ".mp4");
		String execCommand = String.format(command, ogvFile, mp4FilePath);

		try{
			Runtime r = Runtime.getRuntime();
			r.exec(execCommand);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerFicherSurDisque(String emplacement) {
		File photoFichier = new File(emplacement);
		photoFichier.delete();

	}

}
