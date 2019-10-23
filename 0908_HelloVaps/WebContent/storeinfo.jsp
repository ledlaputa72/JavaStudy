<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAPS - Store Information</title>

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
			<div class="menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2a.png" alt="storeInfo"></a></div>
			<div class="menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="menu-item"><a href="./notice.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.do"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>

<!-- 메인 영역 -->
<div class="store_wrap" id="main_bg">
	<br><br>	
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
					<div><h3> 주소  </h3></div>
				</td>
			</tr>
			<tr>
				<td>
					<div> <h4> 서울 종로구 종로3가 단성사 5층 ITBank </h4> </div>
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