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
<body background="gray" align="center">


<h1>회원가입</h1>
<form action="joinpro.jsp" method="post">
</form>
<table width="500" height="350" border =1 align="center">
<tr>
<td>이름</td>
<td><input type="text" name="name" size=20 maxlength =50 placeholder="홍길동"></td>
</tr>

<tr>
<td>ID</td>
<td><input type="text" name="id"size=20 maxlength =50></td>
</tr>

<tr>
<td>비밀번호</td>
<td><input type="password" name="pw"size=20 maxlength =16 placeholder="6~16 숫자/숫자"required></td>
</tr>

<tr>
<td>비밀번호 확인</td>
<td><input type="password" name="pw2" size=20 maxlength =16 placeholder="6~16 숫자/숫자"required></td>
</tr>



<tr>
<td>이메일</td>
<td><input type="text" name="email" size=20 placeholder="aa@naver.com" required></td>
</tr>

<tr>
<td>전화번호</td>
<td><input type="text" name="tel" size=20 maxlength=20 placeholder="010-1111-2222" required></td>
</tr>
<tr>
<td colspan=2><input type="submit" value ="가입하기">
           <input type="reset" value ="취소">
</td>
</tr>
</table><br>
<!-- <input type="submit" value="가입하기">
<input type="button" value="취소"> -->
<a href="joinpro.jsp">[가입하기]</a>

</body>
</html>