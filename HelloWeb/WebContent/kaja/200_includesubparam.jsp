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
${param.irum1}�� ${param.irum2}���� ���ϱ⸦ <br>
${ "�̾ȿ� �� �ִ�~~~"}<br>
<hr>
<h2>Scriptlet</h2>
<%
String irum1=request.getParameter("irum1");
String irum2=request.getParameter("irum2");
out.println(irum1 + "�� " + irum2 + "���� ���ϱ⸦ ~~~"+"<br>");
out.println("�̾ȿ� �� �ִ�~~~"+"<br>");
%>
</body>
</html>