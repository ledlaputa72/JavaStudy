<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - Menu</title>
<link rel="stylesheet" href="./css/main.css">
</head>
<body background="./img/woodBg.png">

<!-- 로그인 정보 -->
<div class="login">
	<div class="login-box">
	[관리자님]
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
			<div class="menu-item"><a href="./border.jsp"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>
<!-- 메인 영역 -->
<div class="main_wrap">
	<div class="menu_wrap">
		<div class="menu_header">
			<h2>메인 메뉴</h2> 
		</div>
		<div>
			<div class="menu-list">
				<div>스테이크</div>
				<div>
					<div id="menu_img"><img src="./img/event_img1.jpg" alt="evnet" border="2"></div><div>설명 내용 주절</div>
				</div>
				<div>햄버거</div><div id="menu_img"><img src="./img/event_img2.jpg" alt="evnet" border="2"></div>
				<div>피자</div><div id="menu_img"><img src="./img/event_img3.jpg" alt="evnet" border="2"></div>
				<div>김밥</div><div id="menu_img"><img src="./img/event_img4.jpg" alt="evnet" border="2"></div>
				<div>라멘</div><div id="menu_img"><img src="./img/event_img5.jpg" alt="evnet" border="2"></div>
				<div>집밥</div><div id="menu_img"><img src="./img/event_img6.jpg" alt="evnet" border="2"></div>
				<div>편의점도시락</div><div id="menu_img"><img src="./img/event_img7.jpg" alt="evnet" border="2"></div>
			</div>
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