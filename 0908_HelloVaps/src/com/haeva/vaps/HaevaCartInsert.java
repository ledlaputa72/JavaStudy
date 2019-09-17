package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.CartDAO;

public class HaevaCartInsert implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CartDAO cdao = null;
		
		cdao = new CartDAO();
		
		HttpSession session = request.getSession();
		
		int cno = cdao.getNo();
		
		String user_id = (String) session.getAttribute("sessid");
		String menu = request.getParameter("menu");
		
		int price = Integer.parseInt(request.getParameter("price"));		
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		int count = cdao.countCart(user_id, menu);
		
		// 장바구니에 메뉴가 없으면 장바구니에 메뉴 insert
		if (count == 0)
			cdao.insert_cart(cno, user_id, menu, price, amount);
		
		// 장바구니에 메뉴가 있으면 장바구니에 메뉴 수량 update
		else
			cdao.update_cart(cno, user_id, menu, price, amount);
			
	}

}
