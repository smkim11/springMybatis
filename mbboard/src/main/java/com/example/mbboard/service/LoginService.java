package com.example.mbboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LoginService implements ILoginService{
	@Autowired JavaMailSender javaMailSender;
	@Autowired LoginMapper loginMapper;
	
	// 로그인
	@Override
	public Member login(Member paramMember) {
		return loginMapper.login(paramMember);
	}
	
	// 멤버리스트 출력
	@Override
	public List<Member> memberList(Member member){
		return loginMapper.memberList(member);
	}
	
	// 아이디 중복 체크
	@Override
	public String selectId(String memberId){
		return loginMapper.selectId(memberId);
	}
	
	// 아이디에 맞는 비밀번호
	@Override
	public String selectPw(String memberId) {
		return loginMapper.selectPw(memberId);
	}
	// 회원가입
	@Override
	public void insertId(Member member) {
		loginMapper.insertId(member);
	}
	
	// 역할 수정
	@Override
	public void updateRole(Member member) {
		loginMapper.updateRole(member);
		
	}
	
	// 비밀번호 수정
	@Override
	public void updatePw(Member member) {
		loginMapper.updatePw(member);
		
	}
	
	// 분실한 비밀번호의 임시 비밀번호
	@Override
	public void changeMemberPw(Member member) {
		// 새로운 임시 패스워드를 생성
		String randomPw = UUID.randomUUID().toString().replace("-", "").substring(0,8);
		member.setMemberPw(randomPw);
		int row = loginMapper.changeMemberPw(member);
		if(row == 1) {
			// 메일로 변경된 비밀번호를 보낸다.
			log.info("변경된 비밀번호: " + randomPw);
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("변경된 비밀번호 입니다");
			msg.setText("변경된 비밀번호: "+member.getMemberPw());
			msg.setText("10분안에 로그인하여 수정하셔야 합니다");
			
			javaMailSender.send(msg);
		}
		
	}
}
