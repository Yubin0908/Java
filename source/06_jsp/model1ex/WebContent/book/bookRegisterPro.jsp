
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
					os = new FileOutputStream("D:\\Project\\source\\06_jsp\\model1ex\\WebContent\\bookimg\\"+filename); // souce폴더에 복사할 파일
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
	%>
	 <script>
	 	alert('책등록이 완료되었습니다.');
	 	location.href = "<%=conPath%>/book/bookRegister.jsp";
	 </script>
		
</body>
</html>