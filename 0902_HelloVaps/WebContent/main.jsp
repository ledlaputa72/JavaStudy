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
		background-color:#2B2119;	
	}
	
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

<!-- 로그인 정보 -->
<div class="login">
   <div class="login-box">
   
      <b>${ svv.name } 님 </b><br><br>
      
      <a href="logout.do">로그아웃</a> <br>
      <a href="myPage.do?id=${ svv.id }">마이 페이지</a>
   
   </div>
</div>

<!-- 상단 영역 -->
<header>
	<div class="container clearfix">
		<div class="top_menu clearfix" id="topImg">
			<div class="top_menu-item"><a href="./menu.jsp"><img src="./img/top1.png" alt="menu"></a></div>
			<div class="top_menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2.png" alt="storeInfo"></a></div>
			<div class="top_menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="top_menu-item"><a href="./notice.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="top_menu-item"><a href="./border.jsp"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>

<!-- 메인 전체  -->
<div class="main_wrap">
	<!-- 메인 영역 슬라이드 -->
	<div id="gallery_wrap">
		<ul class="slide_gallery">
			<li><a href="./menu.jsp"><img src="./img/event_img1.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img2.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img3.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img4.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img5.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img6.png" alt="evnet"></a></li>
			<li><a href="./menu.jsp"><img src="./img/event_img7.png" alt="evnet"></a></li>
		</ul>
	</div>
	<!-- 메인 컨텐츠  -->
	<div class="main-container" id="main_bg">
		<div class="main_table">
			<div id="colum1">


			</div>
			<div id="colum2">
			
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