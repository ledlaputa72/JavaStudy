<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>나는 로그인 받는 서버</h2>
	
	<%
	
		// http://url?id1=...&pw1=...
	
		// request 내장 객체
		String id1 = request.getParameter("id1");
		String pw1 = request.getParameter("pw1");
		int na2 = Integer.parseInt(request.getParameter("na2"));
	
	%>
	
	아이디는 <%= id1 %> 이고, 암호는 <%= pw1 %> 이구만~ <p>
	그리고 <%= 2019 - na2 %> 년생이고, 나이는 <%= na2 %> 살이구만~ <p>

</body>
</html>