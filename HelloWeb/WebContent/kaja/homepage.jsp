<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String sirum=(String)session.getAttribute("sirum");
String stel=(String)session.getAttribute("stel");
out.println(sirum+"님!!!!"+"<br>");
out.println("홈페이지에 오신걸 환영합니다."+"<br>");
out.println("전화번호는 "+stel+"이시군요. <br>");
%>
<hr>
${sessionScope.sirum } 님 !!!! <br> 
홈페이지에 오신걸 환영합니다. <br>
전화번호는 ${sessionScope.stel}이시군요 <br>
</body>
</html>