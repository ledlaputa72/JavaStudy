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
	
	<form action="myPageUpdate.do?id=${ svv.id }" method="post">
	
		<table border="1">
		
			<tr>
				<td>���̵�</td>
				<td>��й�ȣ</td>
				<td>�̸�</td>
				<td>�̸���</td>
				<td>��ȭ��ȣ</td>
			</tr>
			
			<tr>
				<input type="hidden" value="${ svv.no }" name="no">
				<td> ${ svv.id } </td>
				<td> ${ svv.pw } </td>
				<td> ${ svv.name } </td>
				<td> ${ svv.email } </td>
				<td> ${ svv.tel } </td>
				<input type="hidden" value="${ svv.id }" name="id">
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