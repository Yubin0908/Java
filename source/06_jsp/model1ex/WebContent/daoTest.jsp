<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>                                
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		CustomerDao dao = CustomerDao.getInstanse();
		String cid = "uuu";
		int result = dao.confirmID(cid);
		if(result == CustomerDao.CUSTOMER_EXISTENT) {
			out.print("1. confirmID result : " + cid + "(중복됨)");
		} else {
			out.print("1. confirmID result : " + cid + "(중복아님)");
			CustomerDto dto = new CustomerDto(cid, "111", "김", "010-0000-0000",null,null,null,null);
			result = dao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS) {
				out.print("<br>2. join result : " + cid + "(가입성공)");
			} else {
				out.print("<br>2. join result : " + cid + "(가입실패)");
			}
		}
		out.print("<br>3. logincheck result<br>");
		cid = "uuu"; String cpw = "111";
		result = dao.Logincheck(cid, cpw);
		out.print("1.조건 : id/pw 모두 일치<br>");
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_PW){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_ID){
			out.print("(아이디) " + cid 
					+", (비밀번호) " + cpw + " : 아이디 오류로 로그인 실패<br>");
		}

		cid = "uuu"; cpw = "222";
		result = dao.Logincheck(cid, cpw);
		out.print("2.조건 : 비밀번호 불일치<br>");
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_PW){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_ID){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 아이디 오류로 로그인 실패<br>");
		}
		
		cid = "333"; cpw = "111";
		result = dao.Logincheck(cid, cpw);
		out.print("3.조건 : 아이디 불일치<br>");
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_PW){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == CustomerDao.LOGIN_FAIL_ID){
			out.print("(아이디) " + cid +", (비밀번호) " + cpw + " : 아이디 오류로 로그인 실패<br>");
		}
		out.print("4. db dto loading test<br>");
		CustomerDto dto = dao.getCustomer("kim");
		out.print("id=kim인 customer : " + dto + "<br>");
		out.print("5. Customer Update Test");
		out.print("id=kim,인 customer 수정전 : " + dao.getCustomer("kim") + "<br>");
		dto = new CustomerDto("kim", "222", "홍길동", "02-0000-1111", null,
				null, null, null);
		result = dao.modify(dto);
		if(result == CustomerDao.SUCCESS){
			out.print("db에 수정후 데이터 : " + dao.getCustomer("kim") + "<br>");
		}else{
			out.print(dto.getCid() + " 수정 실패");
		}
	%>
</body>
</html>