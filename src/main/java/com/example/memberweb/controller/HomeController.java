package com.example.memberweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //index.html이 디폴트지만, 스프링부트가 실행되면 스프링컨테이너를 먼저 뒤지기 때문에. home을 찾으면 home을 열고, 아무것도 없는 경우에 index.html이 나온다.
    //localhost:8080/
    @GetMapping("/")
    public String home(){
        return "home";
        //resource/templates/home.html 호출
    }
}
