<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page="top.jsp" flush="true"/>

<!-- 지도  -->
<meta name="viewpot"  content="initial-scale=1.0, user-scalable=no">

<script src="https://maps.google.com/maps/api/js?senseor=false"></script>
<script>
       window.onload=function(){
              var joongang1 = new google.maps.LatLng(37.571001,126.992529);
              //해당 위도, 경도를 지도의 중앙으로 위치하기 위한 것
              var mapDesign1 = {zoom: 17, center: joongang1, mapTypeId :  google.maps.MapTypeId.ROADMAP};
              //var mapDesign1 = {zoom: 15, center: joongang1, mapTypeId :  google.maps.MapTypeId.HYBRID}; //위성사진
              var map = new  google.maps.Map(document.getElementById("jido1"),mapDesign1);
              //화면에 출력하는 것 
       }
</script>
<!-- 지도  -->	

<jsp:include page="head.jsp" flush="true"/>


<!-- 메인 영역 -->
<div class="store_wrap" id="main_bg">
	<br><br>	
	<div class="store_header">
		<table width="600px" border="0" align="center">
			<tr align="center">
				<td>
					<div><h2>오시는 길</h2> </div>
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
					<div><h3> 주소  </h3></div>
				</td>
			</tr>
			<tr>
				<td>
					<div> <h4> 서울 종로구 종로3가 단성사 5층 ITBank </h4> </div>
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