<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>EL</h2>
${param.irum1}가 ${param.irum2}에게 말하기를 <br>
${ "이안에 너 있다~~~"}<br>
<hr>
<h2>Scriptlet</h2>
<%
String irum1=request.getParameter("irum1");
String irum2=request.getParameter("irum2");
out.println(irum1 + "가 " + irum2 + "에게 말하기를 ~~~"+"<br>");
out.println("이안에 너 있다~~~"+"<br>");
%>
</body>
</html>