package step17ExceptionController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private Map<String, User> users = new HashMap<String, User>();
    
    @PostConstruct
    public void setup() {
        users.put("bear", new User("Bear", "BearLastName")); 
        users.put("goat", new User("Goat", "GoatLastName")); 
        users.put("horse", new User("Horse", "HorseLastName")); 
    }
    
    @RequestMapping(value="/form")
    public ModelAndView form() {
        return new ModelAndView("userForm", "user", new User());
    }
    
    @RequestMapping(value="/result")
    public ModelAndView result(String name) throws Exception {
        if (name.equals("gtq")) throw new RuntimeException("aabb");
        User user = users.get(name);
        if (user == null) throw new UserNotFoundException(name);
        return new ModelAndView("userResult", "u", user);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handlerException(UserNotFoundException e) {
        return new ModelAndView("errorUser", "errorMessage", e.getMessage());
    }
    
}
