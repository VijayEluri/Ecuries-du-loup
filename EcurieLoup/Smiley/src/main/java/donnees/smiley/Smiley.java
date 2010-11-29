package donnees.smiley;

import fr.ecurie_du_loup.generique_util.type.DataOrdonner;

public class Smiley implements DataOrdonner{
	private long id;
	private String code;
	private CategorieSmiley categorieSmiley;
	private int ordre;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public CategorieSmiley getCategorieSmiley() {
		return categorieSmiley;
	}
	public void setCategorieSmiley(CategorieSmiley categorieSmiley) {
		this.categorieSmiley = categorieSmiley;
	}
	@Override
	public int getOrdre() {
		return ordre;
	}
	@Override
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Smiley)){
			return false;
		}
		Smiley smiley = (Smiley) obj;
		return smiley.id == this.id;
	}
	
}
