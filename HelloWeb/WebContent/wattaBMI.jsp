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
	
		// get ��Ŀ����� server.xml �� 63 ���ο� URIEncoding="euc-kr" �� �߰������ �Ѵ�.	
		request.setCharacterEncoding("euc-kr"); // post �� �ѱ� ó�� ���
		response.setCharacterEncoding("euc-kr");
		
		
		String irum = request.getParameter("irum"); // �� : "ȫ�浿"
		String ki = request.getParameter("ki"); // �� : "180"
		String mom = request.getParameter("mom"); // �� : "78"
		
		double dKi = Double.parseDouble(ki); // �� : 180
		double dMom = Double.parseDouble(mom); // �� : 78
		
		double mKi = dKi / 100.0; // �� : 1.80
		double bmi = dMom / Math.pow(mKi, 2);
		
		String result = null;
		
		if (bmi >= 30.0)
			result = "��";
		
		else if (bmi >= 25.0)
			result = "��ü��";
		
		else if (bmi >= 20.0)
			result = "����";
		
		else
			result = "��ü��";
	
	%>
	
	<h2>����� Ű�� ������ BMI</h2> <br>
	
	�̸� : <%= irum %> <br>
	Ű : <%= ki %> cm <br>
	������ : <%= mom %> kg <br>
	BMI : <%= bmi %> <br>
	��� : <%= result %> <br>

</body>
</html>