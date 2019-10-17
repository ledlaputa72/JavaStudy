package com.haeva.vaps;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vapsDAO.VapsDAO;

public class HaevaConfirmId implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VapsDAO vdao = null;
		
		vdao = new VapsDAO();
		
		String id = request.getParameter("id").trim();
		
		System.out.println(id);
		
		// 아이디가 규칙에 맞는지 검사
		String reg1 = "^[A-Za-z0-9]{4,16}$";
		
		boolean validation = Pattern.matches(reg1, id);
		
		System.out.println(validation);
		
		// 아이디가 중복되었는지 검사
		int chk = vdao.confirmId(id);
		
		request.setAttribute("idChkValue", chk);
		request.setAttribute("checkedId", id);
		request.setAttribute("idChkValue2", validation);
		
	}

}
