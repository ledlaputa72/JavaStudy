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

	<h1>ȸ������</h1>
	
	<hr>
	
	<form action="signUp.do" method="post">
	
		<table border="2">
		
			<tr>
				<td>ID</td>
				<td> <input type="text" name="id"> </td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> <input type="password" name="pwd"> </td>
			</tr>
			
			<tr>
				<td colspan="2"> <input type="submit" value="ȸ������"> </td>
			</tr>
			
			<table border="0">
		
				<tr>
					<td> <a href="loginForm.jsp">[�α��� ȭ������]</a> </td>
				</tr>	
		
			</table>		
			
		</table>
	
	</form>

</body>
</html>