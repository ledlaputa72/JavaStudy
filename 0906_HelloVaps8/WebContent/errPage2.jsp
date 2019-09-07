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

#err_msg{
	
	font-size: 20px;
	margin: auto;
	color : white;
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
   			<i><h2> 에러</h2></i>
   		</div>
   			<div class="contents_center">
   		<!-- 내용입력  -->
				
				<%
					String msg = (String)request.getAttribute("msg");
				%>
	
				<center><div id="err_msg"><%= msg %> </div>	</center>

		<!--내용입력 -->
			</div>
		</div>
		<div id="back_img"></div>
	</div>
</body>
</html>