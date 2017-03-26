package step12SpringMVCHelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCHelloWorldController {
    @RequestMapping(value="/HelloWorld")
    public ModelAndView helloWorld() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World");
        modelAndView.setViewName("HelloWorld");
        return modelAndView;
    }
}
