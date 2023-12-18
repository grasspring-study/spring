package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //localhost:8080 으로 들어가면 호출됨
    public String home(){
        return "home"; //home.html이 호출됨
    }
}