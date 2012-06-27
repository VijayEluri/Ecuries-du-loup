package mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToolsController {

    @RequestMapping("/tools/**/*.do")
    public String handleRequest(HttpServletRequest request) throws Exception {
	String view = request.getServletPath().replace(".do", "");
	return view;
    }
}
