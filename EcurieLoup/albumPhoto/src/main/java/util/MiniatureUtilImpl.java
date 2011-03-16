package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MiniatureUtilImpl implements MiniatureUtil {

	@Override
	public void creerMiniaturesPhoto(String fichierPhotoOriginal, String emplacementMiniature, int dimentionMaximal){
		try {

			// Get the image from a file.
			Image inImage = new ImageIcon(fichierPhotoOriginal).getImage();

			// Determine the scale.
			double scale = (double)dimentionMaximal/(double)inImage.getHeight(null);
			if (inImage.getWidth(null) > inImage.getHeight(null)) {
				scale = (double)dimentionMaximal/(double)inImage.getWidth(null);
			}

			// Determine size of new image. 
			//One of them
			// should equal maxDim.
			int scaledW = (int)(scale*inImage.getWidth(null));
			int scaledH = (int)(scale*inImage.getHeight(null));

			// Create an image buffer in 
			//which to paint on.
			BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);

			// Set the scale.
			AffineTransform tx = new AffineTransform();
			// If the image is smaller than 
			//the desired image size,
			// don't bother scaling.
			if (scale < 1.0d) {
				tx.scale(scale, scale);
			}
			// Paint image.
			Graphics2D g2d = outImage.createGraphics();
			g2d.drawImage(inImage, tx, null);
			g2d.dispose();
			// JPEG-encode the image 
			//and write to file.
			OutputStream os = new FileOutputStream(emplacementMiniature);
			ImageIO.write(outImage,"jpg", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void creerMiniaturesVideo(String pathVideoFile,
			String outPicturePicturePath) {
		String command = "ffmpeg ";
		command += "-y -i ";
		command += pathVideoFile;
		command += " ";
		command += outPicturePicturePath+".jpg";

		
		String commandMove = "mv ";
		commandMove += " ";
		commandMove +=  outPicturePicturePath+".jpg";
		commandMove += " ";
		commandMove += outPicturePicturePath;
		try{

			
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(command);
			p.waitFor();
			
			
			Process p1 = r.exec(commandMove);
			p1.waitFor();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
