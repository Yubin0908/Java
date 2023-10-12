package com.lec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.service.Service;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// pageNum 파라미터를 받아 startrow, endrow, startpage, endpage 계산. dao를 통해 list 반환
		// list.do나 list.do?pagenum=
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		request.setAttribute("list", bDao.listBoard(startRow, endRow)); // 글목록 뷰페이지로 전달
		int cnt = bDao.BoardCount(); // 글갯수
		int pageCnt = (int)Math.ceil((double)cnt/PAGESIZE);
		int startPage = ((currPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // 이전버튼 출력여부
		request.setAttribute("startPage", startPage); 
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currPage);
		request.setAttribute("pageCnt", pageCnt); // 다음버튼 출력여부
	}

}
