<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%!
public String kaja(int num){
	String result="";
	if(num%2==0){
		result="¦��";
	}else{
		result="Ȧ��";
	}
	return result; 
}
%>
</head>
<body>
	 
	34�� int�� ���� �� Ȧ������ ¦������ ����ϴ� ���α׷���<br>
	jsp�� �ۼ��غ���<br>
	
	<br>*******�޼ҵ� ���ǹ��� �̿��� ���<br>
	<%
	int num=34;
	out.println(num+"���� " + kaja(num) + "�Դϴ�");
	%>
	<p>
	<br>*******�ٸ� ǥ������*<br> 
	<%
	int num1=34;
	if(num1%2==0){
		out.println("¦��");
	}else{
		out.println("Ȧ��");
	}
	%>
	<p>
	<br>*******��ũ��Ʈ�� �� ǥ���� �� html�� �ϸ�<br>
	<% 
	int soo=34;
	if(soo%2==0){		
	%>
	�����ϴ� <%=soo %>�� ¦������<br>
	<% } else { %>
	�����ϴ� <%=soo %>�� Ȧ������ <br>
	<%} %>
	
</body>

</html>