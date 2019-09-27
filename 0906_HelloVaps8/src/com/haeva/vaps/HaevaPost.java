package com.haeva.vaps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.BoardDAO;

public class HaevaPost implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BoardDAO bdao = null;
		
		bdao = new BoardDAO();
		
		int bno = bdao.getNo();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		String author = (String) session.getAttribute("sessid");
		
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		
		Date currentTime = new Date();

		String sDate = formatter.format(currentTime);
		
		int hitCount = 0;
		
		bdao.insert_post(bno, title, content, author, sDate, hitCount);
		
	}

}
