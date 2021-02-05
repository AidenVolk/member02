package com.bigbang.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 로그인여부 확인
//		1.1 Session 확인 -> 정상적 로그인 후 이름, 아이디 Session 저장
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
		
		if(name == null || id == null) { //정상적인 로그인 하지 않은 사용자인 경우
			response.sendRedirect("longinForm.jsp");
		}else { // 2. 정상 로그인 한 경우 처리
//			2.1 main.jsp에 전달할 데이터 생성 => request에 담아야 한다
//			회원(MemberVO) 목록(ArrayList)
			MemberService mService = new MemberService();
			ArrayList<MemberVO> members = mService.selectAll();
			
//			2.2 main.jsp 포워딩
			RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
			disp.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
