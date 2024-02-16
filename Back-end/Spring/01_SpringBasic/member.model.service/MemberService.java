package com.basic.member.model.service;

import java.util.List;

import com.multi.basic.member.model.vo.Member;

public interface MemberService {
	// 회원가입
	int memberEnroll(Member member);
	
	// 전체 멤버 가져오기
	List<Member> getAllList();
	
	// 로그인 기능
	Member login(String id);
}
