<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="checkForm" method="post" action="confirmId.do" align="center">
	
		아이디를 입력하세요. <br>
		<input type="text" name="id">
		<input type="submit" value="ID 중복 확인">
	
	</form>	
	
	<script>
	
		function setid(){
			
			 opener.document.f1.id.value='${ checkedId }';
			 self.close();
	 	}
		
		// 아이디가 유효성 검사에 부합할 경우
		if (${ idChkValue2 } == false) {
			alert('아이디를 4~16 이내 영대소문자,숫자로 입력해주세요.');
		}
	
		// 입력한 아이디가 중복된 아이디일 경우
		if (${ idChkValue } == 1) { 
			
			alert('중복된 아이디입니다.');
			
		}
		
		// 입력한 아이디가 중복된 아이디가 아닐 경우
		else {
			
			document.write('<input type="button" value="사용" onclick="setid()">');
			
		}
		
	</script>
</body>
</html>