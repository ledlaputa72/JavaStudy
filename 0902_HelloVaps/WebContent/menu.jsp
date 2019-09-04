<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - Menu</title>

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

#menu_name{
	font-weight: bold;
	background-color: red; 
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
<div class="menu_wrap"  id="main_bg" >
	<div class="menu_header" >

	</div>
	<div>
		<div class="menu-list" >
			<!-- �޴�1 -->
			<div><h3>�޴� 1</h3></div>
			<div id="menu_img">
				<img src="./img/event_img1.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>�ƿ��� ������ũ</b></h2><br>
					100% û�� �ѿ�<br><br>
					���� : <b>30,000��</b> <br> 
				</div>
			</div>
			<!-- �޴�2 -->
			<div><h3>�޴� 2</h3></div>
			<div id="menu_img">
				<img src="./img/event_img2.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>����� ������</b></h2><br>
					�Ϸ����� �õ��� ��<br><br>
					���� : <b>4,900��</b> <br> 
				</div>
			</div>
			<!-- �޴�3 -->
			<div><h3>�޴� 3</h3></div>
			<div id="menu_img">
				<img src="./img/event_img3.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>���� ��!</b></h2><br>
					�ʶ߷� ġ�� ��� ����<br><br>
					���� : <b>15,000��</b> <br> 
				</div>
			</div>
			<!-- �޴�4 -->
			<div><h3>�޴� 4</h3></div>
			<div id="menu_img">
				<img src="./img/event_img4.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>������ ���</b></h2><br>
					������ ������ ������ ���<br><br>
					���� : <b>3,000��</b> <br> 
				</div>
			</div>
			<!-- �޴�5 -->
			<div><h3>�޴� 5</h3></div>
			<div id="menu_img">
				<img src="./img/event_img5.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>í�� ���~</b></h2><br>
					������ í���� �ݼ����<br><br>
					���� : <b>8,000��</b> <br> 
				</div>
			</div>
			<!-- �޴�6 -->
			<div><h3>�޴� 6</h3></div>
			<div id="menu_img">
				<img src="./img/event_img6.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>���� ���ö�</b></h2><br>
					���� ���� ��� ���� ���ö�<br><br>
					���� : <b>6,000��</b> <br> 
				</div>
			</div>
			<!-- �޴�7 -->
			<div><h3>�޴� 7</h3></div>
			<div id="menu_img">
				<img src="./img/event_img7.png" alt="evnet" border="2">
				<div  class="menu_dis">
					<h2 id="menu_name"><b>������ ���ö�</b></h2><br>
					���������� ���ö�<br><br>
					���� : <b>4,500��</b> <br> 
				</div>
			</div>
			<br><br><br>			
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