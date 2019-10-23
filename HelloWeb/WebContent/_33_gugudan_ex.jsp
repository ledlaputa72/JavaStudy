<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<p> 구구단 - scriptlet 방식 </p>
	
	<%
	
		for (int i=2; i<=9; i++) {
			
			for (int j=1; j<=9; j++) 
				out.println(i + " x " + j + " = " + i * j + "<br>");
			
			out.println("<br>");
			
		}
	
	%>
	
	<p> 또 다른 방법 - expression 방식 </p>
	
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