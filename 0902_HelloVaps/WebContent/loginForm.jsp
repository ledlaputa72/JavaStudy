<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로그인</title>
	<style type="text/css">
	
	.login_logo{
	background-size : contain;
 	background-image : url("./img/top3.png");
 	background-position : cneter; /* resize시 그림 가운가 보이게  */
	width : 400px;
	height: 100px;
	margin: auto;	
	}
	
	.login_form{
	background-size : contain;
 	background-image : url("./img/contents_bg2.jpg");
 	background-position : cneter; /* resize시 그림 가운가 보이게  */
	width : 400px;
	height: 400px;
	margin: auto;	
	}
	
	#input_table{
	position : relative;
	top : 50px;
	padding : 10px;
	margin: auto;	
	}
	</style>
	<script>

		function goSignUpForm() {
		
			location.href = "signUpForm.jsp";
		
		}
	
	</script>
</head>
<body  background="./img/woodBg.png">

<form action="login.do" method="post">
	<div class="login_logo">
	</div>	
	<div class="login_form" clearfix>
		<table border="0" id="input_table">
			<tr>
				<td colspan="2"><h2>회원 로그인</h2></td>
			</tr>
			<tr>
				<td>ID</td>
				<td> <input type="text" name="id"> </td>
			</tr>
			<tr>
				<td colspan="2"><br></td>
			</tr>
			<tr>
				<td>Password</td>
				<td> <input type="password" name="pw"> </td>
			</tr>
			<tr>
				<td colspan="2"><br></td>
			</tr>
			<tr>
				<td> <input type="submit" value="LOGIN"> </td>
				<td> <input type="button" value="회원가입" onclick="goSignUpForm()"> </td>
			</tr>			
		
		</table>
	</div>	
</form>


	<%
	
		String msg = (String)request.getAttribute("msg");
	
	
	%>
	
	<%-- <h1> <%= msg %> </h1> --%>

</body>
</html>