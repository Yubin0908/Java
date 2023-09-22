<%@page import="java.util.Arrays"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024*5; // Maxi. 5Meg
		String[] fileNames = {"","",""};
		String[] orgFileNames = {"","",""};
		String name = ""; int age = 0;
		try {
			MultipartRequest mrs = new MultipartRequest(request, path, maxSize, "utf-8",
														 new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mrs.getFileNames();
			int idx = 0;
			while(paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();  // Parameter name
				fileNames[idx] = mrs.getFilesystemName(param); // Parameter Save name
				orgFileNames[idx] = mrs.getOriginalFileName(param); // Parameter Original name
				System.out.println(idx + "번째 파라미터 : " + param + ", 서버에 저장된 파일 : " + fileNames[idx] + ", 첨부한 오리지널 파일이름 : " + orgFileNames[idx]);
				idx++;
				
			}
			name = mrs.getParameter("name");
			age = Integer.parseInt(mrs.getParameter("age"));
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// file copy
		for(String file : fileNames) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + fileNames); // 서버에 업로드된 파일
				// if(fileName != null) {
				if(serverFile.exists()) {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:\\Project\\source\\06_jsp\\ch13_fileUpload\\WebContent\\fileUpFolder\\"+fileNames); // souce폴더에 복사할 파일
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
	<%=Arrays.toString(fileNames) %>
	<hr>
	<%=Arrays.toString(orgFileNames) %>
	<hr>
	0번째 첨부
	<%=path %>/fileUpFolder/<%=fileNames[2] %>
	<%if(fileNames[2] != null) { %>
		<img src="<%=conPath %>/fileUpFolder/<%=fileNames[2] %>">
	<% } %>
	<hr>
	1번째 첨부
	<%=path %>/fileUpFolder/<%=fileNames[1] %>
	<%if(fileNames[1] != null) { %>
		<img src="<%=conPath %>/fileUpFolder/<%=fileNames[1] %>">
	<% } %>
	<hr>
	2번째 첨부
	<%=path %>/fileUpFolder/<%=fileNames[0] %>
	<%if(fileNames[0] != null) { %>
		<img src="<%=conPath %>/fileUpFolder/<%=fileNames[0] %>">
	<% } %>
	<hr>
	이름 : <%=name %> /
	나이 : <%=age %>
</body>
</html>