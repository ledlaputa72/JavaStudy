<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>���� �α��� �޴� ����</h2>
	
	<%
	
		// http://url?id1=...&pw1=...
	
		// request ���� ��ü
		String id1 = request.getParameter("id1");
		String pw1 = request.getParameter("pw1");
		int na2 = Integer.parseInt(request.getParameter("na2"));
	
	%>
	
	���̵�� <%= id1 %> �̰�, ��ȣ�� <%= pw1 %> �̱���~ <p>
	�׸��� <%= 2019 - na2 %> ����̰�, ���̴� <%= na2 %> ���̱���~ <p>

</body>
</html>