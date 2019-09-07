<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAPS - Menu</title>

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

#menu_name{
	font-weight: bold;
	background-color: red; 
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

<div class="menu_wrap"  id="main_bg" >
	<div class="menu_header" >
	</div>
	<div>
		<div class="menu-list" >
			<!-- 메뉴1 -->
			<div><h3>메뉴 1</h3></div>
			<div id="menu_img">
				<img src="./img/event_img1.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>아웃빽 스테이크</b></h2><br>
					100% 청정 한우<br><br>
					가격 : <b>30,000원</b> <br> 
				</div>
			</div>
			<!-- 메뉴2 -->
			<div><h3>메뉴 2</h3></div>
			<div id="menu_img">
				<img src="./img/event_img2.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>사딸라 버거퀸</b></h2><br>
					하루종일 올데이 퀸<br><br>
					가격 : <b>4,900원</b> <br> 
				</div>
			</div>
			<!-- 메뉴3 -->
			<div><h3>메뉴 3</h3></div>
			<div id="menu_img">
				<img src="./img/event_img3.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>피자 헉!</b></h2><br>
					꽈뜨로 치즈 듬뿍 피자<br><br>
					가격 : <b>15,000원</b> <br> 
				</div>
			</div>
			<!-- 메뉴4 -->
			<div><h3>메뉴 4</h3></div>
			<div id="menu_img">
				<img src="./img/event_img4.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>옆구리 김밥</b></h2><br>
					옆구리 터지게 빵빵한 김밥<br><br>
					가격 : <b>3,000원</b> <br> 
				</div>
			</div>
			<!-- 메뉴5 -->
			<div><h3>메뉴 5</h3></div>
			<div id="menu_img">
				<img src="./img/event_img5.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>챠슈 라멘~</b></h2><br>
					두툼한 챠슈와 반숙계란<br><br>
					가격 : <b>8,000원</b> <br> 
				</div>
			</div>
			<!-- 메뉴6 -->
			<div><h3>메뉴 6</h3></div>
			<div id="menu_img">
				<img src="./img/event_img6.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>엄마 도시락</b></h2><br>
					엄마 정성 담긴 집밥 도시락<br><br>
					가격 : <b>6,000원</b> <br> 
				</div>
			</div>
			<!-- 메뉴7 -->
			<div><h3>메뉴 7</h3></div>
			<div id="menu_img">
				<img src="./img/event_img7.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>편의점 도시락</b></h2><br>
					백종원혜자 도시락<br><br>
					가격 : <b>4,500원</b> <br> 
				</div>
			</div>
			<br><br><br>			
		</div>
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