package fr.ecuriesduloup.save.photo.data;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class PhotoBackup extends DataWtihLongIdAbstract<PhotoBackup> implements DataWithLongId{
	private byte[] file;

	public void setId(long id) {
		this.id = id;
	}


	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public void setFile(File fichier) {
		this.file = this.converteToByte(fichier);
	}

	private byte[] converteToByte(File file) {
		byte[] bytes = new byte[(int) file.length()];
		try {
			FileInputStream is = new FileInputStream(file);
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
		this.file = toByteArray(imageBlob);
	}

	@SuppressWarnings("unused")
	private Blob getBlob() {
		return Hibernate.createBlob(this.file);
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
