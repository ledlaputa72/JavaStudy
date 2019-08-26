<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="naerrorpage.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int na2Soo1 = Integer.parseInt(request.getParameter("na2")); //입력이 문자 이므로 
out.println("나이는 "+na2Soo1); //나이를 입력안하면 에러발생하고 naerrorpage로 간다. 
%>
</body>
</html>