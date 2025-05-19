package com.example.mbboard.cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.IRootService;
import com.example.mbboard.service.ILoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CookieLoginController {
	@Autowired ILoginService loginService;
	@Autowired IRootService rootService;
	
	@GetMapping("/cookieLogin")
	public String cookieLogin() {
		
		return "/cookie/cookieLogin";
	}
	// 쿠키 로그인
	@PostMapping("/cookieLogin")
	public String cookieLogin(HttpSession session, Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
			// 로그인 성공 정보도 쿠키에 저장
			Cookie loginMemberId = new Cookie("loginMemberId",paramMember.getMemberId());
			response.addCookie(loginMemberId);
			return "redirect:/cookieSuccess";
		}
		return "redirect:/cookieLogin";
	}
	
	@GetMapping("/cookieSuccess")
	public String cookieSuccess(@CookieValue(required=false) String loginMemberId) {
		// 로그인 전이라면 redirect:/cookieLogin
		if(loginMemberId == null || loginMemberId.equals("")) {
			return "redirect:/cookieLogin";
		}
		// 로그인이 되어있다면
		return "cookie/cookieSuccess";
	}
	
	// 로그아웃
	@GetMapping("/cookieLogout")
	public String cookieLogout(HttpServletResponse response) {
		Cookie loginMemberId = new Cookie("loginMemberId","");
		response.addCookie(loginMemberId);
		return "redirect:/cookieLogin";
	}
}
