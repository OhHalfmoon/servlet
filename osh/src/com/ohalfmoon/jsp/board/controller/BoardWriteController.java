package com.ohalfmoon.jsp.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohalfmoon.jsp.domain.Board;
import com.ohalfmoon.jsp.service.BoardService;
import com.ohalfmoon.jsp.service.BoardServiceImpl;
import com.ohalfmoon.jsp.util.ParamSolver;

import static com.ohalfmoon.jsp.util.ParamSolver.*;
@MultipartConfig(location = "c:\\upload", fileSizeThreshold = 8 * 1024)
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(req.getSession().getAttribute("member") == null) {
//			resp.sendRedirect(req.getContextPath()+"/member/login");
		
		if(!isLogin(req)) {
			resp.sendRedirect(req.getContextPath()+"/member/signin?href=" + URLEncoder.encode(req.getRequestURI(), "utf-8"));
			return;
		}		
		req.getRequestDispatcher("/WEB-INF/jsp/board/write.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Board board = new Board(req.getParameter("title"), req.getParameter("content"), req.getParameter("writer"));		
		if(!isLogin(req)) {
			resp.sendRedirect(req.getContextPath()+"/member/signin?href=" + URLEncoder.encode(req.getRequestURI(), "utf-8"));
			return;			
		//	resp.sendRedirect("list");
		}
		Board board =getParams(req, Board.class);
		System.out.println(board);
		boardService.register(board);
		resp.sendRedirect("list");
	}
	
}
