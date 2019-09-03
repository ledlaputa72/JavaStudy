<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - �佺</title>

<!-- CSS  -->
<link rel="stylesheet" href="./css/main.css">

<!-- �����̵� ��������  -->
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
<!-- �����̵� ��������  -->
</head>
<body background="./img/woodBg.png">

<!-- �α��� ���� -->
<div class="login">
	<div class="login-box">
	[�����ڴ�]
	</div>
</div>

<!-- ��� ���� -->
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

<!-- ���� ��ü  -->
<div class="main_wrap">
	<!-- ���� ���� �����̵� -->
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
	<!-- ���� ������  -->
	<div class="main-container">
		<div>
			���� ����
		</div>
	</div>
</div>
<!-- �ϴ� ����  -->
<footer>
	<div class="footer-container">
		 <img src="./img/footer.png" alt="company info">
	</div>
</footer>
</table>
</body>
</html>