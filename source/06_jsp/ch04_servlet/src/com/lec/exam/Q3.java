package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q3")
public class Q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String text = request.getParameter("text");
		
		out.println(  "<html>"
					+ "<head>"
					+ "<style>"
					+ "@charset \"UTF-8\";" + 
					"body { background-color: #FFF0B5;font-size: 9pt; }" + 
					"table {border: pink solid 2px; margin:0 auto;}" + 
					"tr {background-color: #FFE271;}" + 
					"tr:HOVER {background-color: orange;cursor: pointer;}" + 
					"td,th {text-align: center; padding: 5pt;}" + 
					"caption { font-size: 25px;}"
					+ "</style>"
					+ "</head>"
					+ "<body>"
					+ "<table>"
					+ "<tr><th colspan='2'>반갑습니다." + name + "님</th></tr>"
					+ "<tr><th>글제목</th><td>" + title + "</td></tr>"
					+ "<tr><th>글내용</th><td><pre>" + text + "</pre></td></tr>"
					+ "</body>"
					+ "</html>"
					);
		out.close();
	}
}
