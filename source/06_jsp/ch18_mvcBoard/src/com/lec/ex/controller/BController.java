package com.lec.ex.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.BContentService;
import com.lec.ex.service.BDeleteService;
import com.lec.ex.service.BModifyViewService;
import com.lec.ex.service.BReplyService;
import com.lec.ex.service.BReplyViewService;
import com.lec.ex.service.BWriteService;
import com.lec.ex.service.Service;
import com.lec.ex.service.BListService;
import com.lec.ex.service.BModifyService;

@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int writeMode = 0;
	// private boolean writeMode = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청에 따른 일을 하고 뷰단으로 forward
		String uri = request.getRequestURI(); // "/ch18_mvcBoard/list.do"
		String conPath = request.getContextPath(); // "/ch18_mvcBoard"
		String command = uri.substring(conPath.length()); // "/list.do"
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) { // 글목록 list.do?pageNum=?
			service = new BListService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			viewPage = "board/list.jsp";
		} else if(command.equals("/writeView.do")) { // 글쓰기 form태크 페이지(뷰단)
			viewPage = "board/write.jsp";
			writeMode = 1;
		} else if(command.equals("/write.do")) { // 글쓰기 DB 저장(프로세스)
			if(writeMode == 1) {
					
				try {
					service = new BWriteService();
					service.execute(request, response);
					writeMode = 0;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
			viewPage = "list.do";
		} else if(command.equals("/content.do")) { // 상세보기
			service = new BContentService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			viewPage = "board/content.jsp";
		} else if(command.equals("/updateView.do")) { // 글수정을 위한 view
			service = new BModifyViewService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
			viewPage = "board/modify.jsp";
		} else if(command.equals("/update.do")) { // 글수정 DB 저장(프로세스)
			service = new BModifyService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			/* viewPage = "list.do"; */
			viewPage = "content.do?after=u"; // 수정 후 상세보기 페이지로 이동 시, 조회수 증가 안하게 함
		} else if(command.equals("/delete.do")) { // 글 삭제(프로세스)
			service = new BDeleteService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			viewPage = "list.do";
		} else if(command.equals("/replyView.do")) { // 답변글 쓰기 form태그 페이지(뷰단)
			service = new BReplyViewService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			viewPage = "board/reply.jsp";
		} else if(command.equals("/reply.do")) { // 답변글 DB 저장(프로세스) 
			service = new BReplyService();
			try {
				service.execute(request, response);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			viewPage = "board/list.do";
		}
		// 뷰 단으로 forward!
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
