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

<table border="1">	
	<tr>		
		<td colspan="4">			
		<form action="getAllinfo.do">				
			<!-- business logic ó���Ϸ� �������� �̵� -->
			<input type="submit" value="��� ����">					
		</form>
		</td>			
	</tr>		
	
	<tr>
		<td>���</td>
		<td>�̸�</td>
		<td>��ȭ</td>
		<td>�Ի���</td>
	</tr>		
	<!-- java�� for : ������ -->
	<c:forEach var="vo1" items="${alist1 }">		
		<tr>
		<td> ${ vo1.id } </td>
		<td> <a href="telSearchOne.do?name=${ vo1.name }">${ vo1.name }</a> </td>
		<td> ${ vo1.tel } </td>
		<td> ${ vo1.d } </td>
		</tr>			
	</c:forEach>	
	
</table>

<a href="SawonInsertForm.jsp">[�Է�]</a>
<a href="getAllInfo.jsp">[��κ���]</a>
</body>
</html>