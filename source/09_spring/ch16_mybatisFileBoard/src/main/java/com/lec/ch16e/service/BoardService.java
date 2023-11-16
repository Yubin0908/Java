package com.lec.ch16e.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch16e.util.Paging;
import com.lec.ch16e.vo.Board;

public interface BoardService {
	public List<Board> boardList(Paging paging);
	public int getBoardTotCnt();
	public int boardWrite(Board board, MultipartHttpServletRequest mrs, ModelAndView mov);
	public Board boardInfo(int bid, String after);
	public Board boardModifyReplyView(int bid);
	public int boardModify(Board board, HttpServletRequest request);
	public int boardDelete(int bid);
	public int boardReply(Board board, HttpServletRequest request);
}
