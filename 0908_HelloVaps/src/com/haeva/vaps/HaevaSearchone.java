package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;

public class HaevaSearchone implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
				
		VapsDAO vdao = null;
		VapsVO vv = null;
				
		vdao = new VapsDAO();
					
		String id = request.getParameter("id");
			
		vv = vdao.getInfo(id);
					
		request.setAttribute("sid", id);
		request.setAttribute("svv", vv);
		
	}

}
