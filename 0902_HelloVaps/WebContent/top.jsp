<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>VAPS - �佺</title>

<!-- CSS  -->
<link rel="stylesheet" href="./css/main.css">

<!-- �����̵� ��������  -->
<script src="js/jquery.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/jquery.bxslider.min.css">
<style>
	*{margin: 0;padding: 0;}
	#gallery_wrap{
		margin: 0 auto;
		width: 1000px;
		background-color:#2B2119;	
	}
	
	#main_bg{
	background-size : contain;
	/* 
	cover : ��� ũ�� �����Ͽ� �̹����� Ȯ�� or ���, 
	auto :  ũ�� �״��,  
	contain : ��� ũ�� �����ϵ� ���μ��� ���� ���߾� 
	 */
 	background-image : url("./img/contents_bg2.jpg");
 	background-position : cneter; /* resize�� �׸� ��� ���̰�  */
 	min-height : 100%;
 	border : 0%;
 	padding : 0%;
}
</style>
<script>
$(function() {
	$('.slide_gallery').bxSlider({
		auto: true,
		autoControls: true,
		stopAutoOnClick: true,
		pager: true
	});
});
</script>
<!-- �����̵� ��������  -->
