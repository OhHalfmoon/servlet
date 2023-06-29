package com.ohalfmoon.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.service.BoardService;
import com.ohalfmoon.jsp.service.BoardServiceImpl;
import com.ohalfmoon.jsp.util.ParamSolver;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = ParamSolver.getParams(req, Criteria.class);
		req.setAttribute("cri", cri);
		req.setAttribute("board", boardService.get(Long.valueOf(req.getParameter("bno"))));
		req.getRequestDispatcher("/WEB-INF/jsp/board/view.jsp").forward(req, resp);
	}

}
