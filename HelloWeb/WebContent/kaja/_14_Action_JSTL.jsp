<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>
<body>
<!-- ���� ���� tablib������� �̹����� ����ϸ� �׳� �����ϰ� �н�  -->
<c:out value="�ȳ� JSTL"/> <br>
<% out.println("�ȳ� JSTL");%> <br>

<!-- ===================== -->
<% String aa="chokichi"; %>
<%=aa %>
<c:set var="bb" value="chokichi"></c:set><br>
${bb}<br>
<!-- ===================== -->

<!-- JSTL & EL -->
<% int jumsoo=100;  %>
<%=jumsoo %>
<c:set var="jum">100</c:set><br>
${jum }<br>

</body>
</html>