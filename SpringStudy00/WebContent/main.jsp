<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<meta name="Content-type" content="width=device-width", initial-scale="1">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js' type='text/javascript'></script>
<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-83229-12']);
    _gaq.push(['_trackPageview']);

    (function() {
    	var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>
     
<!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/custom.css">
<title>정연섭 포트폴리오 사이트</title>
</head>
<body>
	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
	%>


	<!-- 상단 네비게이션 바 -->
	<nav class="navbar navbar-default" id="nav_top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"><b>정연섭 포트폴리오</b> </a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">메인</a>

				<!-- 레스토랑 프로젝트  -->				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">레스토랑 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="restoInfo.jsp">레스토랑 소개</a></li>
						<li><a href="http://www.ledlaputa.com/HelloVaps/main.jsp">레스토랑 이동</a>
					</ul>
				</li>
				
				<!-- jsp 게시판 프로젝트  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">게시판 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="bbsInfo.jsp">게시판 소개</a></li>
						<li><a href="bbs.jsp">게시판 이동</a>
					</ul>
				</li>
				
				<!-- 프로트앤드 프로젝트  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">프론트앤드 스터디<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="studyInfo.jsp">예제 소개</a></li>
						<li><a href="Portfolios/project02/index.html">[예제1] 반응형 웹 </a></li>
						<li><a href="Portfolios/project08/index.html">[예제2] 회전 웹 </a></li>
						<li><a href="Portfolios/project09/index.html">[예제3] Z축 스크롤 웹</a></li>
					</ul>
				</li>
				
			</ul>
			
			<%
				if(userID == null) {
			%>
			<!-- 접속중이 아닌 경우만 아래 내용이 보인다.  -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			 <%
				} else {
			 %>
			 <!-- 로그인인 경우 아래 내용이 보인다.  -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
			
		</div>
	</nav>
	
	<!-- 메인 영역 -->
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h2 id="main_title" > 정연섭 개발 포트폴리오</h2>
				<hr color="black">
					<h4>
					<ul>
						<li>MVC2 모델 웹 개발 : 레스토랑 사이트 구축 (팀 프로젝트)</li><br>
						<li>JSP/Servlet & Bootstrip 게시판 사이트 구축 </li><br>
						<li>프론트앤드 포트폴리오 사이트 : HTML5 / CSS3 / JavaScript / jQuery</li><br>
					</ul>
					</h4>
				<!-- <a class="btn btn-primary btn-pull" href="#" role=button>자세히 알아보기 </a> -->
			</div>
		</div>
	</div>
	
	<!-- 슬라이드 이미지 영역  -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" calss="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
				<li data-target="#myCarousel" data-slide-to="6"></li>
				<li data-target="#myCarousel" data-slide-to="7"></li>
				<li data-target="#myCarousel" data-slide-to="8"></li>
				<li data-target="#myCarousel" data-slide-to="9"></li>
			</ol>
			<div class="carousel-inner" align="center" >
				<div class="item active">
					<a href="http://www.ledlaputa.com/HelloVaps/main.jsp"><img src="images/r4.JPG"></a>
				</div>
				<div class="item">
					<a href="http://www.ledlaputa.com/HelloVaps/main.jsp"><img src="images/r5.JPG"></a>
				</div>
				<div class="item">
					<a href="http://www.ledlaputa.com/HelloVaps/main.jsp"><img src="images/r3.JPG"></a>
				</div>
				<div class="item">
					<a href="bbs.jsp"><img src="images/b1.JPG"></a>
				</div>
				<div class="item">
					<a href="bbs.jsp"><img src="images/b2.JPG"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project02/index.html"><img src="images/m1.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project02/index.html"><img src="images/m4.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project08/index.html"><img src="images/f1.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project08/index.html"><img src="images/f2.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project09/index.html"><img src="images/k3.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project09/index.html"><img src="images/k6.png"></a>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
	
	
</body>
</html>