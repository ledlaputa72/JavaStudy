package com.frontcontroller.vaps;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeva.vaps.HaevaBoardList;
import com.haeva.vaps.HaevaImpl;
import com.haeva.vaps.HaevaLogin;
import com.haeva.vaps.HaevaLogout;
import com.haeva.vaps.HaevaSearchone;
import com.haeva.vaps.HaevaUpdate;

/**
 * Servlet implementation class VapsFrontController
 */
@WebServlet("*.do")
public class VapsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VapsFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String c = request.getRequestURI().substring(request.getContextPath().length());
		
		String str = null;
		
		HaevaImpl h1 = null;
		
		switch (c) {
		
		case "/login.do" :
	
			h1 = new HaevaLogin();
			
			try {
				
				h1.haeva(request, response);
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "main.jsp";
			
			break;
			
		/*case "/logout.do" :
			
			h1 = new HaevaLogout();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "loginForm.jsp";
			
			break;*/
			
		case "/myPage.do" :
			
			h1 = new HaevaSearchone();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "myPage.jsp";
			
			break;
			
		case "/myPageUpdate.do" :
			
			h1 = new HaevaSearchone();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "myPageUpdate.jsp";
			
			break;
			
		case "/update.do" :
			
			h1 = new HaevaUpdate();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "myPage.jsp";
			
			break;
			
		case "/boder.do" :
			
			h1 = new HaevaBoardList();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "border.jsp";
			
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
