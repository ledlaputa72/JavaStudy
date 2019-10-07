package com.haeva.my;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelInfoDAO;
import telinfoVO.TelInfoVO;

public class HaevaSearchone implements HaevaImpl{

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		TelInfoVO tv = null;
		tidao1 = new TelInfoDAO();
		
		String name = request.getParameter("name");
		tv=tidao1.getInfo("name");
		
		request.setAttribute("sname", name);
		request.setAttribute("stv", tv);
		
	}

}
