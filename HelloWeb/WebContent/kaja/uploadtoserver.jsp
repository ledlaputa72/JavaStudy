<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Upload����</h2>
<%
String bang ="e:/upbang";
//�ϴ� �Է� �� ������ ������ ���� ���� ctrl+space�ϸ� import �ȴ�. 
MultipartRequest mr1 = new MultipartRequest(request, bang, 10*1024*1024, "euc-kr", new DefaultFileRenamePolicy());
//MultipartRequest �� 5���� ���ڷ� �Ǿ��ִ�. 
String virum1=mr1.getParameter("irum1");
String vfilename1=mr1.getFilesystemName("file1");
									//������ �̸� ��� 
if(vfilename1 != null){
	out.println("������̸���"+virum1+"�̽ñ���");
	out.println("��ī��ī"+ vfilename1 + "��� ���� �ø��� �����߳׿�");
}else{
	out.println("����");
}
%>
</body>
</html>