<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
String irum=(String)request.getParameter("irum");
String na2=(String)request.getParameter("na2");
out.println("����� �ڹٽ�Ÿ�Ϸ� ���"+irum+" , " + na2 + "<br>");
 %>
 <!-- ���⿡ Sawon �ڹ� Ŭ������ �ҷ����� �ʹٸ� �Ʒ��� ���� new�� ��ü ����  -->
 <!-- Sawon sawon1=new Sawon()  -->
 <!-- Sawon sawon2=new Sawon()  -->
 <!-- ��ó�� ���� �ʰ� �±� ��Ÿ�Ϸ� ==> �̰��� useBean Action tag�̴�. -->
 
 <!-- id�� ��ü�� calss="��Ű����.Ŭ������" -->
 <jsp:useBean id="sawon1" class="sawonpkg.Sawon" />
 <jsp:useBean id="sawon2" class="sawonpkg.Sawon" />
 
 <jsp:setProperty name="sawon1" property="irum"/>
 <jsp:setProperty name="sawon1" property="na2"/>
 <!-- getter/setter�� �ǹ�, �Ѿ���°��� ������ �翬�� null 
 sawon1.setIrum(request.getParmeter("irum"))
 sawon1.setna2(request.getParmeter("na2"))
 -->
 
 <jsp:getProperty name="sawon1" property="irum"/><br>
 <jsp:getProperty name="sawon1" property="na2"/><br>
 
 