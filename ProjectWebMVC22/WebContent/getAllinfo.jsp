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

<table border="1">	
	<tr>		
		<td colspan="4">			
		<form action="getAllinfo.do">				
			<!-- business logic 처리하러 서블릿으로 이동 -->
			<input type="submit" value="모두 보기">					
		</form>
		</td>			
	</tr>		
	
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>전화</td>
		<td>입사일</td>
	</tr>		
	<!-- java의 for : 같은것 -->
	<c:forEach var="vo1" items="${alist1 }">		
		<tr>
		<td> ${ vo1.id } </td>
		<td> <a href="telSearchOne.do?name=${ vo1.name }">${ vo1.name }</a> </td>
		<td> ${ vo1.tel } </td>
		<td> ${ vo1.d } </td>
		</tr>			
	</c:forEach>	
	
</table>

<a href="SawonInsertForm.jsp">[입력]</a>
<a href="getAllInfo.jsp">[모두보기]</a>
</body>
</html>