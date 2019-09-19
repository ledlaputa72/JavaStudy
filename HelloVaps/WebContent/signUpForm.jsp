<%@ page import="vapsDAO.VapsDAO"%>
<%@ page import="vapsVO.VapsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>로그인</title>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	VapsDAO vdao = new VapsDAO();
	VapsVO vv = null;
	vv = vdao.getInfo(id);
%>

<style>
i {
	color: lightgray;
}

#title {
	position: absolute;
	top: 80px;
	margin: 0 200px;
	text-shadow: 4px 4px 4px #000;
}

.contents_center {
	width: 600px;
	margin: auto;
}
</style>

<!-- 가운데 폼 이미지  -->
<style>
div #back_img {
	width: 600px;
	margin: auto;
	border: 0px;
}

div #back_img:nth-child(1) {
	background-image: url("./img/Logo3.png");
	height: 141px;
	background-size: contain;
}

div #back_img:nth-child(2) {
	background-image: url("./img/inputBG1.png");
	height: 21px;
	background-size: contain;
}

div #back_img:nth-child(3) {
	background-image: url("./img/inputBG.png");
	height: 500px;
	height: 330px;
}

div #back_img:nth-child(4) {
	background-image: url("./img/inputBG2.png");
	height: 52px;
	background-size: contain;
}
</style>
<!-- 가운데 폼 이미지  -->

<style>
#main_bg {
	background-size: contain;
	/* 
	cover : 배경 크기 참조하여 이미지를 확대 or 축소, 
	auto :  크기 그대로,  
	contain : 배경 크기 참조하되 가로세율 비율 맞추어 
	 */
	background-image: url("./img/contents_bg2.jpg");
	background-position: cneter; /* resize시 그림 가운가 보이게  */
	min-height: 100%;
	border: 0%;
	padding: 0%;
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

function check2() {
	
	if(document.f1.id.value==<%=vv%>) {
		alert("ID중복 체크를 해주세요.");
		return false;
	}
	
	if(document.f1.id.value!=<%=vv%>) {
		
		var popupX = (window.screen.width/2 ) - (400/2);
		var popupY = (window.screen.height/2 ) - (150/2);
		
		url = "joinFormPopup.jsp"
		
		open(url, "join",
			"toolbar=no,location=no,status=no,scrollbars=no,resozable=no,width=400,height=150, , left="+ popupX + ", top="+ popupY);
			return true;
		}
	
	var reg1 = /^[A-Za-z0-9+]{4,16}$/;
	
	if(!reg1.test(document.f1.id.value)) {
		alert("아이디를 4~16 이내 영대소문자,숫자로 입력해주세요.");
//		f1.id.focus();
		return false;
	}
	
	if(document.f1.pw.value.length < 6) {
		alert("비밀번호가  짧습니다.");
		
		return false;
	}
	
	if(!document.f1.id.value) {
		alert("ID를 입력 하세요.");
//		f1.id.focus();
		return false;
	}
	
	
	if(document.f1.id.value == document.f1.pw.value || document.f1.id.value == document.f1.pw2.value) {
		alert("ID와 비밀번호가 똑같 습니다.");
		f1.pw.focus();
		return false;
	}
	if(!document.f1.pw.value && !document.f1.pw2.value) {
		alert("비밀번호를 입력하세요.");
		f1.pw.focus();
		return false;
	}
	if(document.f1.pw.value != document.f1.pw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		f1.pw.focus();
		return false;
	} 
	if(!document.f1.name.value) {
		alert("사용자 이름을 입력하세요.");
		f1.name.focus();
		return false;
	}
	if(!document.f1.email.value) {
		alert("Email을 입력하세요.");
		f1.email.focus();
		return false;
	}
	if(!document.f1.tel.value) {
		alert("전화번호를 입력하세요.");
		f1.tel.focus();
		return false;
	}
}



function idCheck(f1) {
	
	var reg1 = /^[A-Za-z0-9+]{4,16}$/;
	
	
	
	
	
	
	var popupX = (window.screen.width/2 ) - (400/2);
	var popupY = (window.screen.height/2 ) - (200/2);
	// ID중복체크창 화면 가운데로
	
	url = "confirmId.jsp?id=" + f1.id.value;
	
	open(url, "confirm",
		"toolbar=no,location=no,status=no,scrollbars=no,resozable=no,width=400,height=200, , left="+ popupX + ", top="+ popupY);
}

function pwCh() {
	if(f1.pw.value=="" && f1.pw2.value == "") {
		document.getElementById("same").innerHTML="비밀번호를 입력하세요.";
	}
	else if(f1.pw2.value =="")
		document.getElementById("same").innerHTML="";
	
	else if(f1.pw.value == f1.pw2.value) {
		document.getElementById("same").innerHTML="비밀번호가 일치 합니다.";
		document.getElementById("same").style.color="blue";
		document.getElementById("same").style.fontSize="12px";
	}
		
	else {
		document.getElementById("same").innerHTML="비밀번호가 일치하지 않습니다.";
		document.getElementById("same").style.color="red";
		document.getElementById("same").style.fontSize="12px";
		f1.pw2.focus();
	}
	
	
}

</script>
</head>
<body background="./img/woodBg.png">
	<div id="back_img">
		<div id="back_img"></div>
		<div id="back_img"></div>
		<div id="back_img">
			<!-- 타이틀 -->
			<div id="title">
				<i><h3>회원 가입</h3></i>
			</div>
			<div class="contents_center">
				<!-- 내용입력  -->

				<form action="join.do" method="post" name=f1
					onsubmit="return check2()">

					<table width="520" height="350" border=1 align="center">


						<tr>
							<td align="center">ID</td>
							<td style="padding-left: 10px;"><input type="text" name="id"
								size=20 maxlength=50 placeholder="ID 입력" readonly>&nbsp;
								<input type="button" value="중복확인" name="confirm_id"
								Onclick="idCheck(this.form)"><br> <font size="1px">*
									ID는 영대소문자,숫자 섞어서 4~16글자 입력</font> <input type="hidden" name="idUn"
								value="iduncheck"></td>
						</tr>

						<tr>
							<td align="center">비밀번호</td>
							<td style="padding-left: 10px;"><input type="password"
								name="pw" size=20 maxlength=16 placeholder="비밀번호 입력 6~16"
								required id="pwpw"></td>
						</tr>



						<tr>
							<td align="center">비밀번호 확인</td>
							<td style="padding-left: 10px;"><input type="password"
								name="pw2" size=20 maxlength=16 placeholder="비밀번호 입력 6~16"
								required id="pwCheck" onkeyup="pwCh(this);">&nbsp;&nbsp;
								<span id="same"></span></td>
						</tr>

						<tr>
							<td align="center">이름</td>
							<td style="padding-left: 10px;"><input type="text"
								name="name" size=20 maxlength=50 placeholder="이 름 입 력"></td>
						</tr>

						<tr>
							<td align="center">이메일</td>
							<td style="padding-left: 10px;"><input type="text"
								name="email" size=20 placeholder="aa@naver.com" required></td>
						</tr>

						<tr>
							<td align="center">전화번호</td>
							<td style="padding-left: 10px;"><input type="text"
								name="tel" size=20 maxlength=20 placeholder="010-1111-2222"
								required></td>
						</tr>
						<tr>
							<td colspan=2 align="center"><input type="submit"
								value="가입하기" name="join"> <input type="reset" value="취소"
								onclick="history.back(-1);"></td>
						</tr>
					</table>
					<br>
				</form>

				<!--내용입력 -->
			</div>
		</div>
		<div id="back_img"></div>
	</div>
</body>
</html>