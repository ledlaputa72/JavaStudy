<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page="top.jsp" flush="true"/>

<!-- ����  -->
<meta name="viewpot"  content="initial-scale=1.0, user-scalable=no">

<script src="https://maps.google.com/maps/api/js?senseor=false"></script>
<script>
       window.onload=function(){
              var joongang1 = new google.maps.LatLng(37.571001,126.992529);
              //�ش� ����, �浵�� ������ �߾����� ��ġ�ϱ� ���� ��
              var mapDesign1 = {zoom: 17, center: joongang1, mapTypeId :  google.maps.MapTypeId.ROADMAP};
              //var mapDesign1 = {zoom: 15, center: joongang1, mapTypeId :  google.maps.MapTypeId.HYBRID}; //��������
              var map = new  google.maps.Map(document.getElementById("jido1"),mapDesign1);
              //ȭ�鿡 ����ϴ� �� 
       }
</script>
<!-- ����  -->	

<jsp:include page="head.jsp" flush="true"/>


<!-- ���� ���� -->
<div class="store_wrap" id="main_bg">
	<br><br>	
	<div class="store_header">
		<table width="600px" border="0" align="center">
			<tr align="center">
				<td>
					<div><h2>���ô� ��</h2> </div>
				</td>
			</tr>
			<tr align="center">
				<td >
					<div class="store_map">
				 		<div id="jido1" style="width: 500px; height:500px"></div>
					</div>
				</td>
			</tr>
			<tr  align="center">
				<td>
					<div><h3> �ּ�  </h3></div>
				</td>
			</tr>
			<tr>
				<td>
					<div> <h4> ���� ���α� ����3�� �ܼ��� 5�� ITBank </h4> </div>
				</td>
			</tr>
			<tr>			
				<td>
					<div>   </div>
				</td>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp" flush="true"/>