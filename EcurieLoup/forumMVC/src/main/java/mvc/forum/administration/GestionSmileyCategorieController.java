package mvc.forum.administration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.smiley.SmileyManager;
import donnees.smiley.CategorieSmiley;
@Controller
public class GestionSmileyCategorieController{
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;


	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}



	@RequestMapping("/forum/administration/gestionCategorieSmiley.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		this.gestionOrdrePage(request);
		this.gestionSuppressionCategorieSmiley(request);

		List<CategorieSmiley> categoriesSmiley = this.smileyManager.recupererToutesLesCategoriesSmiley();

		Map<String, Object>model = new HashMap<String, Object>();

		model.put("listeCategoriesSmiley", categoriesSmiley);

		return new ModelAndView("forum/administration/gestionCategorieSmiley", model);
	}

	private void gestionOrdrePage(HttpServletRequest request){
		String up = request.getParameter("up");
		String down = request.getParameter("down");
		if(up != null){
			int numCategorie = Integer.parseInt(up);

			CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(numCategorie);


			this.smileyManager.modifierOrdre(categorieSmiley, categorieSmiley.getOrdre()-1);

		}else if(down != null){
			int numCategorie = Integer.parseInt(down);

			CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(numCategorie);


			this.smileyManager.modifierOrdre(categorieSmiley, categorieSmiley.getOrdre()+1);
		}
	}

	private void gestionSuppressionCategorieSmiley(HttpServletRequest request){
		String delete = request.getParameter("delete");
		if(delete != null){
			int numCategorie = Integer.parseInt(delete);

			CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(numCategorie);

			this.smileyManager.supprimerCategorieSmiley(categorieSmiley);

		}
	}
}
