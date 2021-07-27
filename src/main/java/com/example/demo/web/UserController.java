package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // 로그인페이지로 가는컨트롤러
    @GetMapping("/auth/joinPage")
    public String login() {
        return "auth/login";
    }

}
