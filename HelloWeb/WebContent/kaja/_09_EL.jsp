<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% double kab=37.8;
String kab2=null;
%>
<%= "온달" %> <!-- 표현식  --> ${"온달"} <!-- EL방식 --> 

${"형이 말하는데"} <br>
${"el"} 은 참 간단해서 좋지만 공부는 해야해 <br>
${100} ${100 > 2} ${200.35} ${10 % 3} <br>
${false} ${empty kab2} ${null} 등같은 표현이 가능해 <br>
<!-- ${empty kab2}는 true null이면 아예 아무것도 출력 안함 -->
역시 EL은 Flexible해~~~~~~~~~~~~~<br>
<!-- 값이 없는 null 및 형변환등에 편리 -->
<!-- nullpoint error가 없는것이 el 즉, error X -->

${ 50 == 50 }<br>
${ 50 eq 50 }<br>
${ (100>3)? "커" : "작아"} <br>
${ 50 mod 5 }<br>
${ "Oh!!1 happy"}<br>
<hr>
${"여우가시별 vs 미스터션사인"}<br> <!-- 아래 문법을 간단히 실행 가능  -->
<% out.println("여우각시별 vs 미스터션사인"); %> <br>
<%! String foxsun="여우각시별 vs 미스터션사인"; %>
<%= foxsun %>
</body>
</html>