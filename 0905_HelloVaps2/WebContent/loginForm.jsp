<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>

	<script>

		function goSignUpForm() {
		
			location.href = "signUpForm.jsp";
		
		}
	
	</script>
</head>
<body>

	<%
	
		// 로그인되어 있지 않을 때
		if (session.getAttribute("sessid") == null) {
			
	%>

	<form action="login.do" method="post">
	
		<table border="0">
		
			<tr>
				<td>ID</td>
				<td> <input type="text" name="id"> </td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> <input type="password" name="pw"> </td>
			</tr>
			
			<tr>
				<td> <input type="submit" value="LOGIN"> </td>
				<td> <input type="button" value="회원가입" onclick="goSignUpForm()"> </td>
			</tr>			
		
		</table>
	
	</form>
	
	<%
	
		}
	
/* 		// 로그인되었을 때
		else { */
			
	%>
	
		
	<% 		
	
		String msg = (String)request.getAttribute("msg");
	
	%>
	
	<%-- <h1> <%= msg %> </h1> --%>

</body>
</html>