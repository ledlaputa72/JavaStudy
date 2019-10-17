$(function(){	
	
	// 동적으로 시퀀시 이미지 생성
	var imgs='';
	for(var i=0; i<200; i+=1){		
		imgs+="<img src='img/pic"+i+".jpg' />"		
	};
	$("section").html(imgs);
	
	//마우스 무브 시 이미지 시퀀스 순차적으로 보이기
	$("body").mousemove(function(e){
		var wid = $(window).width();
		var posX = e.pageX; 
		var percent = Math.floor((posX/wid)*200); 
		$("h4").text(percent);
		
		$("section>img").hide();
		$("section>img").eq(percent).show();
	});	
	
	//로딩바
	$('body').jpreLoader({
		splashID: "#jSplash",
		loaderVPos: '48%',
		autoClose: true,
		closeBtnText: "Let's Begin!"	
	});
	

});















