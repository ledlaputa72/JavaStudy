<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAPS - Border</title>

<style>
#main_bg{
	background-size : contain;
	/* 
	cover : 배경 크기 참조하여 이미지를 확대 or 축소, 
	auto :  크기 그대로,  
	contain : 배경 크기 참조하되 가로세율 비율 맞추어 
	 */
 	background-image : url("./img/contents_bg2.jpg");
 	background-position : cneter; /* resize시 그림 가운가 보이게  */
 	min-height : 100%;
 	border : 0%;
 	padding : 0%;
}
</style>

<link rel="stylesheet" href="./css/main.css">
</head>
<body background="./img/woodBg.png">

<!-- 로그인 정보 -->
<div class="login">
	<div class="login-box">
	
		<%-- ${ svv.name } 님 <br>  --%>
		<%= session.getAttribute("sessid") %> 님 <br>
		
		<a href="logout.jsp">로그아웃</a> <br>
		<a href="myPage.do?id=<%= session.getAttribute("sessid") %>">마이 페이지</a>
	
	</div>
</div>

<!-- 상단 영역 -->
<header>
	<div class="container clearfix">
		<div class="menu clearfix" id="topImg">
			<div class="menu-item"><a href="./menu.jsp"><img src="./img/top1.png" alt="menu"></a></div>
			<div class="menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2.png" alt="storeInfo"></a></div>
			<div class="menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="menu-item"><a href="./notice.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.do"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>
<!-- 메인 영역 -->
<div class="border_wrap" id="main_bg">
	<div class="border_header">
		
		<table border="1" width="100%">

		<tr align="center">
			<th>메뉴</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>취소</th>
		</tr>
		
		<c:forEach var="vo1" items="${ alist2 }">
		
			<tr align="center">
				<td> ${ vo1.menu } </td>
				<td> ${ vo1.price } </td>
				<td> ${ vo1.amount } </td>
				<td> ${ vo1.price } </td>
				<td> <a href="cartDelete.do?cno=${ vo1.cno }">삭제</a> </td>
			</tr>
			
		</c:forEach>
		
		<tr align="center">
			<td colspan="4">
			
				<a href="notice.jsp">주문 화면으로</a>
				
			</td>
			
			<td colspan="1">	
				
				총 금액 : 
	
				<c:set var="totalPrice" value="0"></c:set> 
	
				<c:forEach var="vo1" items="${ alist2 }">
	
					<c:set var="totalPrice" value="${ totalPrice + vo1.price * vo1.amount }"></c:set>
		
				</c:forEach>
	
				<c:out value="${ totalPrice } 원"></c:out>
			
			</td>
		</tr>		
					
	</table>

	</div>
</div>

<!-- 하단 영역  -->
<footer>
	<div class="footer-container">
		 <img src="./img/footer.png" alt="company info">
	</div>
</footer>

</table>
</body>
</html>