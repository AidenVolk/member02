package com.bigbang.member.service;

import java.util.ArrayList;

import com.bigbang.member.dao.MemberDAO;
import com.bigbang.member.vo.MemberVO;

public class MemberService {
	
//	모든 회원 검색
	public ArrayList<MemberVO> selectAll(){
//		ArrayList<MemberVO> members = null;
		ArrayList<MemberVO> members = new MemberDAO().selectAll();
//		MemberDAO mDao = new MemberDAO();
//		members = mDao.selectAll();
//		mDao.selectByName();
		return members;
		
	}
	
}
