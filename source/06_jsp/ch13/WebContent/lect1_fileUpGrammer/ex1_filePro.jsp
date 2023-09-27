<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String path = request.getRealPath("fileUpFolder"); // 첨부파일이 저장될 서버의 폴더
		// out.println(path);
		int maxSize = 1024 * 1024 * 10; // Max_Size : 10 Meg
		String fileName = "";
		String orgFileName = "";
		try {
			MultipartRequest mrs = new MultipartRequest(request, path, maxSize, "utf-8");
														// new DefaultFileRenamePolicy()); 
			// new DefaultFileRenamePolicy() 역할 : 같은 파일을 첨부할 경우, 파일명 새로생성
			Enumeration<String> paramNames = mrs.getFileNames(); // file첨부한 파라미터 이름들
			while(paramNames.hasMoreElements()) {
				String param = paramNames.nextElement(); // param="file"
				fileName = mrs.getFilesystemName(param); // 파라미터로 서버에 저장된 파일이름
				orgFileName = mrs.getOriginalFileName(param); // 파라미터에 첨부한 원본 파일이름
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// 서버에 업로드 한 후 소스폴더로 파일 copy (path > source)
		InputStream is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + fileName); // 서버에 업로드된 파일
			// if(fileName != null) {
			if(serverFile.exists()) {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Project\\source\\06_jsp\\ch13_fileUpload\\WebContent\\fileUpFolder\\"+fileName); // souce폴더에 복사할 파일
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
					
				}
				System.out.println("서버에 업로드 한 파일을 소스 폴더로 복사 완료.");
			} else {
				System.out.println("첨부 파일이 없어서 복사 안 함.");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os!=null) os.close();
			if(is!=null) is.close();
		} // 서버에 업로드 된 파일을 소스폴더로 복사
		if(fileName!=null) {
	%>
		<h3>첨부한 오리지널 파일이름 : <%=orgFileName %></h3>
		<h3>서버에 업로드된 파일이름 : <%=fileName %></h3>
		<img src="<%=conPath %>/fileUpFolder/<%=fileName %>" alt="업로드파일">
	
	<%
		} else {
	%>
		<h3>첨부 안함</h3>
		<h3>첨부한 오리지널 파일이름 : <%=orgFileName %></h3>
		<h3>서버에 업로드된 파일이름 : <%=fileName %></h3>
	<%		
		}
	%>		

</body>
</html>