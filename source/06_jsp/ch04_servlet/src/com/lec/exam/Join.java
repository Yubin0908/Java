package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Actiondo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Actiondo(request, response);
	}

	private void Actiondo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String hidden = request.getParameter("hidden");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String date = request.getParameter("date");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String mail = request.getParameter("mail");
		String[] ad = request.getParameterValues("ad");
		
		PrintWriter out = response.getWriter();
		
		out.println(  "<html>"
					+ "<head>"
					+ "<title>가입정보</title>"
					+ "<link href=\"css/join.css\" rel=\"stylesheet\">"
					+ "</head>"
					+ "<body>"
					+ "<div id=\"joinForm_wrap\">"
					+ "<div id=\"join_title\">"
					+ "회원가입정보"
					+ "</div>"
					+ "<div>"
					+ "<p>hiddenParam : " + hidden + "</p>"
					+ "<p>이름 : " + name + "</p>"
					+ "<p>아이디 : " + id + "</p>"
					+ "<p>비밀번호 : " );
						for(int idx=0; idx<pw.length(); idx++) {
							out.print('*');
						}
		out.println(  "</p>"
					+ "<p>생년월일 : " + date + "</p>"
					);
					if(hobby!=null) {
						out.println("<p>취미 : ");
						for(int i=0; i<hobby.length; i++) {
							if(i==hobby.length-1) {
								out.print(hobby[i]);
							} else {
								out.print(hobby[i]+ ", ");
							}
						}
					} else {
						out.println("<p>취미 : 없음");
					}
					
		out.println(  "<p>성별 : " + gender + "</p>"
					+ "<p>이메일 : " + mail + "</p>");
					if(ad!=null) {
						out.println("<p>메일수신동의 : ");
						for(int i=0; i<ad.length; i++) {
							if(i==ad.length-1) {
								out.print(ad[i]);
							} else {
								out.print(ad[i]+ ", ");
							}
						}
					} else {
						out.println("<p>메일수신동의 : 없음");
					}
		
		out.println(  "</div>"
					+ "</div>" 
					+ "</body>"
					+ "</html>");
	}

}
