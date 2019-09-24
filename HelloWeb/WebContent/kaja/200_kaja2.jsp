<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL If 문장 연습</title>
</head>
<body>
	<c:if test="${param.chimi == 'tennis'}">
		<div>아하 테니스 </div>
	</c:if>
	<c:if test="${param.chimi == 'soccer'}">
		<div>아하 축구 </div>
	</c:if>
	<c:if test="${param.chimi == 'golf'}">
		<div>아하 골프 </div>
	</c:if>	
</body>
</html>