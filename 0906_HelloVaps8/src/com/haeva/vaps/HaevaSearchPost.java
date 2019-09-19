package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.BoardDAO;
import vapsVO.BoardVO;

public class HaevaSearchPost implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bdao = null;
		BoardVO bv = null;
				
		bdao = new BoardDAO();
					
		int bno = Integer.parseInt(request.getParameter("bno"));
			
		bv = bdao.borderView(bno);
					
		request.setAttribute("sbno", bno);
		request.setAttribute("sbv", bv);
		
	}

}
