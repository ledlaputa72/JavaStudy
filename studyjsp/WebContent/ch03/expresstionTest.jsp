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
	<tr><th>�迭�� ÷�� ��ȣ</th><th>�迭 ����� ��</th> 
	<% for(int i=0; i<str.length; i++){%>
		<tr><td><%=i %></td><td><%=str[i] %></td>
		<%} %>
	</tr>		
</table>
<h2>ǥ���� ���� </h2>

<%
//�⺻ ������ Ÿ�� ���
int x = 10;
int y = (x>10)?20:x;
out.println("y������ ���� : " + y + "<br>");

//���۷��� Ÿ�� ��� 
StringBuffer sf = new StringBuffer("Unicorn");
sf.reverse();
out.println("��ü�� ���� : " + sf.toString());
%>
</body>
</html>