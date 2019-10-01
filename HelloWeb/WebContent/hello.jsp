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
	return "아하!로 선언"; //declaration 
}
%>
</head>

<body>

<!-- ******************************* -->
오늘 날짜를 출력해 보자 <br>
<% // scriptlet 스크립트릿 (server side script ) 
Date d1=new Date();
//자동 생성 커서는 글자끝, ctrl+spacebar로 선택 
out.println("날짜 출력이라고?!" + "   " + d1 + "<p>");
out.println(request.getRequestURI()+"가 요청한 URI 구만" + "<br>");
//out: jsp 낵장 //request 요청담당 내장 객체 //response
%>

<!-- ******************************** -->
아하! 그렇구나! 오늘 날짜는 <%= d1  %>이군요<br>
                     <!-- d1의 내용, expression 표현식 -->
<h1>그리고 연도만 말하면 
<%= d1.getYear()+1900 %> 년 입니다. </h1><br>
<!-- =  은  out.println() -->

<!-- ******************************** -->
<% 
//public String kaja(){
//return "아하!로 선언"; //declaration 
//}
	String bada=kaja(); //메소드 호출문 
	out.println(bada);
%>
</body>
</html>