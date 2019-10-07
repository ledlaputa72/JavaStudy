<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="user.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>회원가입 사이트</title>
</head>
<body>
	<%
		session.invalidate();	
	%>
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>