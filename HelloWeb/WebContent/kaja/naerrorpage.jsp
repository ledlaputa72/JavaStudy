<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true" %>
    
<% response.setStatus(200); %>

<%-- 
	404	500		...
	정상 200
	이 페이지는 오류 없습니다. 그러니 결과를 잘 출력합니다.
 --%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<pre>
	
		다음과 같은 에러가 발생했습니다.
		계속 에러가 발생되면 상담원에게 전화주시기 바랍니다.
		전화 번호는 02-3456-5577 입니다.
	
	</pre>
	
	<hr>
	
	<!-- 예 : 나이를 빈 칸으로 처리한 경우 에러 내용은 For input string : "" -->
	에러 내용은 <h3> <%= exception.getMessage() %> </h3>

</body>
</html>