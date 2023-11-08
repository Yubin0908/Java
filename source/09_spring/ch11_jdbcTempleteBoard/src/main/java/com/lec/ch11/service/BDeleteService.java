package com.lec.ch11.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.vo.BoardDto;
@Service
public class BDeleteService implements BService {
	@Autowired
	private BoardDao bDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		
		model.addAttribute("deleteMsg", bDao.deleteBoard(bid));
	}

}
