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
	String[] kwail = {"���", "��", "��"};
	session.setAttribute("kwail", kwail);
	/* kwail�̶�� �Ӽ����� ���� ���â�� kwail�迭�� �־�� */
%>
	<a href=300_foreachkaja.jsp"">
	����3 - �ϴ� foreach������ for(:)�� ���</a>
</body>
</html>