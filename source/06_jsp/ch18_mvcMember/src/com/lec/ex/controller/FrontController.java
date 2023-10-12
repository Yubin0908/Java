package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청에 따른 서비스 호출 및 뷰단 forward
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) { // main page
			viewPage = "member/main.jsp";
			
		} else if(command.equals("/loginView.do")) { // login page
			viewPage = "member/login.jsp";
			
		} else if(command.equals("/login.do")) { // DB -> loginCheck & session init
			service = new MLoginService();
			service.execute(request, response);
			// next 값에 따른 forward
			String next = request.getParameter("next");
			if(next.isEmpty()) {
				viewPage = "member/main.jsp";
			} else {
				viewPage = next;
			}
			
		} else if(command.equals("/joinView.do")) { // join page
			viewPage = "member/join.jsp";
			
		} else if(command.equals("/join.do")) { // DB -> join init
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
			
		} else if(command.equals("/logout.do")) { // session invalid 
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
			
		} else if(command.equals("/modifyView.do")) { // modify page
			viewPage = "member/modify.jsp";
			
		} else if(command.equals("/modify.do")) { // DB -> modify Update
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
			
		} else if(command.equals("/allView.do")) { // DB -> member List output
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
			
		} else if(command.equals("/withdrawal.do")) { // DB -> member delete
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	

}
