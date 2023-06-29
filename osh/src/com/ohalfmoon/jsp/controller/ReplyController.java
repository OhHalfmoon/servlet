package com.ohalfmoon.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ohalfmoon.jsp.domain.Reply;
import com.ohalfmoon.jsp.service.ReplyService;
import com.ohalfmoon.jsp.service.ReplyServiceImpl;
import com.ohalfmoon.jsp.util.ParamSolver;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private ReplyService service = new ReplyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.valueOf(req.getParameter("bno"));
		List<Reply> replies = service.list(bno);
//		System.out.println(replies);
		Gson gson = new Gson();
		String json = gson.toJson(replies);
//		System.out.println(json);
		resp.setContentType("application/json; charset=utf8");
		resp.getWriter().print(json);
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("rno"));
//		System.out.println("doDelete()");
//		로그인 여부
//		동일 계정 여부
//		ParamSolver.isMine(req, getServletInfo())
		Long rno = Long.valueOf(req.getParameter("rno"));
		PrintWriter out = resp.getWriter();
		Reply reply = service.get(rno);
		
		if(reply != null && ParamSolver.isMine(req, service.get(rno).getWriter())) {
			out.print(service.remove(rno));
		}
		else {
			out.print(0);
		}
//		service.remove(Long.valueOf(req.getParameter("rno")));
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = ParamSolver.getParams(req,Reply.class);
//		System.out.println(reply);
//		System.out.println("doPost()");
		service.register(reply);
		
	}
	
}
