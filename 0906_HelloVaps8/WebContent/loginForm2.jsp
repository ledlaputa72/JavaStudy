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
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <style>
.container {
   width: 385px;
   line-height: 50px;
   margin:  auto;
}

h2 {
   text-align: center;
   color : white;
}

h2 span {
   color: rgb(242, 203, 97);
}

.login {
   background-color: rgb(242, 203, 97);
   color: white;
   border-radius: 5px;
   border: 0;
   padding: 10px 172px;
}

#signup {
   background-color: white;
   color: teal;
   border: 0;
   font-size: 17px;
}

p {
   text-align: center;
}

i {
   color: lightgray;
}
#title{
   position: absolute;
   top: 80px;
   margin: 0 200px;
   text-shadow: 4px 4px 4px #000;
}

#imail {
   position: absolute;
   top: 230px;
   margin: 0 355px;
}

#ipw {
   position: absolute;
   top: 280px;
   margin: 0 355px;
}

input {
   border: 1px solid lightgray;
   border-radius: 3px;
   box-shadow: 2px 2px 2px #000;
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
   			<i><h2>로그인</h2></i>
   		</div>
   		<!-- 내용입력  -->
			   <%
			      // 로그인되어 있지 않을 때
			      if (session.getAttribute("sessid") == null) {
			   %>
      
			   <div class="container">

			        <div id="imail">
			            <i class="material-icons">person_outline</i>
			        </div>
			        <div id="ipw">
			            <i class="material-icons">lock_outline</i>
			        </div>
			           <!-- <h2><span>로그인</span> 페이지입니다.</h2>
			       	 <hr /> -->
			        <br>
					   <form action="login.do" method="post">
					   
					          <input type="text" name="id" placeholder="아이디" required style="height:30px; width: 380px" >
					          <input type="password" name="pw" placeholder="비밀번호" required style="height:30px; width: 380px">
					          <input type="submit" value="LOGIN" class="login" required style="height:35px; width: 380px">
					          <input type="button" value="회원가입" onclick="goSignUpForm()" class="login" required style="height:35px; width: 380px"> 
					   
					   </form>
			   
					   <%
					      }
					   
					/*       // 로그인되었을 때
					      else { */
					         
					   %>
			   
			      
					   <%       
					   
					      String msg = (String)request.getAttribute("msg");
					   
					   %>
			   
			   			<%-- <h1> <%= msg %> </h1> --%>
			
			</div>
			
		<!--내용입력 -->
		</div>
		<div id="back_img"></div>
	</div>
</body>
</html>