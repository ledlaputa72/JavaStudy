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
	
		// ����scope.����޼ҵ�("�Ӽ���", "�Ӽ���")
	
		pageContext.setAttribute("page1", "pagelove"); // ������ ����
		request.setAttribute("req1", "reqlove"); // ��û
		session.setAttribute("ses1", "seslove"); // ������ ����ִ� ����
		application.setAttribute("app1", "applove"); // WAS
	
	%>
	
	<a href="./scope2.jsp">scope2.jsp �� �ѹ� ������?</a>

</body>
</html>