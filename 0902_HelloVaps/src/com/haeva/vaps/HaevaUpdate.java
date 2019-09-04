package com.haeva.vaps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;


public class HaevaUpdate implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VapsDAO vdao = null;
		VapsVO vv = null;
		
		// 수정된 내용이 넘어온다.
		
//		int no = Integer.parseInt(request.getParameter("no"));
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		// 링크 시 선택한 이름을 계속 넘겨 받기 위해서 (hidden)
		String sid = request.getParameter("sid");
		
		vdao = new VapsDAO();
		
		int no = vdao.getNo(sid);
		
		// DAO 에서 해당 이름이 수정되어 DB로
		vdao.update_all(no, id, name, email, tel, sid);
		
	}

}
