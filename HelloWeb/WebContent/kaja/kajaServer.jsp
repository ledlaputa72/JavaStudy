<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="naerrorpage.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
int na2Soo1 = Integer.parseInt(request.getParameter("na2")); //�Է��� ���� �̹Ƿ� 
out.println("���̴� "+na2Soo1); //���̸� �Է¾��ϸ� �����߻��ϰ� naerrorpage�� ����. 
%>
</body>
</html>