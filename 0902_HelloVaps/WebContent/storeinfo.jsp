<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - Store Information</title>
<link rel="stylesheet" href="./css/main.css">
<link  rel="stylesheet" href="/common/css/common.css">

<!-- 지도  -->
<meta name="viewpot"  content="initial-scale=1.0, user-scalable=no">

<script src="https://maps.google.com/maps/api/js?senseor=false"></script>
<script>
       window.onload=function(){
              var joongang1 = new google.maps.LatLng(37.571001,126.992529);
              //해당 위도, 경도를 지도의 중앙으로 위치하기 위한 것
              var mapDesign1 = {zoom: 17, center: joongang1, mapTypeId :  google.maps.MapTypeId.ROADMAP};
              //var mapDesign1 = {zoom: 15, center: joongang1, mapTypeId :  google.maps.MapTypeId.HYBRID}; //위성사진
              var map = new  google.maps.Map(document.getElementById("jido1"),mapDesign1);
              //화면에 출력하는 것 
       }
</script>
<!-- 지도  -->	
	

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
<div class="store_wrap">
	<div class="store_header">
		<table width="600px" border="0" align="center">
			<tr align="center">
				<td>
					<div><h2>오시는 길</h2> </div>
				</td>
			</tr>
			<tr align="center">
				<td >
					<div class="store_map">
				 		<div id="jido1" style="width: 500px; height:500px"></div>
					</div>
				</td>
			</tr>
			<tr  align="center">
				<td>
					<div> 주소  </div>
				</td>
			</tr>
			<tr>
				<td>
					<div> 서울 종로구 종로3가 단성사 5층 ITBank </div>
				</td>
			</tr>
			<tr>			
				<td>
					<div>   </div>
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