<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> <%= session.getAttribute("sessid") %> 님의 마이 페이지</h1>
	
	<hr>
	
	<form action="myPageUpdate.do?id=${ svv.id }" method="post">
	
		<table border="1">
		
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>전화번호</td>
			</tr>
			
			<tr>
				<td> ${ svv.id } </td>
				<td> ${ svv.pw } </td>
				<td> ${ svv.name } </td>
				<td> ${ svv.email } </td>
				<td> ${ svv.tel } </td>
				<input type="hidden" value="${ svv.id }" name="id">
			</tr>
			
			<tr>
				<td colspan="5">
					<input type="submit" value="수정 화면으로">
					<input type="button" value="메인으로" onclick="history.back()">
				</td>
			</tr>			
		
		</table>
	
	</form>
	
	<br>
	
</body>
</html>