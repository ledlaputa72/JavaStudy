<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>뭘 살까???</h2>
<% 
	String vid1=request.getParameter("id1");
	String vpw1=request.getParameter("pw1");
%>
이하 id는 <%= vid1 %> 이고  암호는 <%=vpw1 %>이군요<P>
<%                   /* name value */
session.setAttribute("sid1",vid1); //브라우저 살아있는 동안
session.setAttribute("spw1",vpw1); //브라오저 살아있는 동안 
%>

가방쇼핑은 <a href="kabang.jsp">여기</a>를 누르세요<br>
구도쇼핑은 <a href="koodoo.jsp">여기</a>를 누르세요<br>
</body>
</html>