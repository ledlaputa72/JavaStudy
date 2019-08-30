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
		
		// ��û�� �����ų �ٰŰ� �����Ƿ�
		// request.setAttribute("req1", "reqlove");
		out.println((String)request.getAttribute("req1"));  // null
		
		// �������� ��� �����Ƿ�
		// session.setAttribute("ses1", "seslove");
		out.println((String)session.getAttribute("ses1")); // seslove
		
		// WAS��
		// application.setAttribute("app1", "applove");
		out.println((String)application.getAttribute("app1")); // applove	
	
	%>
	<hr>
	
	<!-- EL ǥ���� -->
	${ pageScope.page1 }<br>
	${ requestScope.req1 }<br>
	${ sessionScope.ses1 }<br>
	<!-- out.println((String)session.getAttribute("ses1")); -->
	${ applicationScope.app1 }<br>
	
	<a href="./scope3.jsp">scope3.jsp �� �� ������?</a>
	
</body>
</html>