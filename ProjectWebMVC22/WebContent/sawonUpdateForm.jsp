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
<h1>��� �Ѹ� ���� </h1>
<hr>
<form action="tollUpadate.do?sname=${stv.name }" method="get">
<table border=1>
	<tr>
		<td>���</td><td>�̸�</td><td>��ȭ��ȣ</td><td>�Ի���</td>
	</tr>
	<tr>
		<td><input type="text" value="${stv.id }" name="id"></td>
		<td><input type="text" value="${stv.name }" name="name"></td>
		<td><input type="text" value="${stv.tel }" name="tel"></td>
		<td><input type="text" value="${stv.d }" name="d"></td>
		<td><input type="hidden" value="${stv.name }" name="sname"></td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="submit" value="����" >
			<input type="reset" value="���" >
		</td>
	</tr>
</table>
</form><br>
<a href="${pageContext.request.contextPath}/getAllInfo.jsp">��κ���</a> <!-- WebContent �������� �ּ� ���/ -->
<a href="tellDelete.do?name=${stv.name }"?>����</a>
</body>
</html>