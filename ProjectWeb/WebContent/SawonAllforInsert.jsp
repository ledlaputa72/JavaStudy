<%@page import="telinfoDAO.TelInfoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="telinfoVO.TelInfoVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>ȸ���� ���� </h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();
ArrayList<TelInfoVO> tiArray = tidao.getAllInfo();
%>

<table border=2>
<tr>
<th>���</th><th>�̸�</th><th>��ȭ��ȣ</th><th>�Ի���</th>
</tr>
<%
for(TelInfoVO imsi : tiArray) {%> <!-- �ڿ������� �ϳ��� ������.  -->
<tr>
<td>   <%=imsi.getId() %></td>
<td>   
<a href="SawonInsertForm.jsp?name=<%=imsi.getName() %>"><%=imsi.getName() %></a></td> 
                          <!-- ?�� get������� ������ ȭ��URL�� name=value�� ������ ����  -->
<td>   <%=imsi.getTel() %></td>
<td>   <%=imsi.getD() %></td>
<% } %>
</tr>
<tr></tr>
</table>

<table border=0>
<tr>
<td>[�Է�]</td>
<td><a href="SawonAllforUpdate.jsp">[����]</a></td>
<td><a href="SawonAllforDelete.jsp">[����]</a></td>
</table>
</body>
</html>