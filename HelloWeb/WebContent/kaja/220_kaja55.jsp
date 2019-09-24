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
<h3>STL & EL 스타일</h3>
<!-- request.setCharcterEncoding("UTF-8"); -->
<fmt:requestEncoding value="UTF-8"></fmt:requestEncoding>
<!-- 위에 taglib...fmt선언해야 한다.  -->
아하 이름은 <c:out value="${param.irum}"></c:out>
그리고 전화번호는 <c:out value="${param.tel}"></c:out>
</body>
</html>