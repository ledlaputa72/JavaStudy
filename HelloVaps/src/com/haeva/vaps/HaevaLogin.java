package com.haeva.vaps;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;

public class HaevaLogin implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VapsDAO vdao = null;
		VapsVO vv = null;
		
		vdao = new VapsDAO();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		int status = vdao.login(id, pw);
		
		vv = vdao.getInfo(id);
		
		String msg = "";
		
		// 로그인에 성공하였다면
		if (status == 1) {
					
			request.setAttribute("sid", id);
			request.setAttribute("svv", vv);
					
			session.setAttribute("sessid", id);
			
		}
				
		// 로그인에 실패하였다면
		else {
					
			if (status == 0) 
				msg = "패스워드를 잘못 입력하였습니다.";
					
			else
				msg = "존재하지 않는 아이디입니다.";
					
			request.setAttribute("msg", msg);
					
			RequestDispatcher rd1 = request.getRequestDispatcher("errPage.jsp");
			
			rd1.forward(request, response);
					
		}
				
	}

}
