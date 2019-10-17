<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>자바 스프링 점수 계산 </h2>

<form action="kyesan" method="get">
	<table border="1">
		<tr>
			<th>이름 입력</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>자바 점수 입력</th>
			<td><input type="text" name="javaJumsoo"></td>
		</tr>
		<tr>
			<th>Spring 점수 입력</th>
			<td><input type="text" name="springJumsoo"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="계산하기">
		</tr>
	</table>
</form>
</body>
</html>