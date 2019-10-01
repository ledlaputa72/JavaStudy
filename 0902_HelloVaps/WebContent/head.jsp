<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
</head>
<body background="./img/woodBg.png">

<!-- 로그인 정보 -->
<div class="login">
   <div class="login-box">
   
      <%= session.getAttribute("sessid") %> 님 <br> 
      
      <a href="logout.jsp">로그아웃</a> <br>
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