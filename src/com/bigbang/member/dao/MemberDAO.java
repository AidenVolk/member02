package com.bigbang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bigbang.member.vo.MemberVO;

public class MemberDAO {

//   Connection 
   
//   1. 모든 회원 검색
   public ArrayList<MemberVO> selectAll(){
      Connection con         	= null;
      PreparedStatement pstmt 	= null;
      ResultSet rs         		= null;
      DBConnection dbCon       	= null;
      
      ArrayList<MemberVO> members = new ArrayList<MemberVO>();
      String query = "select * from member1";
      
      try {
         dbCon = DBConnection.getInstance();
         con = dbCon.getConnection();
         pstmt = con.prepareStatement(query);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            MemberVO member = new MemberVO();
            member.setName(rs.getString("name"));
            member.setId(rs.getString("id"));
            member.setPw(rs.getString("pw"));
            member.setPhone1(rs.getString("phone1"));
            member.setPhone2(rs.getString("phone2"));
            member.setPhone3(rs.getString("phone3"));
            member.setGender(rs.getString("gender"));
            
            members.add(member);
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         dbCon.close(con, pstmt);
      }
      return members;
   }
//   2. 로그인 처리
   	public MemberVO selectByIdPw(String id, String pw) {
   		Connection con 			= null;
   		PreparedStatement pstmt = null;
   		ResultSet rs 			= null;;
   		MemberVO member 		= new MemberVO();
   		StringBuilder query = new StringBuilder();
   		query.append("SELECT name, id	");
   		query.append("FROM member1		");
   		query.append("WHERE id = ?		");
   		query.append("AND pw = ?		");
   		
   		DBConnection dbCon 		= DBConnection.getInstance();
   		
   		try {
   			con = dbCon.getConnection();
   			pstmt = con.prepareStatement(query.toString());
   			pstmt.setString(1, id);
   			pstmt.setString(2, pw);
   			rs = pstmt.executeQuery();
   			if(rs.next()) {
   				member.setName(rs.getString("name"));
   				member.setName(rs.getString("id"));
   			}
   		}catch(Exception e) {
   			e.printStackTrace();
   		}finally {
   			try {
   				if(rs != null) {
   					rs.close();
   				}
   				dbCon.close(con, pstmt);
   				
   			}catch(Exception e) {
   				e.printStackTrace();
   			}
   		}
   		
   		
   		return member;
   	}
	public void insertMember(MemberVO member) {
//   회원 추가
		Connection con 			= null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO member1 values(?,?,?,?,?,?,?)";
		
		DBConnection dbCon 		= DBConnection.getInstance();

		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getPhone1());
			pstmt.setString(5, member.getPhone2());
			pstmt.setString(6, member.getPhone3());
			pstmt.setString(7, member.getGender());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
	}
	public MemberVO selectById(String id) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		MemberVO member			= null;
		DBConnection dbCon		= DBConnection.getInstance();
		String query 			= "SELECT * FROM member1 WHERE id = ?";
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone1(rs.getString("phone2"));
				member.setPhone1(rs.getString("phone3"));
				member.setGender(rs.getString("gender"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				dbCon.close(con, pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	public void updateMember(MemberVO mem) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		DBConnection dbCon = DBConnection.getInstance();
		StringBuilder query = new StringBuilder();
		query.append("UPDATE member1 	");
		query.append("   SET name = ?	");
		query.append("	     phone1 = ?	");
		query.append("	     phone2 = ?	");
		query.append("	     phone3 = ?	");
		query.append("WHERE  id = ?		");
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getPhone1());
			pstmt.setString(3, mem.getPhone2());
			pstmt.setString(4, mem.getPhone3());
			pstmt.setString(5, mem.getId());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
   
//   3. 이름 검색
   
   
//   5. 회원 수정
   
//   6. 회원 삭제
   
}