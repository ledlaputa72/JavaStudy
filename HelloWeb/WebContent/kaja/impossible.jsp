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
out.println("<h2>��� ��� ������</h2><br><hr>");
out.println(sirum+"��!!!!"+"<br>");
out.println("Ȩ�������� ���Ű� ȯ���մϴ�."+"<br>");
out.println("��ȭ��ȣ�� "+stel+"�̽ñ���. <br>");
out.println("����� ��� ��� �̽ñ���. <br>");
%>
<hr>
<h2>��п�� ������</h2><br>
${sessionScope.sirum } �� !!!! <br> 
Ȩ�������� ���Ű� ȯ���մϴ�. <br>
��ȭ��ȣ�� ${sessionScope.stel}�̽ñ��� <br>
</body>
</html>