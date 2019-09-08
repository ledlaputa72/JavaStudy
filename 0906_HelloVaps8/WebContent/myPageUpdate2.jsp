<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>로그인</title>
<style>
i {
   color: lightgray;
}

#title{
   position: absolute;
   top: 80px;
	right : 100px;   
  
   margin: 0 400px;
   text-shadow: 4px 4px 4px #000;
}

.contents_center{
	width : 600px;
	margin: auto;
}

</style>

<!-- 가운데 폼 이미지  -->
<style>
	div #back_img{
		width : 600px;
		margin : auto;
		border : 0px;
	}
	div #back_img:nth-child(1){
		background-image: url("./img/Logo3.png");
		height: 141px;
		background-size: contain;
	}
	div #back_img:nth-child(2){
		background-image: url("./img/inputBG1.png");
		height: 21px;
		background-size: contain;
	}
	div #back_img:nth-child(3){
		background-image: url("./img/inputBG.png");
		height: 500px;
		height: 330px;
	}
	div #back_img:nth-child(4){
		background-image: url("./img/inputBG2.png");
		height: 52px;
		background-size: contain;
	}
</style>
<!-- 가운데 폼 이미지  -->

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
    width: 500px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
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

<script>

   function goSignUpForm() {
   
      location.href = "signUpForm.jsp";
   
   }

</script>
</head>
<body  background="./img/woodBg.png">
	<div id="back_img">
		<div id="back_img"></div>
		<div id="back_img"></div>
		<div id="back_img">
		<!-- 타이틀 -->
   		<div id="title">
   			<i><h2> <%= session.getAttribute("sessid") %> 님의 마이 페이지 수정 화면</h2></i>
   		</div>
   			<div class="contents_center">
   		<!-- 내용입력  -->
				
				<form action="update.do?sid=${ svv.id }" method="post">
	
					<table border="0" align="center" width="500px" >
						<tr>
							<td>아이디</td>
							<td><input type="text" value="${ svv.id }" name="id"> </td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td> <input type="text" value="${ svv.pw }" name="pw"> </td>
						</tr>
						
						<tr>
							<td>이름</td>
							<td> <input type="text" value="${ svv.name }" name="name"> </td>
						</tr>
						
						<tr>
							<td>이메일</td>
							<td> <input type="text" value="${ svv.email }" name="email"> </td>
						</tr>
						
						<tr>
							<td>전화번호</td>
							<td> <input type="text" value="${ svv.tel }" name="tel"> </td>
						</tr>
						
						<tr>
							<td colspan="2">
							<input type="hidden" value="${ svv.id }" name="sid">
							<input type="submit" value="수정">
							<input type="reset" value="취소">
							</td>
						</tr>
						<tr>
							<td colspan="2">
							<input type="button" onclick="history.back()" value="마이페이지로">
							</td>
						</tr>			
					
					</table>
				
				</form>

		<!--내용입력 -->
			</div>
		</div>
		<div id="back_img"></div>
	</div>
</body>
</html>