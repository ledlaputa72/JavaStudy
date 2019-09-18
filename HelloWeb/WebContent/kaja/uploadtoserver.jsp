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
<h2>Upload하자</h2>
<%
String bang ="e:/upbang";
//일단 입력 후 빨간줄 나오는 곳에 놓고 ctrl+space하면 import 된다. 
MultipartRequest mr1 = new MultipartRequest(request, bang, 10*1024*1024, "euc-kr", new DefaultFileRenamePolicy());
//MultipartRequest 는 5개의 인자로 되어있다. 
String virum1=mr1.getParameter("irum1");
String vfilename1=mr1.getFilesystemName("file1");
									//파일의 이름 얻기 
if(vfilename1 != null){
	out.println("사용자이름은"+virum1+"이시구요");
	out.println("추카추카"+ vfilename1 + "라는 파일 올리기 성공했네요");
}else{
	out.println("에러");
}
%>
</body>
</html>