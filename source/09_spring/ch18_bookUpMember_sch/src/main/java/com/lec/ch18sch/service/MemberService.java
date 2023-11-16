package com.lec.ch18sch.service;
import javax.servlet.http.HttpSession;

import com.lec.ch18sch.vo.Member;
public interface MemberService {
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession httpSession);
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member, HttpSession httpSession);
}
