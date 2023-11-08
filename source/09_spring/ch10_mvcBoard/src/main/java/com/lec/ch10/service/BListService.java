package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;
@Service
public class BListService implements BService {
	@Autowired
	private BoardDao bDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map으로 변경
		String page = (String)map.get("page"); // ${page}
		
		if(page == null) {
			page = "1";
		}
		
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		
		int currPage = Integer.parseInt(page); // 현재페이지
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		// BoardDao bDao = new BoardDao();
		
		// view 출력 boardlist
		model.addAttribute("boardList", bDao.listBoard(startRow, endRow));
		
		int orderNum = startRow; // 출력하게될 순차번호
		int totCnt = bDao.BoardCount(); // 글 갯수
		int inverseNum = totCnt - startRow + 1; // 첫라인에 출력될 역순번호
		
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("page", page);
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("blocksize", BLOCKSIZE);
		model.addAttribute("currPage", currPage);
		}
}
