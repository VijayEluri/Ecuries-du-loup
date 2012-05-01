package fr.ecuriesduloup.ws.horsecard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import donnees.photo.commentaire.Commentaire;
import fiche_chevaux.donnees.Category;
import fr.ecuriesduloup.ws.AbstractWsController;
import fr.ecuriesduloup.ws.albumPhoto.comment.CommentDto;
import fr.ecuriesduloup.ws.user.UserService;

@Controller
public class CategorysController extends AbstractWsController{
	@Autowired
	private CategorysService categorysService;
	@Autowired
	private UserService userService;

	

	@RequestMapping(value = "/horsecard/categorys",method=RequestMethod.GET)
	public ModelAndView getAllMediaComments(HttpServletRequest request) {
		List<Category> categorys = this.categorysService.getAll();
		List<CategoryDto> categorysDtos = new ArrayList<CategoryDto>();
		for(Category category : categorys){
			categorysDtos.add(new CategoryDto(category));
		}
		return this.ChooseView(request, "categorys", categorysDtos);
	}
	
	@RequestMapping(value = "/horsecard/categorys/{categoryId}",method=RequestMethod.DELETE)
	public ModelAndView deleteComment(HttpServletRequest request, @PathVariable long categoryId) {
		this.categorysService.delete(categoryId);
		return this.ChooseView(request, "category", "");
	}

	@RequestMapping(value = "/horsecard/categorys/{categoryId}",method=RequestMethod.GET)
	public ModelAndView getComment(HttpServletRequest request, @PathVariable long categoryId) {
		Category category =this.categorysService.get(categoryId);
		return this.ChooseView(request, "category", new CategoryDto(category));
	}

	

	
	@RequestMapping(value = "/horsecard/categorys/{categoryName}",method=RequestMethod.POST)
	public ModelAndView createComment(HttpServletRequest request, @PathVariable String categoryName) {
		Category category = new Category();
		category.setName(categoryName);
		
		Category categorySend = this.categorysService.create(category);
		return this.ChooseView(request, "category", new CategoryDto(categorySend));
	}

	
	
	

}
