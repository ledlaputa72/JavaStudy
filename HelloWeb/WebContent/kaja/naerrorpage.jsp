<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true" %>
    
<% response.setStatus(200); %>

<%-- 
	404	500		...
	���� 200
	�� �������� ���� �����ϴ�. �׷��� ����� �� ����մϴ�.
 --%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<pre>
	
		������ ���� ������ �߻��߽��ϴ�.
		��� ������ �߻��Ǹ� �������� ��ȭ�ֽñ� �ٶ��ϴ�.
		��ȭ ��ȣ�� 02-3456-5577 �Դϴ�.
	
	</pre>
	
	<hr>
	
	<!-- �� : ���̸� �� ĭ���� ó���� ��� ���� ������ For input string : "" -->
	���� ������ <h3> <%= exception.getMessage() %> </h3>

</body>
</html>