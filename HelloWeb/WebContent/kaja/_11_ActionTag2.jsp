<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Include-param</h2>

<pre>
include directive : ������ �״�� include
include action tag : html, jsp ���� ó������� include
param : ���� �Ѱ��ٶ� 
</pre>
<!-- HTML ���� ����  
<input type=text name="irum1" value="jehoon"> -->
<!-- ���� �±� ���� action tag�� xml ��Ģ -->
<jsp:include page="200_includesubparam.jsp">
	<jsp:param name="irum1" value="jehoon"/>
	<jsp:param name="irum2" value="soobin"/>
</jsp:include>
</body>
</html>