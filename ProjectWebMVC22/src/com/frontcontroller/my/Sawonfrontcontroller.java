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

//		String ru1 = request.getRequestURI();		
//		System.out.println(ru1); // /HelloServletJsp/*.do		
//		String cp1 = request.getContextPath();		
//		System.out.println(cp1); // /HelloServletJsp		
//		String c1 = ru1.substring(cp1.length());		
//		System.out.println(c1); // /*.do		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String c = request.getRequestURI().substring(request.getContextPath().length()); //2)
		String str = null;
		HaevaImpl h1 = null;
		
		switch (c) {
		case "/getAllInfo.do" :
			
			h1 = new HaevaGetAllInfo(); // 부모의 것으로 자식을 가리키는 것			
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
			
			break;
/*			
		case "/telSearchOne.do" :
			h1 = new HaevaSearchone(); //HaevaSearchone.java
			try {
					h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "sawonUpdateForm.jsp";
			
			break;
			
		case "/telInsert.do" :
			h1 = new HaevaInsert(); //HaevaInsert.java
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
			
			break;
			
		case "/telUpdate.do" :
			h1 = new HaevaUpdate(); //HaevaUpdate.java
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
			
			break;
			
		case "/telDelete.do" :
			h1 = new HaevaDelete(); //HaevaDelete.java
			try {
				h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			str = "getAllInfo.jsp";
			
			break;
*/			
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
