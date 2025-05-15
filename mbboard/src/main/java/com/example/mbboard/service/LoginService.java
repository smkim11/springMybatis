package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LoginService implements ILoginService{
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
}
