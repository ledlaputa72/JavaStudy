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
		
		// ������ ������ �Ѿ�´�.
		
//		int no = Integer.parseInt(request.getParameter("no"));
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		// ��ũ �� ������ �̸��� ��� �Ѱ� �ޱ� ���ؼ� (hidden)
		String sid = request.getParameter("sid");
		
		vdao = new VapsDAO();
		
		int no = vdao.getNo(sid);
		
		// DAO ���� �ش� �̸��� �����Ǿ� DB��
		vdao.update_all(no, id, name, email, tel, sid);
		
	}

}
