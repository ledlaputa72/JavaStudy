package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.BoardDAO;

public class HaevaPostDelete implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bdao = null;
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		bdao = new BoardDAO();
		
		bdao.delete_board(bno);
		
	}

}
