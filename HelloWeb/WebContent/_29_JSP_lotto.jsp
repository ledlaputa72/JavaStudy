<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
로또 프로그램 작성하시오<br>
<%
Random ran=new Random();
int soo1=ran.nextInt(44)+1;
int soo2=ran.nextInt(44)+1;
int soo3=ran.nextInt(44)+1;
int soo4=ran.nextInt(44)+1;
int soo5=ran.nextInt(44)+1;
int soo6=ran.nextInt(44)+1;
%>
lotto number <%= soo1 %>입니다. <br>
lotto number <%= soo2 %>입니다. <br>
lotto number <%= soo3 %>입니다. <br>
lotto number <%= soo4 %>입니다. <br>
lotto number <%= soo5 %>입니다. <br>
lotto number <%= soo6 %>입니다. <br>
<p>
for문을 이용한 방법<p>
<%
Random ran1=new Random();
int i;
int[] soo=new int[6];
for(i=0; i<6;i++)
{
soo[i]=ran1.nextInt(44)+1;
out.println("lotto number " + soo[i] +"입니다. <br>"); 
}
%>

</body>
</html>