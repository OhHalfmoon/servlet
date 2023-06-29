package com.ohalfmoon.jsp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ohalfmoon.jsp.dao.AttachDao;
import com.ohalfmoon.jsp.dao.BoardDao;
import com.ohalfmoon.jsp.dao.ReplyDao;
import com.ohalfmoon.jsp.domain.Attach;
import com.ohalfmoon.jsp.domain.Board;
import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.domain.Reply;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao dao = new BoardDao();
	private AttachDao attachDao = new AttachDao();
	private ReplyDao replyDao = new ReplyDao();
	
	@Override
	public Long register(Board board) {
		// 글 작성 후 글번호 지정
	       Long bno = (long)dao.insert(board);
	       System.out.println("Boardservice.register() :: " +  bno);
	       
	       for(Attach attach : board.getAttachs()) {
	    	   attach.setBno(bno);
	    	   attachDao.insert(attach);
	       }
	       
	        return bno;
	    }

	@Override
	public Board get(Long bno) {
		dao.increaseHitCount(bno);
		Board board = dao.selectOne(bno);
		board.setAttachs(attachDao.selectList(bno));
		return board;
	}

	@Override
	public List<Board> list(Criteria cri) {
		return dao.selectList(cri);
//		return dao.selectList(cri).stream().map(board -> {
//			board.setAttachs(attachDao.selectList(board.getBno()));
//			return board;
//		}).collect(Collectors.toList());
	}

	@Override
	public void modify(Board board) {
		dao.update(board);		
	}

	@Override
	public void remove(Long bno) {
		// 파일시스템에 존재하는 파일 삭제
		attachDao.selectList(bno).forEach(attach -> {
			attach.getFile().delete();
			if(attach.isImage()) {
				attach.getFile(true).delete();
			}
		});
		// 첨부목록 삭제
		attachDao.delete(bno);
		// 댓글삭제	
		replyDao.delete(bno);
		// tbl_board 삭제	
		dao.delete(bno);		
	}
	// 글이 삭제되면서 댓글이 삭제되어야 함
	

	@Override
	public int listCount(Criteria cri) {
		return dao.selectListCount(cri);
	}	

}
