package mvc.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.page.PageManager;
import donnees.page.Page;

@org.springframework.stereotype.Controller
public class AffichageAdministrationPageController {
    @Autowired
    @Qualifier("pageManager")
    private PageManager pageManager;

    public void setPageManager(PageManager pageManager) {
	this.pageManager = pageManager;
    }

    @RequestMapping("/page/administrationPages.do")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	Map<String, Object> model = new HashMap<String, Object>();
	try {
	    this.gestionPageVisible(request);
	    this.gestionOrdrePage(request);
	    this.gestionSuppressionPage(request);

	    List<Page> pagesList = this.pageManager.getAll();

	    model.put("listePages", pagesList);
	    model.put("headPageTitle", "administration des pages");

	    return new ModelAndView("page/affichageAdministrationPage", model);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    private void gestionPageVisible(HttpServletRequest request) {
	String visible = request.getParameter("visible");
	if (visible != null) {
	    int numPage = Integer.parseInt(visible);

	    Page page = this.pageManager.getById(numPage);

	    page.setVisible(!page.isVisible());

	    this.pageManager.update(page);

	}
    }

    private void gestionOrdrePage(HttpServletRequest request) {

	String up = request.getParameter("up");
	String down = request.getParameter("down");
	if (up != null) {
	    int numPage = Integer.parseInt(up);

	    Page page = this.pageManager.getById(numPage);

	    this.pageManager.changeOrdre(page, page.getOrdre() - 1);

	} else if (down != null) {
	    int numPage = Integer.parseInt(down);

	    Page page = this.pageManager.getById(numPage);

	    this.pageManager.changeOrdre(page, page.getOrdre() + 1);
	}

    }

    private void gestionSuppressionPage(HttpServletRequest request) {
	String delete = request.getParameter("delete");
	if (delete != null) {
	    int numPage = Integer.parseInt(delete);

	    Page page = this.pageManager.getById(numPage);

	    this.pageManager.delete(page);

	}
    }
}
