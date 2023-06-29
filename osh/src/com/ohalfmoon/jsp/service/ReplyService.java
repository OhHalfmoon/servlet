package com.ohalfmoon.jsp.service;

import java.util.List;

import com.ohalfmoon.jsp.domain.Reply;

public interface ReplyService {

	// CRUD
	Long register(Reply reply);
	
	List<Reply> list(Long bno);
	
	int remove(Long rno);
	
	Reply get(Long rno);
}
