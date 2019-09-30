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
<h1><%=sawonID %>번 사원 정보 출력</h1>
<%
	EmployeeVO sawonOne=(EmployeeVO)EmployeeDAO.employeeSearchData2(sawonID,sawonName);
%>

<body>
	<table border="2">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>입사일</th>
			<th>급여</th>
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