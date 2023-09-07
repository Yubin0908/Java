<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>실습예제</title>

</head>
<body>
<% 
	String num = request.getParameter("num");
	if(num != null) {
		num = num.trim();
	}
%>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" method="get">
		<p>숫자 
		<input type="number" name="num" min="1" value="<%=num!=null? num : ""
																												//		if(num!=null){
																												//			out.print(num);
																												//		} 
		%>"> <input type="submit" value="누적"></p>
		</form>
	</fieldset>
	<% // parameter 
		
		if(num != null) {
			int n = Integer.parseInt(num);
			int tot =0;
			for(int i=1; i<=n; i++) {
				tot += i;
			}
			out.print("<h2>1부터 " + n + "까지 누적합은 : " + tot + " 입니다.</h2>");
		}
	%>
	
</body>
</html>