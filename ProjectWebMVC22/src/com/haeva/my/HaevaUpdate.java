package com.haeva.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelInfoDAO;
import telinfoVO.TelInfoVO;

public class HaevaUpdate implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		TelInfoVO tv = null;

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String d = request.getParameter("d");
		//������� ������ ������ �Ѿ�´�. 
		String sname = request.getParameter("sname");
		//��ũ�� ������ �̸��� ��� �Ѱܹް� �ִ� (hidden)
		
		tidao1 = new TelInfoDAO();
		tidao1.update_all (id, name, tel, d, sname); //DAO���� �ش� �̸��� �����Ǿ� DB�� 
	}

}
