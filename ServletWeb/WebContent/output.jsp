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
	String name = request.getParameter("name");
	String score1 = request.getParameter("score");
	int score = Integer.parseInt(score1);
	
	/* String kaja=null;
	
	if(score>=90)
		kaja = "A";
	else if (score>=80)
		kaja = "B";
	else if (score>=70)
		kaja = "C";
	else if (score>=60)
		kaja = "D";
	else
		kaja = "F"; */
	
	int score2 = score/10;
	
	String kaja= "";
	switch (score2) {
    case 10:
    	kaja="A����";
         break;
    case 9:
    	kaja="A����";
         break;
    case 8:
    	kaja="B����";
         break;
    case 7:
    	kaja="C����";
         break;
    case 6:
    	kaja="D����";
         break;     
    default:
    	kaja="F����";
         break;
    }	

%>

�̸��� <%=name %>�̰� ������ <%=score1 %>�Դϴ�.
������ <%=kaja %>�Դϴ�.  
</body>
</html>
