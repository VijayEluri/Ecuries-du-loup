package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectionController{

	@RequestMapping("/login.do")
	public String handleRequest() throws Exception {
		return "/login";
	}

}
