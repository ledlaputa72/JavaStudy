<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
getHeader --> <%= request.getHeader("user-agent") %><br>
	<!-- ������ �˾Ƴ���  ����������(ũ��-webkit, ����-gecko -->
RequestURI --> <%= request.getRequestURL() %><br>
ServletPath --> <%= request.getServletPath() %><br>
ServerName --> <%= request.getServerName() %><br>
ServertPort --> <%= request.getServerPort() %><br>
RemoteAddr --> <%= request.getRemoteAddr() %><br>
RemoteHost --> <%= request.getProtocol() %><br>
Protocol --> <%= request.getServerName() %><br>
Method --> <%= request.getMethod() %><br>
</body>
</html>