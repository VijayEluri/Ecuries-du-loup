package fiche_chevaux.donnees;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Category extends DataWtihLongIdAbstract<Category> implements DataWithLongId{
	
	private String name;
	private boolean emptyCategory;
	private long mediaId;
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEmptyCategory() {
		return emptyCategory;
	}

	public void setEmptyCategory(boolean emptyCategory) {
		this.emptyCategory = emptyCategory;
	}

	public long getMediaId() {
		return mediaId;
	}

	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
}
