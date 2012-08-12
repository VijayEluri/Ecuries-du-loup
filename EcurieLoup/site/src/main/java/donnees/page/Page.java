package donnees.page;

import fr.ecurie_du_loup.generique_util.type.DataOrdonner;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Page extends DataWtihLongIdAbstract<Page> implements DataWithLongId, DataOrdonner {
    private String content;
    private String title;
    private String description;
    private int ordre;
    private boolean visible;

    public void setId(long id) {
	this.id = id;
    }

    public String getContent() {
	return this.content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public int getOrdre() {
	return this.ordre;
    }

    @Override
    public void setOrdre(int ordre) {
	this.ordre = ordre;
    }

    public boolean isVisible() {
	return this.visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }
}
