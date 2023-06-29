package com.ohalfmoon.jsp.service;

import com.ohalfmoon.jsp.domain.Member;

public interface MemberService {
	// 회원가입
	void register(Member member);
	// 로그인
	int login(String id, String pw);
	
	// 회원 단일 조회
	Member get(String id);
	
	// 회원목록 조회 (안해도 됌)
	
	// 회원 정보 수정
	
	// 탈퇴

}
