package com.haeva.my;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import telinfoDAO.TelInfoDAO;
import telinfoVO.TelInfoVO;

public class HaevaGetAllInfo implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		
		try {
		
			tidao1 = new TelInfoDAO();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		ArrayList<TelInfoVO> alist1 = null;
		
		try {
			
			alist1 = tidao1.getAllInfo();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		request.setAttribute("alist1", alist1);
		
	}

}
