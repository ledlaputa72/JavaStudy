<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>���� �����Ϸ� �Դ�</h2>
<% /* html + jsp */
String sid1=(String)session.getAttribute("sid1");
String spw1=(String)session.getAttribute("spw1");
if(!sid1.equals("babo") || !spw1.equals("ondal"))
{
	out.println("<h2>id ��ȣ �Է� �����Դϴ�. �α��� ȭ������ ���ϴ�. </h2>");
	out.println("<a href='_07_Request.html'>����</a>�� ��������<br>");
}else{
	out.println("<img src='kabang.jpg'>");
	//id ��ȣ�� ������ ���⿡ ��ǰ ��� ���ͼ� ����Ѵ�. 
}
%><br><br>
���̹��� �ѹ� ���� �ͺ��ô� 
<a href="http://www.naver.com">����</a>�� ��������<br>
</body>
</html>
