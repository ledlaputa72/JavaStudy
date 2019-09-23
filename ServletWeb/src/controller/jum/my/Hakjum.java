package controller.jum.my;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hakjum
 */
@WebServlet("/Hakjum")
public class Hakjum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hakjum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response); //method ȣ�⹮ 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");;
		response.setContentType("text/html);charset=EUC-KR");
		String irum=request.getParameter("irum");
		String jum1=request.getParameter("jum");
		int jum = Integer.parseInt(jum1);
		
		String kaja = null;
		
		if(jum>=90) {
			kaja = "A.jsp";
		}else if (jum>=80) {
			kaja = "B.jsp";
		}else if (jum>=70) {
			kaja = "C.jsp";
		}else if (jum>=60) {
			kaja = "D.jsp";
		}else {
			kaja = "F.jsp"; 
		}
		request.getRequestDispatcher("./jspview/"+kaja).forward(request, response);
		//jsp:forward
	}

}
