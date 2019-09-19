package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.CartDAO;

public class HaevaCartInsert implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// �ѱ� ó��
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
		
		// ��ٱ��Ͽ� �޴��� ������ ��ٱ��Ͽ� �޴� insert
		if (count == 0)
			cdao.insert_cart(cno, user_id, menu, price, amount);
		
		// ��ٱ��Ͽ� �޴��� ������ ��ٱ��Ͽ� �޴� ���� update
		else
			cdao.update_cart(cno, user_id, menu, price, amount);
			
	}

}
