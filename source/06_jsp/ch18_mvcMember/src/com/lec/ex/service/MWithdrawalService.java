package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto mDto = (MemberDto)session.getAttribute("member");
		if(mDto != null) {
			mid = mDto.getMid();
		}
		MemberDao mDao = MemberDao.getInstance();
		try {
			int result = mDao.withdrawalMember(mid);
			if(result == MemberDao.SUCCESS) {
				request.setAttribute("withResult", "회원탈퇴 처리 되었습니다.");
				session.invalidate();
			} else {
				request.setAttribute("withResult", "로그인이 되어 있지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
