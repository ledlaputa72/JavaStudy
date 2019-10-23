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
	String[] str = {"JSP", "JAVA", "Android", "HTML5"};
%>
<table>
	<tr><th>배열의 첨자 번호</th><th>배열 요소의 값</th> 
	<% for(int i=0; i<str.length; i++){%>
		<tr><td><%=i %></td><td><%=str[i] %></td>
		<%} %>
	</tr>		
</table>
<h2>표현식 예제 </h2>

<%
//기본 데이터 타입 출력
int x = 10;
int y = (x>10)?20:x;
out.println("y변수의 내용 : " + y + "<br>");

//레퍼런스 타입 출력 
StringBuffer sf = new StringBuffer("Unicorn");
sf.reverse();
out.println("객체의 내용 : " + sf.toString());
%>
</body>
</html>