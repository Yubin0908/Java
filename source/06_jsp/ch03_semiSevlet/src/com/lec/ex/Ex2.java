package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String numStr = request.getParameter("num");
		response.setContentType("text/html;charset=UTF-8");
		if(numStr == null) {
			response.getWriter().print("넘어온 파라미터가 없습니다.");
		} else {
			// 누적한 결과 이름과 함께 출력
			int num = Integer.parseInt(numStr);
			int tot = 0;
			for(int i = 1; i <= num; i++) {
				tot += 1;
			}
			PrintWriter out = response.getWriter(); // Create Stream
			out.print("<html>"
					+ "<head>"
					+ "<link href=\"css/layout.css\" rel=\"stylesheet\">"
					+ "</head>"
					+ "<body>"
					+ "<h1>" + name + "님이 요청하신 누적결과입니다.</h1>"
					+ "<h2>" + num + "까지 누적합은 " + tot + "입니다.</h2>"
					+ "</body>"
					+ "</html>");
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
}
