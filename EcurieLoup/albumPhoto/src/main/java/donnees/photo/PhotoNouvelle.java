package donnees.photo;

public class PhotoNouvelle {
	private long id;
	private String description;
	private byte[] fichier;
	private long album;
	
	private byte[] zip;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public byte[] getFichier() {
		return fichier;
	}
	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}
	public long getAlbum() {
		return album;
	}
	public void setAlbum(long album) {
		this.album = album;
	}
	
	public byte[] getZip() {
		return zip;
	}

	public void setZip(byte[] zip) {
		this.zip = zip;
	}
}
