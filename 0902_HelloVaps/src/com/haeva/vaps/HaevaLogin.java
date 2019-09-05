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

		// �ѱ� ó��
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
		
		// �α��ο� �����Ͽ��ٸ�
		if (status == 1) {
					
			request.setAttribute("sid", id);
			request.setAttribute("svv", vv);
					
			session.setAttribute("sessid", id);
			
		}
				
		// �α��ο� �����Ͽ��ٸ�
		else {
					
			if (status == 0) 
				msg = "�н����带 �߸� �Է��Ͽ����ϴ�.";
					
			else
				msg = "�������� �ʴ� ���̵��Դϴ�.";
					
			request.setAttribute("msg", msg);
					
			RequestDispatcher rd1 = request.getRequestDispatcher("errPage.jsp");
			
			rd1.forward(request, response);
					
		}
				
	}

}
