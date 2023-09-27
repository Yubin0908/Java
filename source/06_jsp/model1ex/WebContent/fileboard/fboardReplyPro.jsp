<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
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
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*3;
		String filename= "";
		MultipartRequest mrs = null;
		try {
			mrs = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mrs.getFileNames();
				String param = params.nextElement();
				filename = mrs.getFilesystemName(param);
		} catch (Exception e) {
			System.out.println("Get : "+ e.getMessage());
		}
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path+"/"+filename);
			if(serverFile.exists()){
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Project/source/06_jsp/model1ex/WebContent/fileboardUpload/"+filename);
				byte[] bs = new byte[(int)serverFile.length()];
				int readByteCnt;
				while((readByteCnt=is.read(bs))!=-1){
					os.write(bs, 0, readByteCnt);
				}
			}
		}catch(IOException e){
			System.out.println("Save : " + e.getMessage());
		}finally{
			if(is!=null) is.close();
			if(os!=null) os.close();
		}
		
		String pageNum = mrs.getParameter("pageNum");
		int fid = Integer.parseInt(mrs.getParameter("fid"));
		int fgroup = Integer.parseInt(mrs.getParameter("fgroup"));
		int fstep = Integer.parseInt(mrs.getParameter("fstep"));
		int findent = Integer.parseInt(mrs.getParameter("findent"));
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid();
		System.out.println(cid);
		String ftitle = mrs.getParameter("ftitle");
		String fcontent = mrs.getParameter("fcontent");
		String fpw = mrs.getParameter("fpw");
		String fip = request.getRemoteAddr();
		FileBoardDto fDto = new FileBoardDto(fid, cid, ftitle, fcontent, filename, 0, fpw, fgroup,
											fstep, findent, fip, null, null, null);
		FileBoardDao fDao = FileBoardDao.getinstance();
		int result = fDao.replyBoard(fDto);
		if(result == FileBoardDao.PASS) {
	%>	
		<script>
			alert('답변글 작성 완료');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
		</script>	
	<%	
		}
	%>
</body>
</html>