<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
String irum=(String)request.getParameter("irum");
String na2=(String)request.getParameter("na2");
out.println("여기는 자바스타일로 출력"+irum+" , " + na2 + "<br>");
 %>
 <!-- 여기에 Sawon 자바 클래스를 불러오고 싶다면 아래와 같이 new로 객체 생성  -->
 <!-- Sawon sawon1=new Sawon()  -->
 <!-- Sawon sawon2=new Sawon()  -->
 <!-- 위처럼 하지 않고 태그 스타일로 ==> 이것이 useBean Action tag이다. -->
 
 <!-- id는 객체명 calss="패키지명.클래스명" -->
 <jsp:useBean id="sawon1" class="sawonpkg.Sawon" />
 <jsp:useBean id="sawon2" class="sawonpkg.Sawon" />
 
 <jsp:setProperty name="sawon1" property="irum"/>
 <jsp:setProperty name="sawon1" property="na2"/>
 <!-- getter/setter를 의미, 넘어오는것이 없으면 당연히 null 
 sawon1.setIrum(request.getParmeter("irum"))
 sawon1.setna2(request.getParmeter("na2"))
 -->
 
 <jsp:getProperty name="sawon1" property="irum"/><br>
 <jsp:getProperty name="sawon1" property="na2"/><br>
 
 