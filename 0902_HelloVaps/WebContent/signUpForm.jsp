<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회 원 가 입</title>
<style>



</style>
</head>
<body background="gray" >


<h1  align="center">회원가입</h1>
<form action="joinpro.jsp" method="post">

<table width="410" height="300" border =1 align="center">
<tr>
<td align="center">이름</td>
<td style=padding-left:10px;><input  type="text" name="name" size=20 maxlength =50 placeholder="이 름 입 력" ></td>
</tr>

<tr>
<td align="center">ID</td>
<td style=padding-left:10px;><input type="text" name="id"size=20 maxlength =50 placeholder="ID 입력">&nbsp;
<input type="button" value="중복확인"></td>
</tr>

<tr>
<td align="center">비밀번호</td>
<td style=padding-left:10px;><input type="password" name="pw"size=20 maxlength =16 placeholder="6~16 숫자/숫자"required ></td>
</tr>

<tr>
<td align="center">비밀번호 확인</td>
<td style=padding-left:10px;><input type="password" name="pw2" size=20 maxlength =16 placeholder="6~16 숫자/숫자"required></td>
</tr>



<tr>
<td align="center">이메일</td>
<td style=padding-left:10px;><input type="text" name="email" size=20 placeholder="aa@naver.com" required ></td>
</tr>

<tr>
<td align="center">전화번호</td>
<td style=padding-left:10px;><input type="text" name="tel" size=20 maxlength=20 placeholder="010-1111-2222" required></td>
</tr>
<tr>
<td colspan=2 align="center"><input type="submit" value ="가입하기">
           <input type="reset" value ="취소">
</td>
</tr>
</table><br>
</form>


<!-- <input type="submit" value="가입하기">
<input type="button" value="취소"> -->

</body>
</html>