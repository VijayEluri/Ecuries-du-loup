package sauvegarde.smiley.donnees;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;

public class SauvegardeSmiley {
	private long identifiant;
	private byte[] fichier;

	public long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}

	public byte[] getFichier() {
		return fichier;
	}

	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = this.converteFichierEnByte(fichier);
	}

	private byte[] converteFichierEnByte(File fichier) {
		byte[] bytes = new byte[(int) fichier.length()];
		try {
			FileInputStream is = new FileInputStream(fichier);
			// Create the byte array to hold the data

			// Read in the bytes
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) { // is
																							// is
																							// the
																							// fileinputstream
				offset += numRead;
			}
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	@SuppressWarnings("unused")
	private void setBlob(Blob imageBlob) {
		this.fichier = toByteArray(imageBlob);
	}

	@SuppressWarnings("unused")
	private Blob getBlob() {
		return Hibernate.createBlob(this.fichier);
	}

	private byte[] toByteArray(Blob fromImageBlob) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			return toByteArrayImpl(fromImageBlob, baos);
		} catch (Exception e) {
		}
		return null;
	}

	private byte[] toByteArrayImpl(Blob fromImageBlob,
			ByteArrayOutputStream baos) throws SQLException, IOException {
		byte buf[] = new byte[4000];
		int dataSize;
		InputStream is = fromImageBlob.getBinaryStream();

		try {
			while ((dataSize = is.read(buf)) != -1) {
				baos.write(buf, 0, dataSize);
			}
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return baos.toByteArray();
	}

}
