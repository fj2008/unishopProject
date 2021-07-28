package com.example.demo.web;

import java.util.Random;

import javax.servlet.http.HttpSession;

import com.example.demo.domian.user.User;
import com.example.demo.domian.user.UserRepository;
import com.example.demo.util.CoolSmsPhoneNumber;
import com.example.demo.util.Script;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRepository userRepository;
    private final HttpSession session;

    // 로그인페이지로 가는컨트롤러
    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "auth/loginForm";
    }

    // 회원가입페이지로 가는 컨트롤러
    @GetMapping("/auth/joinForm")
    public String joinForm(User user) {
        return "auth/joinForm";
    }

    // 회원가입요청이 왔을때 처리받는 컨트롤러
    @PostMapping("/auth/join")
    public String join(User user) {
        System.out.println("나옴?");
        userRepository.save(user);
        System.out.println("안나옴?");
        return "redirect:/auth/loginForm";
    }

    // 주소 api호출 컨트롤러
    @GetMapping("/juso")
    public String jusoRequest() {
        return "juso/jusoPopup";
    }

    // 주소 api에서 데이터 보내는 컨트롤러
    @PostMapping("/juso")
    public String jusoResponse(String roadFullAddr, String inputYn, Model model) {
        System.out.println("주소 : " + roadFullAddr);
        model.addAttribute("roadFullAddr", roadFullAddr);
        model.addAttribute("inputYn", inputYn);
        return "juso/jusoPopup";
    }

    // 로그인 성공시 메인프로덕트 페이지로 보내는 컨트롤러
    @PostMapping("/auth/login")
    public @ResponseBody String login(User user) {
        User userEntity = userRepository.mLogin(user.getUsername(), user.getPassword());
        if (userEntity == null) {
            return Script.back("로그인 실패");
        } else {
            return Script.href("/");
        }
    }

    @GetMapping("/auth/finId")
    public String findId() {
        return "auth/findIdForm";
    }

    @PostMapping("/auth/findIdsms")
    public @ResponseBody String findId(String phoneNumber) {
        Random rand = new Random();
        String numStr = "";
        for (int i = 0; i < 4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        CoolSmsPhoneNumber.certifiedPhoneNumber(phoneNumber, numStr);
        return numStr;
    }

}
