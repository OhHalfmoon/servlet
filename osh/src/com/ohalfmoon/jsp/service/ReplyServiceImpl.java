package com.ohalfmoon.jsp.service;

import java.util.List;

import javax.swing.event.ListSelectionListener;

import com.ohalfmoon.jsp.dao.ReplyDao;
import com.ohalfmoon.jsp.domain.Reply;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDao dao = new ReplyDao();
	// CRUD
	@Override
	public Long register(Reply reply) {
		// TODO Auto-generated method stub
		return(long)dao.insert(reply);
	}
	
	@Override
	public List<Reply> list(Long bno) {
		// TODO Auto-generated method stub
		return dao.selectList(bno);
	}
	
	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stu
		return dao.deleteRP(rno);
		
	}

	@Override
	public Reply get(Long rno) {
		
		return dao.selectOne(rno);
	}
	
//	public Reply get(Long rno) {
//		retrun dao.ListSelectionListener(rno);
//	}
	
	
}
