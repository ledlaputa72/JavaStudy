<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>구구단 5단 - scriptlet으로</h1><p> 
<%
int i,result;
for(i=1;i<=9;i++){
	result=5*i;
	out.println("<h1> 5 X "+i+" = "+result+"<h1><br>");
}
%>
</body>
</html>