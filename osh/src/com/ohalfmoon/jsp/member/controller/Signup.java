package com.ohalfmoon.jsp.member.controller;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohalfmoon.jsp.dao.MemberDao;
import com.ohalfmoon.jsp.domain.Member;
import com.ohalfmoon.jsp.service.MemberService;
import com.ohalfmoon.jsp.service.MemberServiceImpl;


@WebServlet("/member/signup")
public class Signup extends HttpServlet{
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id =req.getParameter("id");
		String pw =req.getParameter("pw");
		String pw2 =req.getParameter("pw2");
		String name =req.getParameter("name");
//				System.out.println(pw);
		String msg = "";
		String redirectStr = req.getContextPath();
		String href = req.getParameter("href");
		MemberDao dao = new MemberDao();	
		Member member = new Member(id, pw, name);	
		memberService.register(member);
		redirectStr += "/member/signin?msg="+msg;
		
		resp.sendRedirect(redirectStr);		
		
	}
}