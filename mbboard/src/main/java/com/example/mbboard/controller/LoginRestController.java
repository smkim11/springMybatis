package com.example.mbboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;

@RestController
public class LoginRestController {
	@Autowired ILoginService loginService;
	
	// 회원가입 아이디 중복검사
	@GetMapping("/idUse/{memberId}")
	public boolean idUse(@PathVariable String memberId) {
		if(loginService.selectId(memberId) != null) {
			return false;
		}
		return true;
	}
}
