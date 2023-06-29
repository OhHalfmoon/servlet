package com.ohalfmoon.jsp.board.controller;

import static com.ohalfmoon.jsp.util.ParamSolver.isLogin;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.domain.Member;
import com.ohalfmoon.jsp.service.BoardService;
import com.ohalfmoon.jsp.service.BoardServiceImpl;
import com.ohalfmoon.jsp.util.ParamSolver;

@WebServlet("/board/remove")
public class BoardRemoveController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(!isLogin(req)) {
//			resp.sendRedirect(req.getContextPath()+"/member/login?href=" + URLEncoder.encode(req.getRequestURI(), "utf-8"));
//			return;
//		}		
//		if(isLogin(req) == Member.get) {
			
//		}

		Criteria cri = ParamSolver.getParams(req, Criteria.class);
		boardService.remove(Long.valueOf(req.getParameter("bno")));
		resp.sendRedirect("list" + "?" + cri.getFullQueryString());
		
		// 게시글 삭제 : 종속삭제 (db에서 진행, 구현 x)
		// pk값 삭제 delete by long bno
		// dao에서 메서드 추가로 만들고 (댓글 삭제) 호출해서 선적용 후 게시글 삭제
		
	}
}
