<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.*, com.Employee.DAOVO.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	List <EmployeeVO> list1=EmployeeDAO.employeeAllData();
	/*
	나는 employeeAllData() 메소드 호출로 끝
	selectList() --> <select * from employees 
	이걸 처리한 결과값이 return되므로 list 컬렉션객체로 들어감 
	*/
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
		<%} %> 
		</tr>
	</table>
</body>
</html>