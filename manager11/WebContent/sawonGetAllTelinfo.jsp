<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 전체 보기 </h1><hr>
<table border="1">
	<tr><td colspan="4">
		<form action="getAllTelinfo.do">
			<input type="submit" value="모두보기">
		</form>
	</td></tr>
	<!-- controller 갔다가 business logic 처리한 다음 다시 출발한 곳으로 온다.  -->
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>전화번호</td>
	</tr>
	
	<!-- java의 for : 같은거  -->
	<c:forEach var="alltelinfo1" items="${mAllTelinfo }">
		<tr><td>${alltelinfo1.id }</td>
			<%-- <td>${vo1.name}</td> --%>
			<td><a href="getTelinfo.do?name=${alltelinfo1.name}">${alltelinfo1.name}</a>
			<td>${alltelinfo1.tel}</td>
		</tr>	
	</c:forEach>
	<table border="0">
		<tr>
			<td><a href="sawonInsertTelinfo.jsp">[입력]</a></td>
			<td><a href="getAllTelinfo.do">[모두보기]</a></td>
		</tr>
	</table>
</table>

</body>
</html>