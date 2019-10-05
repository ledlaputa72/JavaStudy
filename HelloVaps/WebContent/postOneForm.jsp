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
 	min-height : 600px;
 	border : 0%;
 	padding : 0%;
}

th {
	width : 20%;
}

td {
	width : 80%;
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

<script>

	function postDelete(bno) {
		
		var form = document.getElementById("boardForm");
		var url = "<c:url value='/postDelete.do'/>";
		
		url = url + "?bno=" + bno;
		
		form.action = url;
		form.submit();
		
	}
	
	function boardList() {
		
		var form = document.getElementById("boardForm");
		var url = "<c:url value='/border.do'/>";
		
		form.action = url;
		form.submit();
		
	}

</script>

</head>
<body background="./img/woodBg.png">

<!-- 로그인 정보 -->
<div class="login">
	<div class="login-box">

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
		<form id="boardForm" name="boardForm" action="postUpdate.do?bno=${ sbv.bno }" method="post">
		
			<table border="1" width="100%">
			
				<tr height="15">
					<td colspan="2">

						<c:if test="${ sessionScope.sessid  == sbv.author }">
							<input type="submit" value="수정">
							<input type="button" value="삭제" onclick="postDelete(${ sbv.bno })">
							
						</c:if>	
						
						<input type="button" value="목록" onclick="boardList()">
						
					</td>	
				</tr>	
				
				<tr height="15">
					<th>제목</th>
					<td> ${ sbv.title } </td>
				</tr>
				
				<tr height="15">
					<th>작성자</th>
					<td> ${ sbv.author } </td>
				</tr>
				
				<tr height="15">
					<th>작성 날짜</th>
					<td> ${ sbv.regDate } </td>
				</tr>
				
				<tr height="15">
					<th>조회수</th>
					<td> ${ sbv.hitCount } </td>
				</tr>	
				
				<tr height="300">
					<th>내용</th>
					<td> ${ sbv.content } </td>			
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