<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>if-else 문 - 좋아하는 색을 선택</h2>

<form action="ifTest.jsp" method="post">
	<dl>
		<dd>
			<label for="name">이름</lable>
			<input id="name" name="name" type="text" placeholder="홍길동" autofocus required >
		</dd>
		<dd>
			<label for="color">색 선택</label>
			<select id="color" name="color" required>
				<option value="blue" selected>파랑색
				<option value="green">초록색 
				<option value="red">빨강색
				<option value="yello">기타
			</select>
		</dd>
		<dd>
			<input type="submit" value="확인">
		</dd>			
	</dl>
</form> 
</body>
</html>