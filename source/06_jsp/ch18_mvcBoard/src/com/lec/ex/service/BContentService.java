package com.lec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// parameter : pid 받아 dao를 통해 dto request 에 추가(hitup ?)
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = new BoardDao();
		// list.jsp를 통해서 content.do로 올때만 hitUp! Url : content.do?bid=2&pageNum=2
		// 수정 성공 후 content.do로 올때는 hitUp x Url : content.do?after=u
		if(request.getParameter("after")==null) {
			bDao.hitUp(bid);
		}
		request.setAttribute("contentBoard", bDao.getBoardNotHitUp(bid));
	}

}
