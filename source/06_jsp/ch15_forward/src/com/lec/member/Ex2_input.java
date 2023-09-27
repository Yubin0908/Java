package com.lec.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex2_input")
public class Ex2_input extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// process = java
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0; // total var
		for(int i=1; i<=su; i++) {
			sum += i;
		}
		// view단로 forward
		request.setAttribute("sum", sum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_view.jsp");
		dispatcher.forward(request, response);
	}

}
