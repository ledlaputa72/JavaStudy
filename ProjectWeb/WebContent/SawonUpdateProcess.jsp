<%@page import="telinfoDAO.TelInfoDAO"%>
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
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();

String name=request.getParameter("name"); //'ȫ�浿"
String tel=request.getParameter("tel"); //010-777-8888

boolean b1 = tidao.update_nametel(tel,name); //tel, name
if(b1)
	response.sendRedirect("SawonAllView.jsp");
else {%>
<a href="SawonUpdateForm.jsp">��� ���� ���� - ���� ȭ������ </a>
<% } %>
</body>
</html>