package step16FileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileUploadController {

	@RequestMapping("/form")
	public ModelAndView getFileUploadForm() {
	    System.out.println("FileUploadController ModelAndView getFileUploadForm()");
		return new ModelAndView("fileUpload", "user", new User());
	}

	@RequestMapping(value = "/upload")
	public ModelAndView processUser(User user, HttpServletRequest request) throws IOException {
		System.out.printf("real path is %s\r\n", request.getSession().getServletContext().getRealPath(""));
	    ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("fileUpload");
	    FileOutputStream fileOutputStream = new FileOutputStream(new File(request.getSession().getServletContext().getRealPath("") + "/" + user.getFile().getOriginalFilename()));
	    fileOutputStream.write(user.getFile().getBytes());
	    fileOutputStream.flush();
	    fileOutputStream.close();
		modelAndView.addObject("userName", user.getName().length() == 0 ? user.getFile().getOriginalFilename() : user.getName());
		modelAndView.addObject("fileLength", user.getFile().getBytes().length);
		System.out.println("FileUploadController ModelAndView processUser(User user)");
		return modelAndView;
	}
}
