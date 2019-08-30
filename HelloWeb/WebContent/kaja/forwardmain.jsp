<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String irum=request.getParameter("irum");
String tel=request.getParameter("tel");
   /* 아래에서 다시 다른 jsp로 forward할때를 대비하여  */
session.setAttribute("sirum", irum);
session.setAttribute("stel", tel);
%>

<%
if(tel.equals("bimil")){ %>
<jsp:forward page="impossible.jsp"/>
<% } else { %>
<jsp:forward page="homepage.jsp"/>
<% } %>
</body>
</html>