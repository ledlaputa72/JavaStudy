<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>��� ��ü ���� </h1><hr>
<table border="1">
	<tr><td colspan="4">
		<form action="getAllTelinfo.do">
			<input type="submit" value="��κ���">
		</form>
	</td></tr>
	<!-- controller ���ٰ� business logic ó���� ���� �ٽ� ����� ������ �´�.  -->
	<tr>
		<td>���</td>
		<td>�̸�</td>
		<td>��ȭ��ȣ</td>
	</tr>
	
	<!-- java�� for : ������  -->
	<c:forEach var="alltelinfo1" items="${mAllTelinfo }">
		<tr><td>${alltelinfo1.id }</td>
			<%-- <td>${vo1.name}</td> --%>
			<td><a href="getTelinfo.do?name=${alltelinfo1.name}">${alltelinfo1.name}</a>
			<td>${alltelinfo1.tel}</td>
		</tr>	
	</c:forEach>
	<table border="0">
		<tr>
			<td><a href="sawonInsertTelinfo.jsp">[�Է�]</a></td>
			<td><a href="getAllTelinfo.do">[��κ���]</a></td>
		</tr>
	</table>
</table>

</body>
</html>