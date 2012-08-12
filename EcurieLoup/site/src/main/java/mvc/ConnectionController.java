package mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConnectionController {

    @RequestMapping("/login.do")
    public ModelAndView handleRequest(HttpServletRequest request) throws Exception {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("headPageTitle", "Connection");
	model.put("headPageDescription", "Connectez vous pour accèder aux fonctionnalités des membres.");
	return new ModelAndView("/login", model);
    }

}
