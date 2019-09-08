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
	
		 // return Type : Object -> String
		// pageContext.setAttribute("page1", "pagelove");
		out.println((String)pageContext.getAttribute("page1")); // null
		
		// 요청을 연결시킬 근거가 없으므로
		// request.setAttribute("req1", "reqlove");
		out.println((String)request.getAttribute("req1"));  // null
		
		// 브라우저가 살아 있으므로
		// session.setAttribute("ses1", "seslove");
		out.println((String)session.getAttribute("ses1")); // seslove
		
		// WAS도
		// application.setAttribute("app1", "applove");
		out.println((String)application.getAttribute("app1")); // applove	
	
	%>
	<hr>
	
	<!-- EL 표현식 -->
	${ pageScope.page1 }<br>
	${ requestScope.req1 }<br>
	${ sessionScope.ses1 }<br>
	<!-- out.println((String)session.getAttribute("ses1")); -->
	${ applicationScope.app1 }<br>
	
	<a href="./scope3.jsp">scope3.jsp 한 번 가볼까?</a>
	
</body>
</html>