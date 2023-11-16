package com.lec.ch18sch.repository;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch18sch.vo.Member;
@Mapper
public interface MemberRepository {
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public String loginCheck(String mid, String mpw);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member);
}
