<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<pre>
원래는 이화면이 출력되는 것인데
변신을 해서 다른 화면이 출력된다.
</pre>
<%
	response.sendRedirect("ddokaja1.jsp"); //방향을 바꾼다.
%>
</body>
</html>