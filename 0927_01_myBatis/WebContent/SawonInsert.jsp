<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.*, com.Employee.DAOVO.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="SawonInsertData.jsp" method="get">
		<table border="2">
			<tr>
				<td>���</td><th><input type="number" name="sawonID"></th>
			</tr>
			<tr>
				<td>�̸�</td><th><input type="text" name="sawonLastName"></th>
			</tr>
			<tr>
				<td>��</td><th><input type="text" name="sawonFirstName"></th>
			</tr>
			<tr>
				<td>�̸���</td><th><input type="text" name="sawonEmail"></th>
			</tr>
			<tr>
				<td>��ȭ��ȣ</td><th><input type="text" name="sawonPhoneNumber"></th>
			</tr>
			<tr>
				<td>�Ի���</td><th><input type="text" name="sawonHireDate"></th>
			</tr>
			<tr>
				<td>�޿�</td><th><input type="number" name="sawonSalary"></th>
			</tr>
						<tr>
				<td>�޿�</td><th><input type="number" name="sawonJobID"></th>
			</tr>
			<tr>
				<td><input type="submit" value="Ȯ��"></td><td><input type="reset" value="���"></td>
			</tr>
		</table>	
	</form>
</body>
</html>