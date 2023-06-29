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


@WebServlet("/member/contract")
public class Contract extends HttpServlet{
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/contract.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}