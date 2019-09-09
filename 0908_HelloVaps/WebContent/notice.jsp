<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAPS - Notice</title>

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
			<div class="menu-item"><a href="./notice.jsp"><img src="./img/top4a.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.do"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>
<!-- 메인 영역 -->
<div class="notice_wrap" id="main_bg">
	<div class="notice_header" align="center">
		
		<table border="0">
		
			<tr align="center">
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img1.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>아웃뺵 스테이크</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>30,000</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" id="menu" value="아웃뺵 스테이크">
									<input type="hidden" name="price" value="30000">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>
				
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img2.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>버거퀸</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>4,900</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="버거퀸">
									<input type="hidden" name="price" value="4900">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>
				
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img3.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>피자 헉!</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>15,000</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="피자 헉!">
									<input type="hidden" name="price" value="15000">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>	
				
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img4.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>옆구리 김밥</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>3,000</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="옆구리 김밥">
									<input type="hidden" name="price" value="3000">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>
			</tr>
			
			<tr align="center">
			
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img5.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>챠슈 라멘</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>8,000</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="챠슈 라멘">
									<input type="hidden" name="price" value="8000">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>
				
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img6.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>엄마 도시락</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>6,000</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="엄마 도시락">
									<input type="hidden" name="price" value="6000">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }"> ${ i } </option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>	
				
				<td>
		
					<table border="1">
					
						<tr align="center">
							<td colspan="2"> <img src="./img/event_img7.jpg" style="width:200px; height:150px;"> </td>
						</tr>
						
						<tr align="center">	
							<td>메뉴명</td>
							<td>도시락</td>
						</tr>
						
						<tr align="center">
							<td>가격</td>
							<td>4,500</td>
						</tr>
								
						<tr align="center">
						
							<td colspan="2">
								
								<form name="form1" method="post" action="cartInsert.do">
											
									<input type="hidden" name="menu" value="도시락">
									<input type="hidden" name="price" value="4500">
												
									<select name="amount">
													
										<c:forEach begin="1" end="10" var="i">
											<option value="${ i }">${ i }</option>
										</c:forEach>	
												
									</select>&nbsp; 개
												
									<input type="submit" value="장바구니에 담기">
											
								</form>
									
							</td>
								
						</tr>
						
					</table>
					
				</td>	
				
				<td>	
					<a href="cartList.do">장바구니 화면으로</a>
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