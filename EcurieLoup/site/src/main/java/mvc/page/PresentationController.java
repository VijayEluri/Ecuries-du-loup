package mvc.page;

import java.util.HashMap;
import java.util.Map;

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
public class PresentationController {
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
    public ModelAndView showPage(@RequestParam("page") int pageId) {
	Page page = this.pageManager.getById(pageId);

	Map<String, Object> model = new HashMap<String, Object>();

	String content = page.getContent();
	try {
	    content = this.edlCode.parse(content);
	} catch (EdlCodeEncodageException e) {
	    e.printStackTrace();
	}
	page.setContent(content);
	model.put("headPageTitle", page.getTitle());
	model.put("headPageDescription", page.getDescription());
	model.put("page", page);

	return new ModelAndView("/page/presentation", model);
    }
}
