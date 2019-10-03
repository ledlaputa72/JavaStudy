<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<meta name="Content-type" content="width=device-width", initial-scale="1"> 
<link rel="stylesheet" href="css/bootstrap.css">
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
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">정연섭 포트폴리오 </a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="main.jsp">메인</a>
				<li><a href="bbs.jsp">게시판 개발</a>
				<li><a href="bbs.jsp">프론트앤드 개발</a>
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
				<h1 > 정연섭 개발 포트폴리오</h1>
					<h3>이 웹 사이트는 개발 포트폴리오를 위하여 JSP로 만든 웹사이트 입니다. 
					프론트 엔드를 개발을 위한 HTML5/CSS/JavaScript 기술 사용과 백엔드 개발을 위한 JAVA/Servlet 기술, 
					아파치 톰캣 서버와 MySQL(MariaDB) 시스템을 운영 사용합니다.</h3> <br>
				<a class="btn btn-primary btn-pull" href="#" role=button>자세히 알아보기 </a>
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
			</ol>
			<div class="carousel-inner" align="center" >
				<div class="item active">
					<img src="images/1.png">
				</div>
				<div class="item">
					<img src="images/2.png">
				</div>
				<div class="item">
					<img src="images/3.png">
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