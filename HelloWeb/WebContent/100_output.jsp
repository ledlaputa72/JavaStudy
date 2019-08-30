<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구입내역출력</title>
</head>
<%                                //name에 대한 값
String jong1 = request.getParameter("jong1"); //콤보박스 - 하나만 
    //jong <-- 200-이월상품
String[]  jepoomBae = request.getParameterValues("jepoom"); //체크박스-여러개, 배열로 잡아야  
    //"구두", "옷 ......"
String way1 = request.getParameter("way1");//라디오버튼 - 하나만
    //way1이라는 이름의 value --> 카드, 현금...
    //영어라면 if(...card1) 현금을 출력, 한글이니까 그대로 value로 출력 
%>
<body>
<h2>구입내역 </h2>

<table border="2" width="700">
<!--##################제품 종류 번호 및 제목####################  -->
	<tr>
		<td bgcolor='#aaaaaa'>제품 종류 번호 및 제목</td>
	</tr>
	<tr>
		<td>
			<%
			if(jong1 !=null){
				out.println(jong1);
			}
			%>
		</td>
	</tr>
<!--##################제품 선택####################  -->	
	<tr>
		<td bgcolor='#aaaaaa'>제품 선택</td>
	</tr>
	<tr>
		<td>
			<%
			if(jepoomBae !=null){ //배열의 대표명이 null이 아니면 
				for(int j=0; j < jepoomBae.length; j++) //체크된 숫자 만큼만 배열이 잡힌다. 
					out.println(jepoomBae[j]+"<br>");
			}
			%>
		</td>
	</tr>
<!--#################구입 방법#####################  -->
	<tr>
		<td bgcolor='#aaaaaa'>구입 방법</td>
	</tr>
	<tr>
		<td>
			<%
			if(way1 !=null){
				out.println(way1);
			}
			%>
		</td>
	</tr>
<!--#################재구매#####################  -->	
	<tr>
		<td colspan=3>다시 구입하려면
		<a href="_36_ShoppingMall.html">여기</a>를 누르세요</td>
	</tr>
</table>
</body>
</html>