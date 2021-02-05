package com.bigbang.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		로그인 화면으로 이동
		response.sendRedirect("loginForm.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		select : 입력한 아이디와 비밀번호가 데이터베이스에 존재 여부 확인
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberService mService = new MemberService();
		
		MemberVO member = mService.selectByIdPw(id, pw);
		if(member.getId() != null) {
//			정상 로그인
//			1. Session 이름, 아이디 추가
			HttpSession session = request.getSession();
			session.setAttribute("name", member.getName());
			session.setAttribute("id", member.getId());
//			2. MainServlet 간다
			response.sendRedirect("MainServlet");
		}else {
//			비정상 로그인
			response.sendRedirect("loginForm.jsp");
		}
	}
}
