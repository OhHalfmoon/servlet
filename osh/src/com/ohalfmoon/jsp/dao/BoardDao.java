package com.ohalfmoon.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ohalfmoon.jsp.domain.Board;
import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.util.DBConn;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Long insert(Board board) {
		conn = DBConn.getConnection();
		long result = 0;
		// 처리할 sql 구문
		String sql = "insert into tbl_board (title, content, writer) values (?, ?, ?)";
//		System.out.println(sql);
		try {
			// 문장 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			// 문장 처리
			result = pstmt.executeUpdate();
			close();
			// 쿼리 재실행
			// 작성한 게시글의 글번호 조회
			sql = "select max(bno) from tbl_board";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); //커서이동
			result = rs.getLong(1); //1번 컬럼 long반환
			close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
	public Board selectOne(Long bno) {
		conn = DBConn.getConnection();
		// 반환 예정 객체
		Board board = null;
		// 처리할 sql 구문
		String sql = "select tb.*, (select count(*) from tbl_reply tr where tr.bno =tb.bno) replyCnt\r\n"
				+ "from tbl_board tb where bno = ?";
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			// 결과집합 반환
			rs = pstmt.executeQuery();
			
			// 결과집합 >> 자바객체
			if(rs.next()) {
				int idx = 1;
				// 객체 생성 후 값 바인딩
				board = new Board(
						rs.getLong(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++),
						rs.getString(idx++),
						rs.getInt(idx++), rs.getInt(idx++), null, rs.getInt(idx++));

			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return board;
	}
	
	public List<Board> selectList( Criteria cri) {
		conn = DBConn.getConnection();
		// 반환 예정 객체
		List<Board> boards = new ArrayList<Board>();
		// 처리할 sql 구문
		String sql = "";
		sql += "select tb.*, (select count(*) from tbl_reply tr where tr.bno =tb.bno) replyCnt\r\n"
				+ "from tbl_board tb where category = ?";
// 		검색
		sql += getSearchSqlBy(cri);
		
		sql +=" order by bno desc limit ? offset ?";	
//		System.out.println(sql);
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setInt(idx++, cri.getCategory());
//			if(cri.getType() != null && cri.getKeyword() != null) {
//				pstmt.setString(idx++, cri.getKeyword());
//			}
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, (cri.getPageNum()-1) * cri.getAmount());
			
			// 결과집합 반환
			rs = pstmt.executeQuery();
			
			// 결과집합 >> 자바객체
			while(rs.next()) {
				idx = 1;
				// 객체 생성 후 값 바인딩
				Board board = new Board(
						rs.getLong(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++),
						rs.getString(idx++),
						rs.getInt(idx++), rs.getInt(idx++), null, rs.getInt(idx++));
				boards.add(board);				
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return boards;
	}
	
	public int selectListCount(Criteria cri) {
		conn = DBConn.getConnection();
		// 반환 예정 객체
		int count = 0;
		// 처리할 sql 구문
		String sql = "select count(*) from tbl_board where category = ?";
		sql += getSearchSqlBy(cri);
		
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cri.getCategory());
			
			// 결과집합 반환
			rs = pstmt.executeQuery();
			
			// 결과집합 >> 자바객체
			while(rs.next()) {
				int idx = 1;
				// 객체 생성 후 값 바인딩
				count = rs.getInt(1);
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return count;
	}
	private String getSearchSqlBy(Criteria cri) {
		String sql = "";
		if(cri.getType() != null && cri.getKeyword() != null && String.join("", cri.getType()).length() > 0) {		
			sql += " and ( ";			
			
			List<String> list = Arrays.asList(cri.getType());
			// T C W
			List<String>typeList = list.stream().map(s->" " +s + " like '%" + cri.getKeyword() +"%' ").collect(Collectors.toList());
			sql += String.join(" or ", typeList);
			
			sql += ")";
		}
		return sql;
	}
	
	public void update(Board board) {
		conn = DBConn.getConnection();
		// 처리할 sql 구문
		String sql = "update tbl_board set\r\n"
				+ "title = ?,\r\n"
				+ "content = ?,\r\n"
				+ "updatedate = now()\r\n"
				+ "where bno =?";
//		System.out.println(sql);
		try {
			// 문장 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setLong(3, board.getBno());
			
			// 문장 처리
			pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void increaseHitCount(Long bno) {
		conn = DBConn.getConnection();
		// 처리할 sql 구문
		String sql = "update tbl_board set\r\n"
				+ "hitcount = hitcount+1\r\n"
				+ "where bno =?";
		try {
			// 문장 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			// 문장 처리
			pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(Long bno) {
		conn = DBConn.getConnection();
		// 처리할 sql 구문
		String sql = "delete from tbl_board where bno=?";
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			// 결과집합 반환
			pstmt.executeQuery();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 자원 반환
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		
	}

	
	public static void main(String[] args) {		
		String str = "12345";
		String[] result = str.split("");
		System.out.println(result.length);
		String result2 = String.join(" or ", result);
		System.out.println(result2);
	}
}
