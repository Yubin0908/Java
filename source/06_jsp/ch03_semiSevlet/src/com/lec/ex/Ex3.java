package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String numStr = request.getParameter("num");
		int num = Integer.parseInt(numStr);
		PrintWriter out = response.getWriter();
		out.println(  "<html>"
					+ "<head>"
					+ "</head>"
					+ "<body>"
					+ "<h2>요청하신 " + num + "단의 구구단은 아래와 같습니다.</h2>");
		
					for(int i = 1; i < 10; i++) {
						out.print(num + " * " + i + " = " + (num*i) + "<br>");
					};		
					
		out.println("</body>"
				+ 	"</html>");
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}


