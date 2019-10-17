<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>사원 한명 보기 </h1>
<hr>
<form action="tollUpadate.do?sname=${stv.name }" method="get">
<table border=1>
	<tr>
		<td>사번</td><td>이름</td><td>전화번호</td><td>입사일</td>
	</tr>
	<tr>
		<td><input type="text" value="${stv.id }" name="id"></td>
		<td><input type="text" value="${stv.name }" name="name"></td>
		<td><input type="text" value="${stv.tel }" name="tel"></td>
		<td><input type="text" value="${stv.d }" name="d"></td>
		<td><input type="hidden" value="${stv.name }" name="sname"></td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="submit" value="수정" >
			<input type="reset" value="취소" >
		</td>
	</tr>
</table>
</form><br>
<a href="${pageContext.request.contextPath}/getAllInfo.jsp">모두보기</a> <!-- WebContent 폴더까지 주소 경로/ -->
<a href="tellDelete.do?name=${stv.name }"?>삭제</a>
</body>
</html>