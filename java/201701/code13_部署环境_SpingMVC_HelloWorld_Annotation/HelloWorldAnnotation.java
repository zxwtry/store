package step13SpringMVCHelloWorldAnnotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldAnnotation {
    @RequestMapping(value="/HelloWorld")
    public ModelAndView helloWorld() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World");
        modelAndView.setViewName("HelloWorld");
        System.out.println("now in HelloWorldAnnotation ModelAndView helloWorld()");
        return modelAndView;
    }
}
