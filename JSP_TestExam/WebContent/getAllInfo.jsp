<%@page import="telinfoVO.TelInfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="telinfoDAO.TelInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
사원명단
<%
    request.setCharacterEncoding("euc-kr");
    response.setCharacterEncoding("euc-kr");

    TelInfoDAO tidao = new TelInfoDAO();
    ArrayList<TelInfoVO> tiArray = tidao.getAllInfo();
%>

<table border="2">
       <tr>
              <th>사번</th><th>이름</th><th>전화</th><th>입사일</th>
       </tr>
    <% for(TelInfoVO imsi : tiArray){ %>
       <tr>
              <td> <%=imsi.getId() %></td>
              <td> <%=imsi.getName() %></td>
              <td> <%=imsi.getTel() %></td>
              <td> <%=imsi.getD() %></td>
<% } %> 
       </tr>
</table>
</body>
</html>