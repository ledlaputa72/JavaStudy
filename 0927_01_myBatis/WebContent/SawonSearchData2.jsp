<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
     import="java.util.*, com.Employee.DAOVO.*" 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	int sawonID=105;
	String sawonName="Austin";
%>
<h1><%=sawonID %>�� ��� ���� ���</h1>
<%
	EmployeeVO sawonOne=(EmployeeVO)EmployeeDAO.employeeSearchData2(sawonID,sawonName);
%>

<body>
	<table border="2">
		<tr>
			<th>���</th>
			<th>�̸�</th>
			<th>��</th>
			<th>�̸���</th>
			<th>��ȭ��ȣ</th>
			<th>�Ի���</th>
			<th>�޿�</th>
		</tr>

		<tr>
			<td> <%=sawonOne.getEmployee_id() %></td>
			<td> <%=sawonOne.getFirst_name() %></td>
			<td> <%=sawonOne.getLast_name() %></td>
			<td> <%=sawonOne.getEmail() %></td>
			<td> <%=sawonOne.getPhone_number() %></td>
			<td> <%=sawonOne.getHire_date() %></td>
			<td> <%=sawonOne.getSalary() %></td>
		</tr>
	</table>
</body>
</html>