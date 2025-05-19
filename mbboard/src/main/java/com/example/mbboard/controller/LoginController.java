package com.example.mbboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class LoginController {
	@Autowired ILoginService loginService;
	@Autowired IRootService rootService;
	
	// 비밀번호 찾기
	@GetMapping("/findMemberPw")
	public String findMemberPw() {
		return "findMemberPw";
	}
	
	@PostMapping("/findMemberPw")
	public String findMemberPw(Member member) {
		// 비밀번호 변경 
		loginService.changeMemberPw(member);
		// 분실 비밀번호 변경 페이지로 이동
		return "rechangeMemberPw";
	}
	
	// 임시 비밀번호 변경
	@PostMapping("/rechangeMemberPw")
	public String rechangeMemberPw(Member member) {
		loginService.reChangeMemberPw(member);
		return "redirect:/login";
	}
	// 로그인
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	// 세션 로그인
	@PostMapping("/login")
	public String login(HttpSession session, Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		if(loginMember != null) {
				
				log.info(paramMember.toString());
			
				// 쿠키에도 로그인에 성공하면 아이디만 저장(saveIdCk값이 있을때만)
				if(paramMember.getSaveIdCk() != null) {
					Cookie c = new Cookie("saveId", paramMember.getMemberId());
					response.addCookie(c);
				}else { // 아이디 저장 안하면 쿠키 삭제
					Cookie c = new Cookie("saveId", "");
					response.addCookie(c);
				}
			
				session.setAttribute("loginMember", loginMember);
				
				// 멤버(ADMIN, MEMBER) 카운트 +1
				ConnectCount cc = new ConnectCount();
				cc.setMemberRole(loginMember.getMemberRole());
				if(rootService.selectConnectDateBykey(cc) ==null) {
					rootService.insertConnectCount(cc); // 오늘날짜에 loginMember.getMemberRole()로 1행 추가
				}else {
					rootService.updateConnectCount(cc); // 오늘날짜에 loginMember.getMemberRole()의 카운트 +1
				}
				
				return "redirect:/admin/adminHome";
		}else {
			return "redirect:/login";
		}
		
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Member member) {
		loginService.insertId(member);
		return "redirect:/login";
	}
	
	// 세션안의 상세정보를 보여주는 요청 (로그인 상태에서 요청가능 -> 필터1)
	@GetMapping("/member/info") 
	public String info() {
		
		return "/member/info";
	}
	
	// 관리자 페이지 요청 (로그인 상태이고 role이 ADMIN이면 요청가능 -> 필터2)
	@GetMapping("/admin/adminHome")
	public String adminHome(Model model, Member member) {
		model.addAttribute("list", loginService.memberList(member));
		return "/admin/adminHome";
	}
	
	// 멤버 페이지
	@GetMapping("/member/memberHome")
	public String memberHome() {
		return "/member/memberHome";
	}
	
	// 역할수정
	@GetMapping("/updateRole")
	public String updateRole(Member member) {
		loginService.updateRole(member);
		return "redirect:/admin/adminHome";
	}
	
	// 비밀번호 수정
	@GetMapping("/updatePw")
	public String updatePw() {
		
		return "updatePw";
	}
	
	@PostMapping("/updatePw")
	public String updatePw(Member member, @RequestParam String prevPw) {
		if(prevPw.equals(loginService.selectPw(member.getMemberId()))) {
			loginService.updatePw(member);
			return "redirect:/logout";
		}else {
			return "redirect:/updatePw";
		}
	}
	
}
