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

	<h1>��� ���� �Է�</h1>
	
	<hr>
	
	<form action="insertTelinfo.do" method="post">
	
		<table border="2">
		
			<tr>
				<td>���</td>
				<td> <input type="text" name="id"> </td>
			</tr>
			
			<tr>
				<td>�̸�</td>
				<td> <input type="text" name="name"> </td>
			</tr>
			
			<tr>
				<td>��ȭ��ȣ</td>
				<td> <input type="text" name="tel"> </td>
			</tr>			
			
			<tr>
				<td colspan="2"> <input type="submit" value="�Է�"> </td>
			</tr>
			
			<table border="0">
		
				<tr>
					<td> <a href="getAllTelinfo.do">[��� ����]</a> </td>
				</tr>	
		
			</table>		
			
		</table>
	
	</form>

</body>
</html>