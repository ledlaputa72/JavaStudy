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
<h1>삭제할 이름 선택 </h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();
ArrayList<TelInfoVO> tiArray = tidao.getAllInfo();
%>

<table border=2>
<tr>
<th>사번</th><th>이름</th><th>전화번호</th><th>입사일</th>
</tr>
<%
for(TelInfoVO imsi : tiArray) {%> <!-- 뒤에서부터 하나씩 꺼낸다.  -->
<tr>
<td>   <%=imsi.getId() %></td>
<td>   
<a href="SawonDeleteForm.jsp?name=<%=imsi.getName() %>"><%=imsi.getName() %></a></td> 
                          <!-- ?는 get방식으로 보낼때 화면URL에 name=value로 나오는 형식  -->
<td>   <%=imsi.getTel() %></td>
<td>   <%=imsi.getD() %></td>
<% } %>
</tr>
<tr></tr>
</table>

<table border=0>
<tr>
<td><a href="SawonInsertForm.jsp">[입력]</a></td>
<td><a href="SawonAllforUpdate.jsp">[수정]</a></td>
<td>[삭제]</td>
</table>
</body>
</html>