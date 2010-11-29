package donnees.photo;

public class AlbumLight {
	private long id;
	private String titre;
	
	private byte[] zip;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public byte[] getZip() {
		return zip;
	}

	public void setZip(byte[] zip) {
		this.zip = zip;
	}
	
	
}
