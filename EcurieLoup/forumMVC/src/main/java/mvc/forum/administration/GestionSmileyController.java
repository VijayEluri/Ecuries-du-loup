package mvc.forum.administration;

import java.util.HashMap;
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
import donnees.smiley.Smiley;

@Controller
public class GestionSmileyController {
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;


	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}


	@RequestMapping("/forum/administration/gestionSmiley.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			this.gestionOrdreSmiley(request);
			this.gestionSuppressionSmiley(request);

			String stringCategorie = request.getParameter("categorie");
			long idCategorie = Long.parseLong(stringCategorie);
			CategorieSmiley categorie = this.smileyManager.recupererCategorieSmiley(idCategorie);


			Map<String, Object> model = new HashMap<String, Object>();
			model.put("categorie", categorie);

			return new ModelAndView("forum/administration/gestionSmiley", model);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void gestionOrdreSmiley(HttpServletRequest request){
		String up = request.getParameter("up");
		String down = request.getParameter("down");
		if(up != null){
			long numSmiley = Long.parseLong(up);

			Smiley smiley = this.smileyManager.recupererSmiley(numSmiley);


			this.smileyManager.modifierOrdre(smiley, smiley.getOrdre()-1);

		}else if(down != null){
			long numSmiley = Long.parseLong(down);

			Smiley smiley = this.smileyManager.recupererSmiley(numSmiley);


			this.smileyManager.modifierOrdre(smiley, smiley.getOrdre()+1);
		}
	}

	private void gestionSuppressionSmiley(HttpServletRequest request){
		String delete = request.getParameter("delete");
		if(delete != null){
			long numSmiley = Long.parseLong(delete);

			Smiley smiley = this.smileyManager.recupererSmiley(numSmiley);
			this.smileyManager.supprimerSmiley(smiley);

		}
	}
}
