
<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="com.lec.dto.BookDto"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		// 첨부한 파일 저장 후 파일이름 받아오기
		String path = request.getSession().getServletContext().getRealPath("fileboardUpload");
		// out.print("서버에 저장될 폴더 : " + path + "<br>");
		int maxSize = 1024*1024*3; // Maxi. 3Meg
		String filename = "";
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			// while(params.hasMoreElements()) {
				String param = params.nextElement();
				filename = mRequest.getFilesystemName(param);
			// }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일을 소스폴더로 복사(사용자 배포 시 제거 로직)

			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + filename); // 서버에 업로드된 파일
				// if(fileName != null) {
				if(serverFile.exists()) {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:\\Project\\source\\06_jsp\\model1ex\\WebContent\\fileboardUpload\\"+filename); // souce폴더에 복사할 파일
					byte[] bs = new byte[(int)serverFile.length()];
					while(true) {
						int readByteCnt = is.read(bs);
						if(readByteCnt==-1) break;
						os.write(bs, 0, readByteCnt);
						
					}
					System.out.println("복사 완료.");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid(); 
		String ftitle = mRequest.getParameter("ftitle");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		String fip = request.getRemoteAddr();
		FileBoardDto fDto = new FileBoardDto(0, cid, ftitle, fcontent, filename, 0, fpw, 0,
				0, 0, fip, null, null, null);
		
		FileBoardDao fDao = FileBoardDao.getinstance();
		int result = fDao.insertBoard(fDto);
		if(result==FileBoardDao.PASS){
	%>
			<script>
				alert('글쓰기 성공');
				location.href = 'fboardList.jsp';
			</script>
	<%}else{%>
			<script>
				alert('글쓰기 실패');
				history.back();
			</script>
	<%}%>
		
	%>
		 <script>
	 		location.href = "<%=conPath%>/fileboard/fboardList.jsp";
	 	 </script>
	<%-- <h2>책이름 <%=btitle %></h2>
	<h2>책가격 
		<del><%=bprice %></del>
		<b>
			<%if(bdiscount!= 0) {%>
			<%=bprice * (100 - bdiscount) / 100 %>원 (<%=bdiscount %>% 할인)
			<%} else { %>
				<%=bprice %>원
			<%} %>
		</b>
	</h2>
	<h2>대표이미지 <%=path %>/bookimg/<%=bimg1 %></h2>
	<h2>추가이미지 <%=path %>/bookimg/<%=bimg2 %></h2>
	<img src="<%=conPath %>/bookimg/<%=bimg1 %>" alt="대표이미지">
	<img src="<%=conPath %>/bookimg/<%=bimg2 %>" alt="추가이미지">
	<h2>책설명 <pre><%=bcontent %></pre></h2>
	<hr>
	<a href="ex1_listBoardStyle.jsp">책 전체 리스트(게시판 스타일)</a> <br>
	<a href="ex2_list.jsp">책 리스트(페이징)(게시판 스타일)</a> <br>
	<a href="ex3_listProductStyle.jsp">책 전체 리스트(제품 리스트 스타일)</a> <br>
	<a href="ex4_product.jsp">책 리스트(페이징)(제품 리스트 스타일)</a> <br>	 --%>
</body>
</html>