package com.haeva.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//작은 관리자 (소 지배인 개념)
public interface HaevaImpl {
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
