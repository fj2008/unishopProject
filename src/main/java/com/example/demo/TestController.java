package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String home() {
        System.out.println("홈");
        return "testfile/login";
    }

    @GetMapping("/testheader")
    public String header(){
        return "layout/haeder";
    }
}
