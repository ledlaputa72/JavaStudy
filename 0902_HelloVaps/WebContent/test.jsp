<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
</head>
<body>
       <div id="jido1" style="width: 500px; height:500px"></div>
</body>
</html>