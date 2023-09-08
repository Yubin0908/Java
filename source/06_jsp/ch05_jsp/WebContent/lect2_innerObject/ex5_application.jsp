<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String conPath = request.getContextPath();
		String appPath = application.getContextPath();
		String absolutePath = application.getRealPath("."); // 현재 실행되는 경로
	%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
	<%
	/*	String filePath = application.getRealPath("txt/test.txt");
		out.println(filePath + "의 내용입니다.<br>");
		// 1. 스트림 생성(파일을 연다. 기본스트림 -> 보조스트림)
		// 2. 파일 읽어 출력   3. 스트림 닫음.
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(filePath); // 기본스트림 생성
			br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 생성

			while (true) { // Data Read (br.readLine())

				String linedata = br.readLine();

				if (linedata == null)
					break;
				out.println(linedata + "<br>");
				System.out.println(linedata);
			}
			out.println(" = = 파일 끝 = = ");
			System.out.println(" = = 파일 끝 = = ");

		} catch (IOException e) { // FileReader(), BufferedReader(), br.readLIne()

			System.out.println(e.getMessage());

		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();

			} catch (IOException e) { // close()

				System.out.println(e.getMessage());
			}

		} */
		String filePath = application.getRealPath("txt/test.txt");
		out.println(filePath + "의 내용입니다.<br>");
		Reader reader = new FileReader(filePath); // 기본스트림 생성
		BufferedReader br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 생성

		while (true) { // Data Read (br.readLine())

			String linedata = br.readLine();

			if (linedata == null)
				break;
			out.println(linedata + "<br>");
			System.out.println(linedata);
		}
		out.println(" = = 파일 끝 = = ");
		System.out.println(" = = 파일 끝 = = ");
		br.close();
		reader.close();
	%>
</body>
</html>