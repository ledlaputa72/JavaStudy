<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>선언문 예제 </h2>

<%!
	String id = "Kingdora";

	public String getId(){
		return id;
	}
%>

id 변수 : <%=id %> <br>
getId()메소드 실행 결과 <%=getId() %>
</body>
</html>