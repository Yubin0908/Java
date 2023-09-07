package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q2_tot")
public class Q2_tot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);

	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException {
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    String suStr = request.getParameter("insu");
	    int insu = Integer.parseInt(suStr);
	    
	        int tot = 0;
	        for(int i = 1; i <= insu; i++) {
	            tot += i;
	        }
	   
	        out.println("1부터 " + insu + " 까지의 누적합은 " + tot);

	}
}

