<%@page import="telinfoVO.TelInfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="telinfoDAO.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 전체 명단</title>
</head>
<body><!-- SawonAllView.jsp -->
<h1>사원 전체 명단 </h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO(); 
//객체 생성(TelInfoDAT Class 폴더 위치가  틀리므로 객체 생성으로 사용) 이를 위해 import 필요 
ArrayList<TelInfoVO> tiArray = tidao.getAllInfo(); //객체.메소드 (getAllInfo의 return이 tiArray)
//jsp가 생성한 ArrayList tiArray  //DAO가 가지고 있는 tiArray로 같은 이름 
%>

<table border=2>
<tr>
<th>사번</th><th>이름</th><th>전화번호</th><th>입사일</th>
</tr>
<%
for(TelInfoVO imsi : tiArray) {%> <!-- 뒤에서부터 하나씩 꺼낸다.  -->
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
<td><a href="SawonInsertForm.jsp">[입력]</a></td>
<td><a href="SawonAllforUpdate.jsp">[수정]</a></td>
<td><a href="SawonAllforDelete.jsp">[삭제]</a></td>
</table>

</body>
</html>