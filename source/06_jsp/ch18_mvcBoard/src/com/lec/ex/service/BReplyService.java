package com.lec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
		BoardDao bDao = new BoardDao();
		int replyResult = bDao.replyBoard(bname, btitle, bcontent, bip, bgroup, bstep, bindent);
		request.setAttribute("replyResult", replyResult);
	}

}
