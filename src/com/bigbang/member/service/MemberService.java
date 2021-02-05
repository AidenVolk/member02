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
	public MemberVO selectByIdPw(String id, String pw) {
		MemberVO member = new MemberDAO().selectByIdPw(id, pw);
		
		return member;
	}
	public void insertMember(MemberVO member) {
		MemberDAO mDao = new MemberDAO();
		mDao.insertMember(member);
	}
	public MemberVO selectById(String id) {
		MemberVO member = null;
		MemberDAO mDao = new MemberDAO();
		member = mDao.selectById(id);
		
		return member;
	}
	public void updateMember(MemberVO mem) {
		MemberDAO mDao = new MemberDAO();
		mDao.updateMember(mem);
	}
	
}
