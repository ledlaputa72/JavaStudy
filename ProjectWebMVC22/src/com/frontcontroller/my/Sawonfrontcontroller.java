package com.frontcontroller.my;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeva.my.HaevaGetAllInfo;
import com.haeva.my.HaevaImpl;

/**
 * Servlet implementation class Sawonfrontcontroller
 */
//@WebServlet("/Sawonfrontcontroller")
@WebServlet("*.do")
public class Sawonfrontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sawonfrontcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		/*****************************************/
		String c = request.getRequestURI().substring(request.getContextPath().length());
		/*****************************************/
		
		String str =null;
		HaevaImpl scmd1 = null;
		
		switch (c) {
		case "/getAllInfo.do":
			scmd1 = new HaevaGetAllInfo();
			try {
				scmd1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;

		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
