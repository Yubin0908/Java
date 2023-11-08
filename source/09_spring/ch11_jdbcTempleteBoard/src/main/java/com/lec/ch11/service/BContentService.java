package com.lec.ch11.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.vo.BoardDto;
@Service
public class BContentService implements BService {
	@Autowired
	private BoardDao bDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		String after = (String)map.get("after");
		
		if(after == null) {
			bDao.hitUp(bid);
		}
		model.addAttribute("contentBoard", bDao.getBoardNotHitUp(bid));
	}

}
