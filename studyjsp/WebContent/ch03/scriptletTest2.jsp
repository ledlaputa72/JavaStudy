<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>스크립트릿 예제 - 로직 사용 </h2>

<%
int varl = 6;
if(varl > 5){
%>
 변수 varl의 값은 5보다 크다 .
 <%} else { %>
 변수 varl의 값은 5보다 작서나 같다.
 <%} %> 

</body>
</html>