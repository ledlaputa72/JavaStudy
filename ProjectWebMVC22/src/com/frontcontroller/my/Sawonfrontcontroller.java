package com.frontcontroller.my;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("*.do") //1)
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
		
		//2)을 확인하기 위해서 콘솔에서 확인 /////////////
		String ru1 = request.getRequestURI();
		System.out.println(ru1);
		
		String cp1 = request.getContextPath();
		System.out.println(cp1);
		
		String c1 = ru1.substring(cp1.length());
		System.out.println(c1);
		//////////////////////////////////////////

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		/*****************************************/
		String c = request.getRequestURI().substring(request.getContextPath().length()); //2)
		/*****************************************/
		
		String str =null;
		HaevaImpl h1 = null; //부모
		
		switch (c) {
		//전체 정보를 보여주기 ////////////////
		case "/getAllInfo.do":
			h1 = new HaevaGetAllInfo();
			try { // 부모것으로 자식을 가리키는 것
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
		break;
		//한명의 정보를 보여주기 ////////////////
		case "/telSearchOne.do":
			h1 = new HaevaSearchone();
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "sawonUpdateForm.jsp";
		break;
		//정보 추가하기 /////////////////////
		case "/telInsert.do":
			h1 = new HaevaInsert();
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
		break;
		//업데이트 보여주기 ///////////////////
		case "/telUpdate.do":
			h1 = new HaevaUpdate();
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
		break;
		//데이터 지우기 //////////////////////
		case "/telDelete.do":
			h1 = new HaevaDelete();
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
		break;
		}
		
		RequestDispatcher rd1 = request.getRequestDispatcher(str);
		rd1.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
