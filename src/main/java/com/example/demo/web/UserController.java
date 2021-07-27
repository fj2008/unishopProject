package com.example.demo.web;

import javax.servlet.http.HttpSession;

import com.example.demo.domian.user.User;
import com.example.demo.domian.user.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    //회원가입페이지로 가는 컨트롤러
    @GetMapping("/auth/joinForm")
    public String joinForm(User user){
        return "auth/joinForm";
    }

    //회원가입요청이 왔을때 처리받는 컨트롤러
    @PostMapping("/auth/join")
	public String join(User user) {
		userRepository.save(user);
		return"redirect:/auth/loginForm";
	}

    //주소 api호출 컨트롤러
        @GetMapping("/juso")
        public String jusoRequest() {
            return "juso/jusoPopup";
        }
    //주소 api에서 데이터 보내는 컨트롤러
		@PostMapping("/juso")
		public String jusoResponse(String roadFullAddr, String inputYn, Model model) {
			System.out.println("주소 : "+ roadFullAddr);
			model.addAttribute("roadFullAddr",roadFullAddr);
			model.addAttribute("inputYn",inputYn);
			return   "juso/jusoPopup";
		}
		

        
}
