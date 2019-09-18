<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAPS - Border</title>

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
<!-- 테이블 칼라 -->   
<style>
  table {
    width: 800px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    margin: auto;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
    text-align: center;
  }
/*   thead tr {
    background-color: #0d47a1;
    color: #ffffff;
  } */
  tbody tr:nth-child(2n) {
    background-color: lightgray;
  }
  tbody tr:nth-child(2n+1) {
    background-color: white;
  }
</style>
<!-- 테이블 칼라 --> 

<link rel="stylesheet" href="./css/main.css">
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
			<div class="menu-item"><a href="./storeinfo.jsp"> <img src="./img/top2.png" alt="storeInfo"></a></div>
			<div class="menu-item logo"><a href="./main.jsp"><img src="./img/top3.png" alt="logo"></a></div>
			<div class="menu-item"><a href="./cart.jsp"><img src="./img/top4.png" alt="notice"></a></div>
			<div class="menu-item"><a href="./border.do"><img src="./img/top5.png" alt="border"></a></div>
		</div>
	</div>	
</header>
<!-- 메인 영역 -->
<div class="border_wrap" id="main_bg">
	<div class="border_header">
		<br>
		<form action="post.do" method="post">
		
			<table border="0" width="100%">
		
				<tr style="height:20%">
					<th style="text-align:center">제목</th>
					<td> <input type="text" name="title" style="width:80%; padding:5px" placeholder="제목을 입력하세요."> </td>
				</tr>
			
				<tr>
					<th style="text-align:center">내용</th>
					<td> <textarea name="content" style="width:80%; resize:none; padding:5px" placeholder="내용을 입력하세요." rows="25"></textarea> </td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align:center"> 
						<input type="submit" value="저장"> 
						<input type="button" onclick="history.back()" value="목록"> 
					</td>
				</tr>			
				
			</table>
		
		</form>
		
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