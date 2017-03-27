package step14SpringMVCHelloWorldForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private static final String[] countries = { "Turkey", "United States", "Germany" };

	@RequestMapping(value = "/form")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("userForm", "user", new User());
		modelAndView.addObject("genders", Gender.values());
		modelAndView.addObject("countries", countries);
		return modelAndView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView processUser(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userResult");
		modelAndView.addObject("u", user);
		//
		System.out.println("输出user的信息 开始");
		System.out.printf("user.getName() is \"%s\"\r\n", user.getName());
        System.out.printf("user.getLastname() is \"%s\"\r\n", user.getLastname());
        System.out.printf("user.getPassword() is \"%s\"\r\n", user.getPassword());
        System.out.println("输出user的信息 结束");
		return modelAndView;
	}
}