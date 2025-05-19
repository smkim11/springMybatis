package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member paramMember);
	List<Member> memberList(Member member);
	String selectId(String memberId);
	String selectPw(String memberPw);
	void insertId(Member member);
	void updateRole(Member member);
	void updatePw(Member member);
	int changeMemberPw(Member member);
}
