package com.bigbang.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		회원가입 화면 이동
		response.setCharacterEncoding("utf-8");
		request.setAttribute("msg", "아이디/비밀번호 필수");
		RequestDispatcher disp = request.getRequestDispatcher("joinForm.jsp");
		disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		회원가입 처리 : insert
//		request에서 입력데이터 추출 => Service 단 => DAO 단, insert
		MemberVO member = new MemberVO();
		member.setName(request.getParameter("name"));
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setPhone1(request.getParameter("phone1"));
		member.setPhone2(request.getParameter("phone2"));
		member.setPhone3(request.getParameter("phone3"));
		member.setGender(request.getParameter("gender"));
		
		request.setAttribute("member", member);
		
		if(member.getId().equals("") || member.getName().contentEquals("")) {
			doGet(request, response); // 아이디, 비밀번호 X 다시 회원가입폼
		}else {
//			Insert
			MemberService mService = new MemberService();
			mService.insertMember(member);
			response.sendRedirect("MainServlet");
		}
		
	}

}
