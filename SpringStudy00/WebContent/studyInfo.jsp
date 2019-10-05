<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<meta name="Content-type" content="width=device-width", initial-scale="1"> 

<!-- 1. core style sheet : 필수 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shCore.min.css">
 
<!-- 2. theme style sheet : 택1 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shThemeDefault.min.css">
 
<!-- 3. core javascript : 필수 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shCore.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shThemeDefault.min.css">
 
<!-- 4. highlight 지원 언어 javascript : 지원할 언어만큼 선택 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushCss.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushJScript.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushXml.min.js"></script>
 
<!-- SyntaxHighlighter 초기화 -->
<script type="text/javascript">
    /* 5. set config : option */
    // option 지정
 
    /* 6. set defaults : option */
    // option 지정
     
    /* 7. 초기화 : 필수 */
    SyntaxHighlighter.all();
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
				<li><a href="main.jsp">메인</a>

				<!-- 레스토랑 프로젝트  -->				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">레스토랑 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li ><a href="restoInfo.jsp">레스토랑 소개</a></li>
						<li><a href="http://www.ledlaputa.com/HelloVaps/main.jsp">레스토랑 이동</a>
					</ul>
				</li>
				
				<!-- jsp 게시판 프로젝트  -->
				<li class="dropdown ">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">게시판 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="bbsInfo.jsp">게시판 소개</a></li>
						<li><a href="bbs.jsp">게시판 이동</a>
					</ul>
				</li>
				
				<!-- 프로트앤드 프로젝트  -->
				<li class="dropdown active">
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
				<h2 id="main_title" > 프론트 앤드 예제 스터디 </h2><hr>
					<h4> 
					포트폴리오/단순 홍보용 홈페이지 제작을 위한 프론트앤드 예제 <br>
					HTML5 / CSS3 / JavaScript / jQuery / BootStrip  <br>
					다양한 반응형 웹 레이아웃 스터디 <br>
					백앤드가 사용되지 않은 디자인 중심의 프론트앤드 예제  <br>
					</h4>
				<!-- <a class="btn btn-primary btn-pull" href="http://www.ledlaputa.com/HelloVaps/main.jsp" role=button>사이트 방문하기</a> -->
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
			</ol>
			<div class="carousel-inner" align="center" >
				<div class="item active">
					<a href="Portfolios/project02/index.html"><img src="images/m3.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project02/index.html"><img src="images/m2.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project02/index.html"><img src="images/m1.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project08/index.html"><img src="images/f1.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project08/index.html"><img src="images/f2.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project08/index.html"><img src="images/f4.png"></a>
				</div>
				<div class="item">
					<a href="Portfolios/project09/index.html"><img src="images/k1.png"></a>
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