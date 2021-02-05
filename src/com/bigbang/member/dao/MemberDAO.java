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
      String query = "select * from member";
      
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
//   2. 이름 검색
   
//   3. 회원 추가
   
//   4. 회원 수정
   
//   5. 회원 삭제
}