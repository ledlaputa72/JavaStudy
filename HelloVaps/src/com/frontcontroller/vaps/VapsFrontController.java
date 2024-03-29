package com.frontcontroller.vaps;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeva.vaps.HaevaBoardList;
import com.haeva.vaps.HaevaCartDelete;
import com.haeva.vaps.HaevaCartInsert;
import com.haeva.vaps.HaevaCartList;
import com.haeva.vaps.HaevaConfirmId;
import com.haeva.vaps.HaevaImpl;
import com.haeva.vaps.HaevaJoin;
import com.haeva.vaps.HaevaLogin;
import com.haeva.vaps.HaevaPost;
import com.haeva.vaps.HaevaPostDelete;
import com.haeva.vaps.HaevaPostOne;
import com.haeva.vaps.HaevaPostUpdate;
import com.haeva.vaps.HaevaSearchPost;
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
			
		case "/border.do" :
			
			h1 = new HaevaBoardList();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "border.jsp";
			
			break;
			
		case "/post.do" :
			
			h1 = new HaevaPost();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "border.do";
			
			break;
			
		case "/postOne.do" :
			
			h1 = new HaevaPostOne();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "postOneForm.jsp";
			
			break;
			
		// 게시글 삭제	
		case "/postDelete.do" :
			
			h1 = new HaevaPostDelete();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "border.do";
			
			break;
			
		// 게시글 수정 화면으로
		case "/postUpdate.do" :
			
			h1 = new HaevaSearchPost();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "postOneFormUpdate.jsp";
			
			break;
			
		case "/updateBoard.do" :
			
			h1 = new HaevaPostUpdate();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "border.do";
			
			break;
			
		case "/cartInsert.do" :
			
			h1 = new HaevaCartInsert();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "cartList.do";
			
			break;
			
		case "/cartList.do" :
			
			h1 = new HaevaCartList();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "cartList.jsp";
			
			break;
			
		case "/cartDelete.do" :
			
			h1 = new HaevaCartDelete();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "cartList.do";
			
			break;
			
		case "/join.do" :
					
					h1 = new HaevaJoin();
					
					try {
						
						h1.haeva(request, response);
						
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
					str = "loginForm.jsp";
					
					break;
					
		case "/confirmId.do" :
			
			h1 = new HaevaConfirmId();
			
			try {
				
				h1.haeva(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			str = "confirmId.jsp";
			
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
