package com.ohalfmoon.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ohalfmoon.jsp.domain.Member;
import com.ohalfmoon.jsp.util.DBConn;

public class MemberDao {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public int insert(Member vo) {
		conn = DBConn.getConnection();
		int result = 0;
		// 처리할 sql 구문
		String sql = "insert into tbl_member(id, pw, name) values ('"
				+ vo.getId() + "','" + vo.getPw() + "','" + vo.getName() + "')";
		try {
			// 문장 생성
			stmt = conn.createStatement();
			
			// 문장 처리
			result = stmt.executeUpdate(sql);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
	public Member selectOne(String id) {
		conn = DBConn.getConnection();
		// 반환 예정 객체
		Member vo = null;
		// 처리할 sql 구문
		String sql = "select * from tbl_member where id = '" + id + "'";
		try {
			// 문장생성
			stmt = conn.createStatement();
			
			// 결과집합 반환
			rs = stmt.executeQuery(sql);
//			System.out.println(rs);
			// 결과집합 >> 자바객체
			if(rs.next()) {
				int idx = 1;
				// 객체 생성 후 값 바인딩
				vo = new Member(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
				);
			}
			//System.out.println(vo);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 결과 반환
		return vo;
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
		MemberDao dao = new MemberDao();
//		dao.insert (new MemberVo("id1", "1234", "홍길동", null));
		System.out.println(dao.selectOne("id2"));
	}
}
