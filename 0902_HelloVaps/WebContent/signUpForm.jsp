<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ �� �� ��</title>
<style>


</style>
</head>
<body background="gray" align="center">


<h1>ȸ������</h1>
<form action="joinpro.jsp" method="post">
</form>
<table width="500" height="350" border =1 align="center">
<tr>
<td>�̸�</td>
<td><input type="text" name="name" size=20 maxlength =50 placeholder="ȫ�浿"></td>
</tr>

<tr>
<td>ID</td>
<td><input type="text" name="id"size=20 maxlength =50></td>
</tr>

<tr>
<td>��й�ȣ</td>
<td><input type="password" name="pw"size=20 maxlength =16 placeholder="6~16 ����/����"required></td>
</tr>

<tr>
<td>��й�ȣ Ȯ��</td>
<td><input type="password" name="pw2" size=20 maxlength =16 placeholder="6~16 ����/����"required></td>
</tr>



<tr>
<td>�̸���</td>
<td><input type="text" name="email" size=20 placeholder="aa@naver.com" required></td>
</tr>

<tr>
<td>��ȭ��ȣ</td>
<td><input type="text" name="tel" size=20 maxlength=20 placeholder="010-1111-2222" required></td>
</tr>
<tr>
<td colspan=2><input type="submit" value ="�����ϱ�">
           <input type="reset" value ="���">
</td>
</tr>
</table><br>
<!-- <input type="submit" value="�����ϱ�">
<input type="button" value="���"> -->
<a href="joinpro.jsp">[�����ϱ�]</a>

</body>
</html>