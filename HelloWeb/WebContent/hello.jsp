<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%!
	public String kaja(){
	return "����!�� ����"; //declaration 
}
%>
</head>

<body>

<!-- ******************************* -->
���� ��¥�� ����� ���� <br>
<% // scriptlet ��ũ��Ʈ�� (server side script ) 
Date d1=new Date();
//�ڵ� ���� Ŀ���� ���ڳ�, ctrl+spacebar�� ���� 
out.println("��¥ ����̶��?!" + "   " + d1 + "<p>");
out.println(request.getRequestURI()+"�� ��û�� URI ����" + "<br>");
//out: jsp ���� //request ��û��� ���� ��ü //response
%>

<!-- ******************************** -->
����! �׷�����! ���� ��¥�� <%= d1  %>�̱���<br>
                     <!-- d1�� ����, expression ǥ���� -->
<h1>�׸��� ������ ���ϸ� 
<%= d1.getYear()+1900 %> �� �Դϴ�. </h1><br>
<!-- =  ��  out.println() -->

<!-- ******************************** -->
<% 
//public String kaja(){
//return "����!�� ����"; //declaration 
//}
	String bada=kaja(); //�޼ҵ� ȣ�⹮ 
	out.println(bada);
%>
</body>
</html>