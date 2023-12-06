package totom.project.vetlabongelion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String handleIndexView(){
        return "index";
    }
    @GetMapping("/login")
    public String handleLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String handlePostLogin() {
        return "login";
    }
}
