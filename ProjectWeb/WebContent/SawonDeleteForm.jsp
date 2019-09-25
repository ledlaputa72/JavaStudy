<%@page import="telinfoVO.TelInfoVO"%>
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
<h1>사원 삭제 폼</h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();
String oriName=request.getParameter("name"); //<a>태그 선택한것 name="홍길동"
TelInfoVO tv2 = tidao.search_nametel(oriName); //oriName="홍길동"
							//메소드 찾아갈때 "홍길동"을 인자로 
%>
<form action="SawonDeleteProcess.jsp" method="post">
<table border=2>
	<tr>
		<th>사번</th><th>이름</th><th>전화번호</th><th>입사일</th>
	</tr>
	<tr>
		<td><%=tv2.getId()%></td>
		<td><input type="text" name="name" value=<%=tv2.getName() %>></td>
		<td><%=tv2.getTel()%></td>
		<td><%=tv2.getD()%></td>
	</tr>
	<tr>
		<td colspan=4><input type="submit" value="삭제하자"></td>
	</tr>
</table>

<table border=0>
<tr>
<td><a href="SawonInsertForm.jsp">[입력]</a></td>
<td><a href="SawonAllforUpdate.jsp">[수정]</a></td>
<td><a href="SawonAllforDelete.jsp">[삭제]</a></td>
</table>
</body>
</html>