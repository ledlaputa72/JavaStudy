<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="java.util.ArrayList" %>
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
		int pageNumber=1;
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
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
				<li class="dropdown  active">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">게시판 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="bbsInfo.jsp">게시판 소개</a></li>
						<li class="active"><a href="bbs.jsp">게시판 이동</a>
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
	
	<!-- 게시판 영역  -->
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color : #eeeeee; text-align: center;">번호</th>
						<th style="background-color : #eeeeee; text-align: center;">제목</th>
						<th style="background-color : #eeeeee; text-align: center;">작성자</th>
						<th style="background-color : #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<!-- 게시 리스트 보기 -->
				<tbody>
					<%
						BbsDAO bbsDAO = new BbsDAO();
						ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
						for(int i=0; i < list.size(); i++) {
					%>
					<tr>
						<td><%= list.get(i).getBbsID() %></td>
						<td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID() %>"><%= list.get(i).getBbsTitle() %></a></td>
						<td><%= list.get(i).getUserID() %></td>
						<td><%= list.get(i).getBbsDate().substring(0, 11) + list.get(i).getBbsDate().substring(11,13)+"시" + list.get(i).getBbsDate().substring(14,16)+ "분"%></td>
					</tr>					
					<%
						}
					%>
				</tbody>
			</table>
			<!-- 페이지 이전/다음  -->
			<%
				if(pageNumber != 1) {				
			%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber - 1 %>" class="btn btn-success btn-arrow-left">이전</a>
			<%
				} if(bbsDAO.nextPage(pageNumber + 1)) {			
			%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber + 1 %>" class="btn btn-success btn-arrow-left">다음</a>
			<%
				}
			%>
			
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>	
	</div>
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
