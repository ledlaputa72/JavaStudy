<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로그인</title>

	<script>

		function goSignUpForm() {
		
			location.href = "signUpForm.jsp";
		
		}
	
	</script>
</head>
<body>

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
	
		String msg = (String)request.getAttribute("msg");
	
	%>
	
	<%-- <h1> <%= msg %> </h1> --%>
	
	<script>
		
		<%-- if (<%=msg%> != null) --%>
			<%-- alert('<%=msg%>'); --%>
	
	</script>
	
</body>
</html>