<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���Գ������</title>
</head>
<%                                //name�� ���� ��
String jong1 = request.getParameter("jong1"); //�޺��ڽ� - �ϳ��� 
    //jong <-- 200-�̿���ǰ
String[]  jepoomBae = request.getParameterValues("jepoom"); //üũ�ڽ�-������, �迭�� ��ƾ�  
    //"����", "�� ......"
String way1 = request.getParameter("way1");//������ư - �ϳ���
    //way1�̶�� �̸��� value --> ī��, ����...
    //������ if(...card1) ������ ���, �ѱ��̴ϱ� �״�� value�� ��� 
%>
<body>
<h2>���Գ��� </h2>

<table border="2" width="700">
<!--##################��ǰ ���� ��ȣ �� ����####################  -->
	<tr>
		<td bgcolor='#aaaaaa'>��ǰ ���� ��ȣ �� ����</td>
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
<!--##################��ǰ ����####################  -->	
	<tr>
		<td bgcolor='#aaaaaa'>��ǰ ����</td>
	</tr>
	<tr>
		<td>
			<%
			if(jepoomBae !=null){ //�迭�� ��ǥ���� null�� �ƴϸ� 
				for(int j=0; j < jepoomBae.length; j++) //üũ�� ���� ��ŭ�� �迭�� ������. 
					out.println(jepoomBae[j]+"<br>");
			}
			%>
		</td>
	</tr>
<!--#################���� ���#####################  -->
	<tr>
		<td bgcolor='#aaaaaa'>���� ���</td>
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
<!--#################�籸��#####################  -->	
	<tr>
		<td colspan=3>�ٽ� �����Ϸ���
		<a href="_36_ShoppingMall.html">����</a>�� ��������</td>
	</tr>
</table>
</body>
</html>