package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;

public class HaevaLogout implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		request.removeAttribute("svv");
		
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		
		response.sendRedirect("loginForm.jsp");
		
	}
	
	

}
