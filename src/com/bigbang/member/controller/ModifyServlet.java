package com.bigbang.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	session => id 추출
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id.equals("")) {
//			로그인이 안된 상태 => 	MainServlet 보낸다. => loginForm.jsp
			response.sendRedirect("MainServlet");
			
		}else {
//			select id
			MemberService mService = new MemberService();
			MemberVO member = mService.selectById(id);
//			request에 select한 결과를 담는다
			request.setAttribute("member", member);
//			modifyForm.jsp forward
			RequestDispatcher disp = request.getRequestDispatcher("modifyForm.jsp");
			disp.forward(request, response);
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		requset => 사용자가 입력한 정보 추출
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pw= request.getParameter("pw"); 
		String phone1 = request.getParameter("phone1"); 
		String phone2 = request.getParameter("phone2"); 
		String phone3 = request.getParameter("phone3"); 
		String gender = request.getParameter("gender"); 
//		비밀번호 확인
		if(pw.equals("")) {
//			비밀번호 입력X
			doGet(request,response);
		}else {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			MemberService mService = new MemberService();
//			id: session, pw : 사용자가 입력한 비밀번호
			MemberVO member = mService.selectByIdPw(id,pw);
			if(member != null) {
//				비밀번호가 정상 입력된 경우
				MemberVO mem = new MemberVO();
				mem.setName(name);
				mem.setId(id);
				mem.setPhone1(phone1);
				mem.setPhone2(phone2);
				mem.setPhone3(phone3);
				mem.setGender(gender);
				
				mService.updateMember(mem);
				response.sendRedirect("MainServlet");
			}else {
//				비밀번호가 잘못 입력된 경우
				doGet(request,response);
			}
		}
//		OK인 경우
		
//		OK X 경우
	}

}
