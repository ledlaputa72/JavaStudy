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

	<h1>�� ���� ����</h1>
	
	<hr>
	
	<form action="updateMyPage.do?sid=${ mMyInfo.id }" method="post">
	
		<table border="2">
		
			<tr>
				<td>ID</td>
				<td> <input type="text" name="id" value="${ mMyInfo.id }"> </td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> <input type="text" name="pwd" value="${ mMyInfo.pwd }"> </td>
			</tr>
			
			<input type="hidden" name="sid" value="${ mMyInfo.id }">
			
			<tr>
				<td colspan="2"> <input type="submit" value="����"> </td>
			</tr>
			
			<table border="0">
		
				<tr>
					<td> <a href="deleteAccount.do?id=${ mMyInfo.id }">[ȸ�� Ż��]</a> </td>
					<td> <a href="javascript:history.back()">[���� ȭ������]</a> </td>
				</tr>	
		
			</table>		
			
		</table>
	
	</form>

</body>
</html>