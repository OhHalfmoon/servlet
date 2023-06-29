package com.ohalfmoon.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ohalfmoon.jsp.domain.Reply;
import com.ohalfmoon.jsp.domain.Criteria;
import com.ohalfmoon.jsp.domain.Member;
import com.ohalfmoon.jsp.util.DBConn;

public class ReplyDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int insert(Reply reply) {
		conn = DBConn.getConnection();
		int result = 0;
		// 처리할 sql 구문
		String sql = "insert into tbl_reply (content, writer, bno) values (?, ?, ?)";
//		System.out.println(sql);
		try {
			// 문장 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getContent());
			pstmt.setString(2, reply.getWriter());
			pstmt.setLong(3, reply.getBno());
			result = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
	public List<Reply> selectList(Long bno) {
		conn = DBConn.getConnection();
		List<Reply> replies = new ArrayList<Reply>();
		String sql = "";
		sql += "select * from tbl_reply where bno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setLong(idx++, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = 1;
				Reply reply = new Reply(
						rs.getLong(idx++),
						rs.getString(idx++),
						rs.getDate(idx++),
						rs.getString(idx++),
						rs.getLong(idx++));
				replies.add(reply);				
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return replies;
	}
	
	
	public int delete(Long bno) {
		int ret = 0;
		conn = DBConn.getConnection();
		// 처리할 sql 구문
		String sql = "delete from tbl_reply  where bno=?";
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			// 문장 처리
			ret = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public int deleteRP(Long rno) {
		int ret = 0;
		conn = DBConn.getConnection();
		// 처리할 sql 구문
		String sql = "delete from tbl_reply  where rno=?";
		try {
			// 문장생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, rno);
			
			// 문장 처리
			ret = pstmt.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
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
	
	public Reply selectOne(Long rno) {
		conn = DBConn.getConnection();
		// 반환 예정 객체
		Reply reply = null;
		// 처리할 sql 구문
		String sql = "";
		sql = "select * from tbl_reply where rno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setLong(idx++, rno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = 1;
				 reply = new Reply(
						rs.getLong(idx++),
						rs.getString(idx++),
						rs.getDate(idx++),
						rs.getString(idx++),
						rs.getLong(idx++));							
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return reply;
	}

	
	public static void main(String[] args) {
		
		ReplyDao ra = new ReplyDao();
//	ra.insert(new Reply("테스트", "id1"	,271L));
	ra.delete(9L);
	}
}


