<%@page import="telinfoVO.TelInfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="telinfoDAO.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ��ü ���</title>
</head>
<body><!-- SawonAllView.jsp -->
<h1>��� ��ü ��� </h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO(); 
//��ü ����(TelInfoDAT Class ���� ��ġ��  Ʋ���Ƿ� ��ü �������� ���) �̸� ���� import �ʿ� 
ArrayList<TelInfoVO> tiArray = tidao.getAllInfo(); //��ü.�޼ҵ� (getAllInfo�� return�� tiArray)
//jsp�� ������ ArrayList tiArray  //DAO�� ������ �ִ� tiArray�� ���� �̸� 
%>

<table border=2>
<tr>
<th>���</th><th>�̸�</th><th>��ȭ��ȣ</th><th>�Ի���</th>
</tr>
<%
for(TelInfoVO imsi : tiArray) {%> <!-- �ڿ������� �ϳ��� ������.  -->
<tr>
<td>	<%=imsi.getId() %></td>
<td>	<%=imsi.getName() %></td>
<td>	<%=imsi.getTel() %></td>
<td>	<%=imsi.getD() %></td>
<% } %>
</tr>
<tr></tr>
</table>

<table border=0>
<tr>
<td><a href="SawonInsertForm.jsp">[�Է�]</a></td>
<td><a href="SawonAllforUpdate.jsp">[����]</a></td>
<td><a href="SawonAllforDelete.jsp">[����]</a></td>
</table>

</body>
</html>