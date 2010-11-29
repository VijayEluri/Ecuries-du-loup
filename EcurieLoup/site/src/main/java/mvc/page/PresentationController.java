package mvc.page;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.page.PageManager;
import donnees.page.Page;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
@Controller
public class PresentationController{
	@Autowired
	@Qualifier("pageManager")
	private PageManager pageManager;
	@Autowired
	private EdlCode edlCode;

	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}

	public void setPageManager(PageManager pageManager) {
		this.pageManager = pageManager;
	}
	
	@RequestMapping("/presentation.do")
	public ModelAndView showPage(@RequestParam("page") int idPage, HttpServletRequest request){
		Page pageRecuperer = this.pageManager.getById(idPage);

		Map<String, Object> renvoyer = new HashMap<String, Object>();

		String contenu = pageRecuperer.getContenu();
		String pathServeur = request.getContextPath();
		try {
			contenu = this.edlCode.parse(contenu, pathServeur);
		} catch (EdlCodeEncodageException e) {
			e.printStackTrace();
		}
		renvoyer.put("contenuPage", contenu);

		return new ModelAndView("/page/presentation", renvoyer);
	}
}
