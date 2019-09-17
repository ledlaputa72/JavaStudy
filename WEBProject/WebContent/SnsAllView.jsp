<%@page import="snsVO.SnsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="svsDAO.SnsDAO"%>
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
	response.setCharacterEncoding("euc-kr");
	
	SnsDAO sdao = new SnsDAO();
	ArrayList<SnsVO> sArray = sdao.SnsAllView();
%>

<table border="2">
  <tr>
    <th>이름</th>
    <th>sns 내용</th>
  </tr>
  <% for(SnsVO imsi : sArray) {%>
  <tr>
    <td><%= imsi.getName() %></td>
    <td><%= imsi.getSns() %></td>
    <% } %>
  </tr>
</table>

</body>
</html>