<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>온도 계산하기</h1>
	
	<form action="kyesan" method="get">
	
		<table border="1">
		
			<tr>
				<th>이름</th>
				<td> <input type="text" name="irum"> </td>
			</tr>
			
			<tr>
				<th>섭씨 온도</th>
				<td> <input type="text" name="condo"> </td>
			</tr>
			
			<tr>
				<th colspan="2"> <input type="submit" value="화씨 온도로 변환"> </th>
			</tr>						
		
		</table>
	
	</form>

</body>
</html>