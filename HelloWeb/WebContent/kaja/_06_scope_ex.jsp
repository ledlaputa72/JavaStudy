<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	
		// 저장scope.저장메소드("속성명", "속성값")
	
		pageContext.setAttribute("page1", "pagelove"); // 페이지 범위
		request.setAttribute("req1", "reqlove"); // 요청
		session.setAttribute("ses1", "seslove"); // 브라우저 살아있는 동안
		application.setAttribute("app1", "applove"); // WAS
	
	%>
	
	<a href="./scope2.jsp">scope2.jsp 로 한번 가볼까?</a>

</body>
</html>