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
include directive : 내용을 그대로 include
include action tag : html, jsp 등의 처리결과를 include
param : 값을 넘겨줄때 
</pre>
<!-- HTML 에서 형식  
<input type=text name="irum1" value="jehoon"> -->
<!-- 여기 태그 주의 action tag는 xml 규칙 -->
<jsp:include page="200_includesubparam.jsp">
	<jsp:param name="irum1" value="jehoon"/>
	<jsp:param name="irum2" value="soobin"/>
</jsp:include>
</body>
</html>