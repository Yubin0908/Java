package com.lec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// parameter : bname, btitle, bcontent, bip 가져와서 dao 통해 write
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		BoardDao bDao = new BoardDao();
		request.setAttribute("writeResult", bDao.writeBoard(bname, btitle, bcontent, bip));
	}

}
