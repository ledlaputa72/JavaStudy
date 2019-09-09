package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.CartDAO;

public class HaevaCartDelete implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CartDAO cdao = null;
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		cdao = new CartDAO();
		
		cdao.delete_cart(cno);
		
	}

}
