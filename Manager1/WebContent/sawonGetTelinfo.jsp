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

	<h1>��� �� �� ����</h1>
	
	<hr>
	
	<form action="updateTelinfo.do" method="post">
	
		<table border="2">
		
			<tr>
				<td>���</td>
				<td> <input type="text" name="id" value="${ mTelinfo.id }"> </td>
			</tr>
			
			<tr>
				<td>�̸�</td>
				<td> <input type="text" name="name" value="${ mTelinfo.name }"> </td>
			</tr>
			
			<tr>
				<td>��ȭ��ȣ</td>
				<td> <input type="text" name="tel" value="${ mTelinfo.tel }"> </td>
			</tr>			
			
			<input type="hidden" name="name2" value="${ mTelinfo.name }">
			
			<tr>
				<td colspan="2"> <input type="submit" value="����"> </td>
			</tr>
			
			<table border="0">
		
				<tr>
					<td> <a href="deleteTelinfo.do?name=${ mTelinfo.name }">[����]</a> </td>
					<td> <a href="getAllTelinfo.do">[��� ����]</a> </td>
				</tr>	
		
			</table>		
			
		</table>
	
	</form>

</body>
</html>