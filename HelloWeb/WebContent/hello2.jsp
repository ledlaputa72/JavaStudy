<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	어서오세요~
	
	<%
		int aa = 30;
		out.println("good!!!");
	%>
	
</body>
</html>

<%--  
	jsp (Java Server Page)
	
	원래 서버 언어 servlet (applet)		hamlet	john
	
	servlet : java + html
		out.println("<html></html><body>have a nice day!!!</body>")
		
	jsp : html + java
		<body>
			<%
				int aa = 30;
			%>
		</body>
--%>