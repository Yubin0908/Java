<%@page import="com.lec.ex.book.BookDao"%>
<%@page import="com.lec.ex.book.BookDto"%>
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
		String path = request.getRealPath("bookimg");
		out.print("서버에 저장될 폴더 : " + path + "<br>");
		int maxSize = 1024*1024*3; // Maxi. 3Meg
		String[] images = {"",""};
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				images[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx+"번째 처리한 파라미터 : " + param + "/파일명" + images[idx]);
				idx++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일을 소스폴더로 복사(사용자 배포 시 제거 로직)
		for(String filename : images) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + filename); // 서버에 업로드된 파일
				// if(fileName != null) {
				if(serverFile.exists()) {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:\\Project\\source\\06_jsp\\ch13_fileUpload\\WebContent\\bookimg\\"+filename); // souce폴더에 복사할 파일
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
		}
		// btitle, bprice, bcontent, bdiscount 파라미터값 받아오기
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimg1 = images[1]==null ? "noImg.png":images[1];
		String bimg2 = images[0]==null ? "NOTHING.JPG":images[0];
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		/* String ip = request.getRemoteAddr(); */
		// db에 저장
		BookDto book = new BookDto(0, btitle, bprice, bimg1, bimg2, bcontent, bdiscount,
				null);
		BookDao bDao = BookDao.getinstance();
		int result = bDao.createBook(book);
		if(result == BookDao.SUCCESS) {
			out.print("책등록 성공");
		} else {
			out.print("책등록 실패");
		} 
	
	%>
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