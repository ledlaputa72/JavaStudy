package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.BoardDAO;

public class HaevaPostUpdate implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bdao = null;
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		bdao = new BoardDAO();
		
		bdao.update_board(bno, title, content);
		
	}

}
