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

String name=request.getParameter("name"); //'홍길동"

boolean b1 = tidao.delete_nametel(name); // name
if(b1)
	response.sendRedirect("SawonAllView.jsp");
else {%>
<a href="SawonDeleteForm.jsp">사원 삭제 에러 - 수정 화면으로 </a>
<% } %>
</body>
</html>