<%@page import="telinfoDAO.TelInfoDAO"%>
<%@ page import = "java.sql.Date" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>사원 추가</h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();

int id=Integer.parseInt(request.getParameter("id")); //id
String name=request.getParameter("name"); //"홍길동"
String tel=request.getParameter("tel"); //010-777-8888
String sDate=request.getParameter("sDate"); //date

boolean b1 = tidao.insert_nametel(id,name,tel,sDate); //1)
if(b1)
	response.sendRedirect("SawonAllView.jsp");
else {%>
<a href="SawonInsertForm.jsp">사원 수정 에러 - 수정 화면으로 </a>
<% } %>
</body>
</html>