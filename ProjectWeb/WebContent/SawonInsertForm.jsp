<%@page import="telinfoVO.TelInfoVO"%>
<%@page import="telinfoDAO.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 입력 폼</title>
</head>
<body>
<h1>사원 추가 폼</h1>
<%
request.setCharacterEncoding("euc-kr");
TelInfoDAO tidao = new TelInfoDAO();
%>
<form action="SawonInsertProcess.jsp" method="post">
<table border=2>
	<tr><td>사번</td><td><input type="text" name="id" ></td></tr>
	<tr><td>이름</td><td><input type="text" name="name"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="tel"></td></tr>
	<tr><td>입사일</td><td><input type="text" name="sDate"></td></tr>
	<tr>
		<td colspan=2><input type="submit" value="입력하자"></td>
	</tr>
</table>

<table border=0>
<tr>
<td><a href="SawonInsertForm.jsp">[입력]</a></td>
<td><a href="SawonAllforUpdate.jsp">[수정]</a></td>
<td><a href="SawonAllforDelete.jsp">[삭제]</a></td>
<td><a href="SawonAllView.jsp">[모두보기]</a></td>
</table>
</body>
</html>