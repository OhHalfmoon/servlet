package com.ohalfmoon.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.domain.PageDto;
import com.ohalfmoon.jsp.service.BoardService;
import com.ohalfmoon.jsp.service.BoardServiceImpl;
import com.ohalfmoon.jsp.util.ParamSolver;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria criteria = ParamSolver.getParams(req, Criteria.class);
//		System.out.println(criteria);
		req.setAttribute("boards", boardService.list(criteria));
		req.setAttribute("page", new PageDto(boardService.listCount(criteria), criteria));

		req.getRequestDispatcher("/WEB-INF/jsp/board/list.jsp").forward(req, resp);
	}
}