<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	
		// get 방식에서는 server.xml 의 63 라인에 URIEncoding="euc-kr" 을 추가해줘야 한다.	
		request.setCharacterEncoding("euc-kr"); // post 의 한글 처리 방식
		response.setCharacterEncoding("euc-kr");
		
		
		String irum = request.getParameter("irum"); // 예 : "홍길동"
		String ki = request.getParameter("ki"); // 예 : "180"
		String mom = request.getParameter("mom"); // 예 : "78"
		
		double dKi = Double.parseDouble(ki); // 예 : 180
		double dMom = Double.parseDouble(mom); // 예 : 78
		
		double mKi = dKi / 100.0; // 예 : 1.80
		double bmi = dMom / Math.pow(mKi, 2);
		
		String result = null;
		
		if (bmi >= 30.0)
			result = "비만";
		
		else if (bmi >= 25.0)
			result = "과체중";
		
		else if (bmi >= 20.0)
			result = "보통";
		
		else
			result = "저체중";
	
	%>
	
	<h2>당신의 키와 몸무게 BMI</h2> <br>
	
	이름 : <%= irum %> <br>
	키 : <%= ki %> cm <br>
	몸무게 : <%= mom %> kg <br>
	BMI : <%= bmi %> <br>
	결과 : <%= result %> <br>

</body>
</html>