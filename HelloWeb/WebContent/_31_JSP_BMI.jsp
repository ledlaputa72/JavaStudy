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
request.setCharacterEncoding("euc-kr"); //post의 한글처리 방식
response.setCharacterEncoding("euc-kr");

String irum=request.getParameter("irum"); //홍길동
String ki=request.getParameter("ki"); //180
String mom=request.getParameter("mom"); //78
//get 방식은 tomcat의 server.xml의 63라인정도에다가 URIEncoding="euc-kr"

double dKi=Double.parseDouble(ki);
double dMom=Double.parseDouble(mom);
double mKi= dKi/100.0;
double bmi=dMom / Math.pow(mKi,2);
String result=null;
if(bmi >= 30.0)
	result="비만";
else if(bmi >= 25.0)
	result="과체중";
else if(bmi >= 20.0)  
	result="보통";
else 
	result="저체중";
%>
<h2>당신의 키와 몸무게BMI는 </h2><br>
이름 : <%=irum %><br> 
키 : <%=dKi %> 몸무게  : <%=dMom %> <br>
BMI : <%= bmi+" "+"결과 : " + result %><br>

</body>
</html>

