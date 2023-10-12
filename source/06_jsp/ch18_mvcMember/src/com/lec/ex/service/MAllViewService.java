package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// allView.do나 allView.do?pageNum=2
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE = 5;
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		MemberDao mDao = MemberDao.getInstance();
		try {
			request.setAttribute("members", mDao.getMemberlist(startRow, endRow));
			int cnt = mDao.getMemberTotCnt();
			int pageCnt = (int)Math.ceil((double)cnt/PAGESIZE);
			int startPage = ((currPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt) {
				endPage = pageCnt;
			}
			request.setAttribute("BLOCKSIZE", BLOCKSIZE);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageNum", currPage);
			request.setAttribute("pageCnt", pageCnt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
