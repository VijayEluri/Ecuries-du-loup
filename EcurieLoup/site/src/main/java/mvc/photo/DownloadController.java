package mvc.photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {

	@RequestMapping(value="/albumPhoto/download.do", method=RequestMethod.GET)
	public ModelAndView downloadMedia(HttpServletRequest request, HttpServletResponse response,@RequestParam("idMedia") long idMedia){


		String fileLocation = request.getSession(true).getServletContext().getRealPath("/images/albumPhoto/"+idMedia);
		File file =new File(fileLocation);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition","attachment; filename=\"" + idMedia +"\"");
		response.setContentLength((int)file.length());
		try{
			InputStream is = new FileInputStream(file);
			byte[] mediaInByte = IOUtils.toByteArray(is);

			FileCopyUtils.copy(mediaInByte, response.getOutputStream());
		}catch (IOException e) {

			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}



		return null;
	}
}
