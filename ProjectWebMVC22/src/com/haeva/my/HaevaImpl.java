package com.haeva.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HaevaImpl {
	
	// interface 이므로 서블릿 메소드 선언만 한다.
	// 자바 클래스에서 메소드를 상속받아 구현해야 한다.
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception;
		
		
	
}
