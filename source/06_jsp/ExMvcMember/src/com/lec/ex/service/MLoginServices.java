package com.lec.ex.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MLoginServices implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.FAIL;
		try {
			result = mDao.loginCheck(mid, mpw);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			MemberDto member = null;
			try {
				member = mDao.getMember(mid);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			session.setAttribute("member", member);
		} else {
			request.setAttribute("loginErrMsg", "아이디와 비밀번호를 확인하세요.");
		}

	}

}
