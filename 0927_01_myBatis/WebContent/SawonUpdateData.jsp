<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.*"
    import="com.Employee.DAOVO.*"
%>

<%

EmployeeVO empvo2=new EmployeeVO("David", "Choi", 3000, 106);
EmployeeDAO.employeeUpdateData(empvo2);
List <EmployeeVO> list1=EmployeeDAO.employeeAllData();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
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
		<%
		for(EmployeeVO imsi:list1){
		%>
		<tr>
			<td> <%=imsi.getEmployee_id() %></td>
			<td> <%=imsi.getFirst_name() %></td>
			<td> <%=imsi.getLast_name() %></td>
			<td> <%=imsi.getEmail() %></td>
			<td> <%=imsi.getPhone_number() %></td>
			<td> <%=imsi.getHire_date() %></td>
			<td> <%=imsi.getSalary() %></td>
			<td> <%=imsi.getJob_id() %></td>
		<% } %>
		</tr>
	</table>
</body>
</html>