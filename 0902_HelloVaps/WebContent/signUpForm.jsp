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
<body background="gray" >


<h1  align="center">ȸ������</h1>
<form action="joinpro.jsp" method="post">

<table width="410" height="300" border =1 align="center">
<tr>
<td align="center">�̸�</td>
<td style=padding-left:10px;><input  type="text" name="name" size=20 maxlength =50 placeholder="�� �� �� ��" ></td>
</tr>

<tr>
<td align="center">ID</td>
<td style=padding-left:10px;><input type="text" name="id"size=20 maxlength =50 placeholder="ID �Է�">&nbsp;
<input type="button" value="�ߺ�Ȯ��"></td>
</tr>

<tr>
<td align="center">��й�ȣ</td>
<td style=padding-left:10px;><input type="password" name="pw"size=20 maxlength =16 placeholder="6~16 ����/����"required ></td>
</tr>

<tr>
<td align="center">��й�ȣ Ȯ��</td>
<td style=padding-left:10px;><input type="password" name="pw2" size=20 maxlength =16 placeholder="6~16 ����/����"required></td>
</tr>



<tr>
<td align="center">�̸���</td>
<td style=padding-left:10px;><input type="text" name="email" size=20 placeholder="aa@naver.com" required ></td>
</tr>

<tr>
<td align="center">��ȭ��ȣ</td>
<td style=padding-left:10px;><input type="text" name="tel" size=20 maxlength=20 placeholder="010-1111-2222" required></td>
</tr>
<tr>
<td colspan=2 align="center"><input type="submit" value ="�����ϱ�">
           <input type="reset" value ="���">
</td>
</tr>
</table><br>
</form>


<!-- <input type="submit" value="�����ϱ�">
<input type="button" value="���"> -->

</body>
</html>