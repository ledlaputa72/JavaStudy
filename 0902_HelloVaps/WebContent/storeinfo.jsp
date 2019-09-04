<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - Store Information</title>

<style>
#main_bg{
	background-size : contain;
	/* 
	cover : ��� ũ�� �����Ͽ� �̹����� Ȯ�� or ���, 
	auto :  ũ�� �״��,  
	contain : ��� ũ�� �����ϵ� ���μ��� ���� ���߾� 
	 */
 	background-image : url("./img/contents_bg2.jpg");
 	background-position : cneter; /* resize�� �׸� ��� ���̰�  */
 	min-height : 100%;
 	border : 0%;
 	padding : 0%;
}
</style>

<link rel="stylesheet" href="./css/main.css">
<link  rel="stylesheet" href="/common/css/common.css">

<!-- ����  -->
<meta name="viewpot"  content="initial-scale=1.0, user-scalable=no">

<script src="https://maps.google.com/maps/api/js?senseor=false"></script>
<script>
       window.onload=function(){
              var joongang1 = new google.maps.LatLng(37.571001,126.992529);
              //�ش� ����, �浵�� ������ �߾����� ��ġ�ϱ� ���� ��
              var mapDesign1 = {zoom: 17, center: joongang1, mapTypeId :  google.maps.MapTypeId.ROADMAP};
              //var mapDesign1 = {zoom: 15, center: joongang1, mapTypeId :  google.maps.MapTypeId.HYBRID}; //��������
              var map = new  google.maps.Map(document.getElementById("jido1"),mapDesign1);
              //ȭ�鿡 ����ϴ� �� 
       }
</script>
<!-- ����  -->	
	

</head>
<body background="./img/woodBg.png">

<!-- �α��� ���� -->
<div class="login">
   <div class="login-box">
   
      ${ svv.name } �� <br>
      
      <a href="logout.do">�α׾ƿ�</a> <br>
      <a href="myPage.do?id=${ svv.id }">���� ������</a>
   
   </div>
</div>

<!-- ��� ���� -->
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

<!-- ���� ���� -->
<div class="store_wrap" id="main_bg">
	<br><br>	
	<div class="store_header">
		<table width="600px" border="0" align="center">
			<tr align="center">
				<td>
					<div><h2>���ô� ��</h2> </div>
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
					<div><h3> �ּ�  </h3></div>
				</td>
			</tr>
			<tr>
				<td>
					<div> <h4> ���� ���α� ����3�� �ܼ��� 5�� ITBank </h4> </div>
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

<!-- �ϴ� ����  -->
<footer>
	<div class="footer-container">
		 <img src="./img/footer.png" alt="company info">
	</div>
</footer>

</table>
</body>
</html>