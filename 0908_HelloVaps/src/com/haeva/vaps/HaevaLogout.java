package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;

public class HaevaLogout implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//				
//		VapsDAO vdao = null;
//		VapsVO vv = null;
//		
//		request.setAttribute("sid", null);
//		request.setAttribute("svv", null);
		
//		request.getSession().removeAttribute("sid");
//		request.getSession().removeAttribute("svv");
		
		request.removeAttribute("svv");
		
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		
		response.sendRedirect("loginForm.jsp");
		
	}
	
	

}
