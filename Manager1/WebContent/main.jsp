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
	
	<h1> <%= session.getAttribute("sid") %> 님의 메인 화면</h1>
	
	<table border="0">
	
		<tr>
			<td> <a href="sawonGetAllTelinfo.jsp">[모두 보기]</a> </td>
			<td> <a href="myPage.do?id=${ mLogin.id }">[내 정보 보기]</a> </td>
			<td> <a href="logout.do">[로그아웃]</a>
			<td> <a href="deleteAccount.do?id=${ mLogin.id }">[회원 탈퇴]</a> </td>
		</tr>	
	
	</table>
	
</body>
</html>