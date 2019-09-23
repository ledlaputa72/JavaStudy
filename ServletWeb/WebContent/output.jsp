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
    	kaja="A학점";
         break;
    case 9:
    	kaja="A학점";
         break;
    case 8:
    	kaja="B학점";
         break;
    case 7:
    	kaja="C학점";
         break;
    case 6:
    	kaja="D학점";
         break;     
    default:
    	kaja="F학점";
         break;
    }	

%>

이름은 <%=name %>이고 점수는 <%=score1 %>입니다.
학점은 <%=kaja %>입니다.  
</body>
</html>
