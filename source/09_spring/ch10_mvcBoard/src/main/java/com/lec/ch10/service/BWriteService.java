package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;
import com.lec.ch10.vo.BoardDto;
@Service
public class BWriteService implements BService {
	@Autowired
	private BoardDao bDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto board = (BoardDto)map.get("board");
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		board.setBip(request.getRemoteAddr());
		model.addAttribute("writeResult", bDao.writeBoard(board));
	}
}
