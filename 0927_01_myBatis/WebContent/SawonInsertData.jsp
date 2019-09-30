<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.*"
    import="com.Employee.DAOVO.*"
    %>
 <!-- 참고로 여기 한글처리하는 euc-kr이 왜 두번 있을까 
 이건 mvc에서 더 중요 
 (1)contentType = "text/html; charset=EUC-KR"는 html등등처리 
 (2)pageEncoding="EUC-KR"는 자바코드 한글 처리  
 
 (3)참고로 web.xml에 적은 한글깨짐처리는 controller에서 view로 보내는 한글처리 등을 잘 완성 시킴
-->
 
 <%
/* 사번, 이름, 성, 이메일, 전화, 입사일, 급여, job_id */
/* employee_id email unique 에러 주의  */

EmployeeVO empvo1=new EmployeeVO (230, "David", "Kim","DEFERDFD01", "010-7777-3333", "13-12-05", 3000, "ST_CLERK");
EmployeeDAO.employeeInsertData(empvo1);
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
			<td> <%=imsi.getJob_id() %></td>
		<% } %>
		</tr>
	</table>
</body>
</html>