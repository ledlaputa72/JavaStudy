<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - 밥스</title>

<!-- CSS  -->
<link rel="stylesheet" href="./css/main.css">

<!-- 슬라이드 제이쿼리  -->
<script src="js/jquery.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/jquery.bxslider.min.css">
<style>
	*{margin: 0;padding: 0;}
	#gallery_wrap{
		margin: 0 auto;
		width: 1000px;
	}
</style>
<script>
$(function() {
	$('.slide_gallery').bxSlider({
		auto: true,
		autoControls: true,
		stopAutoOnClick: true,
		pager: true
	});
});
</script>
<!-- 슬라이드 제이쿼리  -->
</head>
<body background="./img/woodBg.png">

<!-- 상단 영역 -->
<div class="header" >
	<div class="container clearfix">
		<div class="menu clearfix" id="topImg">
			<div class="menu-item"><a href="./menu.jsp"><img src="./img/top1.png" alt="menu"></a></div>
			<div class="menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2.png" alt="storeInfo"></a></div>
			<div class="menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="menu-item"><a href="./notice.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.jsp"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</div>

<!-- 메인 영역 슬라이드 -->
<div id="gallery_wrap">
	<ul class="slide_gallery">
		<li><img src="./img/event_img1.png" alt="evnet"></li>
		<li><img src="./img/event_img2.png" alt="evnet"></li>
	</ul>
</div>

<!-- 하단 영역  -->
<div class="footer">
	<div class="footer-container">
		하단 메뉴  
	</div>
</div>

</table>
</body>
</html>