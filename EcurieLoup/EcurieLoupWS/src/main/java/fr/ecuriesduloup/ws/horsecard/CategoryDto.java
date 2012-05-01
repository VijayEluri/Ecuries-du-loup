package fr.ecuriesduloup.ws.horsecard;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fiche_chevaux.donnees.Category;

@XStreamAlias("Category")
public class CategoryDto {
	private long id;
	private String name;

	public CategoryDto(Category category){
		this.setId(category.getId());
		this.setName(category.getName());
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
