package com.haeva.vaps;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.BoardDAO;
import vapsVO.BoardVO;

public class HaevaBoardList implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
						
		BoardDAO bdao = null;
						
		bdao = new BoardDAO();
		
		ArrayList<BoardVO> alist1 = null;
		
		alist1 = bdao.boardList();
		
		request.setAttribute("alist1", alist1);
		
	}

}
