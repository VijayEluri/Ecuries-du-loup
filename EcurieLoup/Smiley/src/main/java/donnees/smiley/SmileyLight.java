package donnees.smiley;

public class SmileyLight {
	private int id;
	private String code;
	private byte[] image;
	private int categorieSmiley;
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getCategorieSmiley() {
		return categorieSmiley;
	}
	public void setCategorieSmiley(int categorieSmiley) {
		this.categorieSmiley = categorieSmiley;
	}
}
