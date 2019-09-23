<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>가방 구입하러 왔당</h2>
<% /* html + jsp */
String sid1=(String)session.getAttribute("sid1");
String spw1=(String)session.getAttribute("spw1");
if(!sid1.equals("babo") || !spw1.equals("ondal"))
{
	out.println("<h2>id 암호 입력 에러입니다. 로그인 화면으로 값니다. </h2>");
	out.println("<a href='_07_Request.html'>여기</a>를 누르세요<br>");
}else{
	out.println("<img src='kabang.jpg'>");
	//id 암호가 맞으면 여기에 상품 출력 나와서 사게한다. 
}
%><br><br>
네이버도 한번 갔다 와봅시다 
<a href="http://www.naver.com">여기</a>를 누르세요<br>
</body>
</html>
