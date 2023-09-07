package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q1_ququ")
public class Q1_ququ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] suStr = request.getParameterValues("su");
		int[] suInt = new int[suStr.length];
		PrintWriter out = response.getWriter();
		for(int i=0; i<suStr.length; i++) {
			suInt[i] = Integer.parseInt(suStr[i]);
			for(int idx=1; idx<10; idx++) {
				out.println(suInt[i] + " * " + idx + " = " + (suInt[i]*idx));
			}
			out.println();
		}
		
		
	}

	
}
