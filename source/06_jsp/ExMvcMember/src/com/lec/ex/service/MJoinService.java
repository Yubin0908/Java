package com.lec.ex.service;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = MemberDao.FAIL;
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mbirthStr = request.getParameter("mbirth");
		Date mbirth = mbirthStr.equals("") ? null:Date.valueOf(mbirthStr);
		String maddress = request.getParameter("maddress");
		MemberDao mDao = MemberDao.getInstance();
		
		try {
			result = mDao.id_check(mid);
			if(result == MemberDao.NOTEXESITENT) {
				MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mbirth, maddress, null);
				result = mDao.joinMember(newMember);
				if(result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinMsg", "회원가입이 완료되었습니다.");
				} else {
					request.setAttribute("joinErrMsg", "정보의 길이를 초과하였습니다.");
				}
			} else {
				request.setAttribute("joinErrMsg", "중복된 ID로 회원가입이 불가합니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
