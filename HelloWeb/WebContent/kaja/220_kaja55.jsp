<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- ========= format ============ -->  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>STL & EL ��Ÿ��</h3>
<!-- request.setCharcterEncoding("UTF-8"); -->
<fmt:requestEncoding value="UTF-8"></fmt:requestEncoding>
<!-- ���� taglib...fmt�����ؾ� �Ѵ�.  -->
���� �̸��� <c:out value="${param.irum}"></c:out>
�׸��� ��ȭ��ȣ�� <c:out value="${param.tel}"></c:out>
</body>
</html>