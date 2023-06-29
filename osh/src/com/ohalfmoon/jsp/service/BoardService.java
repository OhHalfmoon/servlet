package com.ohalfmoon.jsp.service;

import java.util.List;

import com.ohalfmoon.jsp.domain.Board;
import com.ohalfmoon.jsp.domain.Criteria;

public interface BoardService {
	
	//CRUD
	Long register(Board board);
	
	Board get(Long bno);
	
	List<Board> list(Criteria cri);
	int listCount(Criteria cri);
	
	void modify(Board board);
	
	void remove(Long bno);
}
