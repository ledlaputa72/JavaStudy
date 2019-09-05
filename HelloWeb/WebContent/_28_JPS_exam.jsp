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
		result="짝수";
	}else{
		result="홀수";
	}
	return result; 
}
%>
</head>
<body>
	 
	34를 int에 넣은 후 홀수인지 짝수인지 출력하는 프로그램을<br>
	jsp로 작성해보삼<br>
	
	<br>*******메소드 정의문을 이용한 방법<br>
	<%
	int num=34;
	out.println(num+"값은 " + kaja(num) + "입니다");
	%>
	<p>
	<br>*******다른 표현식은*<br> 
	<%
	int num1=34;
	if(num1%2==0){
		out.println("짝수");
	}else{
		out.println("홀수");
	}
	%>
	<p>
	<br>*******스크립트릿 과 표현식 및 html로 하면<br>
	<% 
	int soo=34;
	if(soo%2==0){		
	%>
	보아하니 <%=soo %>는 짝수군요<br>
	<% } else { %>
	보아하니 <%=soo %>는 홀수군요 <br>
	<%} %>
	
</body>

</html>