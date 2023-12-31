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


@WebServlet("/member/signin")
public class Login extends HttpServlet{
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id =req.getParameter("id");
		String pw =req.getParameter("pw");
//		System.out.println(pw);
		String msg = "";
		String redirectStr = req.getContextPath() + "/";
		String href = req.getParameter("href");
		//System.out.println(id);
		//System.out.println(memberService.login(id, pw));
		switch(memberService.login(id, pw)) {
		case 1:
			req.getSession().setAttribute("member", memberService.get(id));
			
			if(href != null) {
				redirectStr = href;
			}
			//resp.sendRedirect(req.getContextPath());
			break;
		case 2: 
			msg = "아이디가 없습니다";
			msg = URLEncoder.encode(msg, "utf-8");
			//resp.sendRedirect(req.getContextPath()+"/member/login?msg="+msg);
			redirectStr += "member/signin?msg="+msg;
			if(href != null) {
				redirectStr += "&href=" + URLEncoder.encode(href,"utf-8");
			}
			break;
		case 3:	
			msg = "비밀번호가 일치하지 않습니다";
			msg = URLEncoder.encode(msg, "utf-8");
			//resp.sendRedirect(req.getContextPath()+"/member/login?msg="+msg);
			redirectStr += "member/signin?msg="+msg;
			if(href != null) {
				redirectStr += "&href=" + URLEncoder.encode(href,"utf-8");
			}
		}
		resp.sendRedirect(redirectStr);
	
	}
}