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
<%= "�´�" %> <!-- ǥ����  --> ${"�´�"} <!-- EL��� --> 

${"���� ���ϴµ�"} <br>
${"el"} �� �� �����ؼ� ������ ���δ� �ؾ��� <br>
${100} ${100 > 2} ${200.35} ${10 % 3} <br>
${false} ${empty kab2} ${null} ��� ǥ���� ������ <br>
<!-- ${empty kab2}�� true null�̸� �ƿ� �ƹ��͵� ��� ���� -->
���� EL�� Flexible��~~~~~~~~~~~~~<br>
<!-- ���� ���� null �� ����ȯ� �� -->
<!-- nullpoint error�� ���°��� el ��, error X -->

${ 50 == 50 }<br>
${ 50 eq 50 }<br>
${ (100>3)? "Ŀ" : "�۾�"} <br>
${ 50 mod 5 }<br>
${ "Oh!!1 happy"}<br>
<hr>
${"���찡�ú� vs �̽��ͼǻ���"}<br> <!-- �Ʒ� ������ ������ ���� ����  -->
<% out.println("���찢�ú� vs �̽��ͼǻ���"); %> <br>
<%! String foxsun="���찢�ú� vs �̽��ͼǻ���"; %>
<%= foxsun %>
</body>
</html>