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
	
		// pageContext.setAttribute("page1", "pagelove");
		out.println((String)pageContext.getAttribute("page1")); 

		// request.setAttribute("req1", "reqlove");
		out.println((String)request.getAttribute("req1"));  

		// session.setAttribute("ses1", "seslove");
		out.println((String)session.getAttribute("ses1")); 

		// application.setAttribute("app1", "applove");
		out.println((String)application.getAttribute("app1"));
	
	%>
	
	<a href="./scope3.jsp">
		
		여기서 브라우저 모두 닫고 scope3.jsp 재수행! <br>
		이어서 WAS 내리고 scope3.jsp 재수행
	
	</a>
	
	<%-- null	null	null	applove		, 브라우저 모두 닫고 재수행 시 --%>
	<%-- null	null	null	null		, was 내리고 다시 올렸을 때 --%>

</body>
</html>