<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>���� ������</h1>
	
	<hr>
	
	<form action="update.do?sid=${ svv.id }" method="post">
	
		<table border="1">
		
			<tr>
				<td>���̵�</td>
				<td>��й�ȣ</td>
				<td>�̸�</td>
				<td>�̸���</td>
				<td>��ȭ��ȣ</td>
			</tr>
			
			<tr>
				<td> <input type="text" value="${ svv.id }" name="id"> </td>
				<td> <input type="text" value="${ svv.pw }" name="pw"> </td>
				<td> <input type="text" value="${ svv.name }" name="name"> </td>
				<td> <input type="text" value="${ svv.email }" name="email"> </td>
				<td> <input type="text" value="${ svv.tel }" name="tel"> </td>
				<input type="hidden" value="${ svv.id }" name="sid">
			</tr>
			
			<tr>
				<td colspan="5">
					<input type="submit" value="����">
					<input type="reset" value="���">
				</td>
			</tr>			
		
		</table>
	
	</form>
	
	<br>
	
	<input type="button" onclick="history.back()" value="��������">
	
</body>
</html>