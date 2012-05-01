package fr.ecuriesduloup.ws.horsecard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fiche_chevaux.donnees.Category;
import fiche_chevaux.service.FicheChevauxManager;
@Service
public class CategorysService {
	@Autowired
	private FicheChevauxManager ficheChevauxManager;
	
	public List<Category> getAll(){
		List<Category> categorys = this.ficheChevauxManager.getAllCategorys();
		return categorys;
	}
	
	public Category get(long id){
		Category category = this.ficheChevauxManager.getCategory(id);
		return category;
	}
	
	public void delete(long id){
		this.ficheChevauxManager.deleteCategory(id);
	}
	public Category create(Category category){
		this.ficheChevauxManager.createCategory(category);
		return this.get(category.getId());
	}
}
