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
		
		���⼭ ������ ��� �ݰ� scope3.jsp �����! <br>
		�̾ WAS ������ scope3.jsp �����
	
	</a>
	
	<%-- null	null	null	applove		, ������ ��� �ݰ� ����� �� --%>
	<%-- null	null	null	null		, was ������ �ٽ� �÷��� �� --%>

</body>
</html>