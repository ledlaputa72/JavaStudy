<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - Border</title>

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
		<div class="menu clearfix" id="topImg">
			<div class="menu-item"><a href="./menu.jsp"><img src="./img/top1.png" alt="menu"></a></div>
			<div class="menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2.png" alt="storeInfo"></a></div>
			<div class="menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="menu-item"><a href="./notice.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.jsp"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>
<!-- ���� ���� -->
<div class="border_wrap " id="main_bg">
	<div class="border_header">
		�Խ���
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