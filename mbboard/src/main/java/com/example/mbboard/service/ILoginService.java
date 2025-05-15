package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Member;

public interface ILoginService {
	
	Member login(Member paramMember);
	List<Member> memberList(Member member);
	String selectId(String memberId);
	void insertId(Member member);
	void updateRole(Member member);
	void updatePw(Member member);
	String selectPw(String memberId);
}
