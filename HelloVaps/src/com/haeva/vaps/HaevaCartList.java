package com.haeva.vaps;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.CartDAO;
import vapsVO.CartVO;

public class HaevaCartList implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CartDAO cdao = null;
		
		cdao = new CartDAO();
		
		ArrayList<CartVO> alist = null;
		
		HttpSession session = request.getSession();
		
		String user_id = (String) session.getAttribute("sessid");
		
		alist = cdao.cartList(user_id);
		
		request.setAttribute("alist2", alist);
		
	}

}
