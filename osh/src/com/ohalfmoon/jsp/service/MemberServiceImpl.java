package com.ohalfmoon.jsp.service;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpSession;

import com.ohalfmoon.jsp.dao.MemberDao;
import com.ohalfmoon.jsp.domain.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = new MemberDao();
	@Override
	public void register(Member member) {
		memberDao.insert(member);	
	}

	@Override
	public int login(String id, String pw) {
		Member member = memberDao.selectOne(id);
//		System.out.println(member);
		if(member == null) {
			return 2;
		}
		else if(!member.getPw().equals(pw)) {
			return 3;
		}
		else {
			return 1;
		}

	}

	@Override
	public Member get(String id) {
		return memberDao.selectOne(id);
	}
	
//	 public void 탈퇴 (String id) {
		 //작성한 게시글 아이디 변경
		 // 작성한 댓글 아이디 변경
		 // 회원 테이블 내에서 삭제
//	 }
}






