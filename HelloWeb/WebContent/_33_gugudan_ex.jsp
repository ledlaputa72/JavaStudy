<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<p> ������ - scriptlet ��� </p>
	
	<%
	
		for (int i=2; i<=9; i++) {
			
			for (int j=1; j<=9; j++) 
				out.println(i + " x " + j + " = " + i * j + "<br>");
			
			out.println("<br>");
			
		}
	
	%>
	
	<p> �� �ٸ� ��� - expression ��� </p>
	
	<%
	
		for (int i=2; i<=9; i++) {
			
			for (int j=1; j<=9; j++) {
				
	%>
	
				<%= i %> x <%= j %> = <%= i * j %> <br>			
	
	<% 
			}	
	%>
	
			<br>
	
	<% 
		}
	%>
	
</body>
</html>