package com.haeva.vaps;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.BoardDAO;
import vapsVO.BoardVO;

public class HaevaPostOne implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bdao = null;
		BoardVO bv = null;
		
		bdao = new BoardDAO();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			
			bdao.increaseHitCount(bno);
			
			bv = bdao.borderView(bno);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		request.setAttribute("sbno", bno);
		request.setAttribute("sbv", bv);
		
	}

}
