<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h1> <%= session.getAttribute("sid") %> ���� ���� ȭ��</h1>
	
	<table border="0">
	
		<tr>
			<td> <a href="sawonGetAllTelinfo.jsp">[��� ����]</a> </td>
			<td> <a href="myPage.do?id=${ mLogin.id }">[�� ���� ����]</a> </td>
			<td> <a href="logout.do">[�α׾ƿ�]</a>
			<td> <a href="deleteAccount.do?id=${ mLogin.id }">[ȸ�� Ż��]</a> </td>
		</tr>	
	
	</table>
	
</body>
</html>