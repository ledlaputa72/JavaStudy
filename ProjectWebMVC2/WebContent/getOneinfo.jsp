<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>�θ� ���</h1>
<form action="Telupdate">
<table border="1" style="border-collapse: collapse;">
	<tr><th>���</th><th>�̸�</th><th>��ȭ��ȣ</th><th>�Ի���</th></tr>
	<tr><td><input type="text" value="${tv1.id }" name="id"></td>
		<td><input type="text" value="${tv1.name }" name="name"></td>
		<td><input type="text" value="${tv1.tel }" name="tel"></td>
		<td><input type="text" value="${tv1.d }" name="d"></td>
	</tr>
	<tr><td colspan="4">
	<input type="submit" value="${tv1.name }" name="name2">
	</td></tr>
</table>
</form>
<a href="Telallview">[��κ���]</a>
<a href="TelDelete?name=${tv1.name}">[����]</a>
</body>
</html>