<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Include</h2>

<pre>
include directive : ������ �״�� include 
<%-- <%@ include file="includeSub.jsp" %> 
	���� ������ ���Խ�ų��, ���� �� ó���� �ȴ�.  
--%>
<hr>
include action tag : html, jsp���� ó������� include <br>
</pre>
<jsp:include page="100_includesub.jsp" />
<!-- �� �������?? �¾� �׼��±�   -->
</body>
</html>