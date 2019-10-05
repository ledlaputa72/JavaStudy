<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<meta name="Content-type" content="width=device-width", initial-scale="1"> 

<!-- 1. core style sheet : 필수 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shCore.min.css">
 
<!-- 2. theme style sheet : 택1 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shThemeDefault.min.css">
 
<!-- 3. core javascript : 필수 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shCore.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/styles/shThemeDefault.min.css">
 
<!-- 4. highlight 지원 언어 javascript : 지원할 언어만큼 선택 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushCss.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushJScript.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/SyntaxHighlighter/3.0.83/scripts/shBrushXml.min.js"></script>
 
<!-- SyntaxHighlighter 초기화 -->
<script type="text/javascript">
    /* 5. set config : option */
    // option 지정
 
    /* 6. set defaults : option */
    // option 지정
     
    /* 7. 초기화 : 필수 */
    SyntaxHighlighter.all();
</script>


<!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/custom.css">
<title>정연섭 포트폴리오 사이트</title>
</head>
<body>
	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
	%>


	<!-- 상단 네비게이션 바 -->
	<nav class="navbar navbar-default" id="nav_top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"><b>정연섭 포트폴리오</b> </a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a>

				<!-- 레스토랑 프로젝트  -->				
				<li class="dropdown active">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">레스토랑 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li  class="active"><a href="restoInfo.jsp">레스토랑 소개</a></li>
						<li><a href="http://www.ledlaputa.com/HelloVaps/main.jsp">레스토랑 이동</a>
					</ul>
				</li>
				
				<!-- jsp 게시판 프로젝트  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">게시판 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="bbsInfo.jsp">게시판 소개</a></li>
						<li><a href="bbs.jsp">게시판 이동</a>
					</ul>
				</li>
				
				<!-- 프로트앤드 프로젝트  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">프론트앤드 스터디<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="studyInfo.jsp">예제 소개</a></li>
						<li><a href="Portfolios/project02/index.html">[예제1] 반응형 웹 </a></li>
						<li><a href="Portfolios/project08/index.html">[예제2] 회전 웹 </a></li>
						<li><a href="Portfolios/project09/index.html">[예제3] Z축 스크롤 웹</a></li>
					</ul>
				</li>
				
			</ul>
			
			<%
				if(userID == null) {
			%>
			<!-- 접속중이 아닌 경우만 아래 내용이 보인다.  -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			 <%
				} else {
			 %>
			 <!-- 로그인인 경우 아래 내용이 보인다.  -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
			
		</div>
	</nav>
	
	<!-- 메인 영역 -->
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h2 id="main_title" > 레스토랑 MVC2 Team 프로젝트 </h2>
				<hr color="black">
					<h4>Model > Controller > View의 MVC2 모델로 계발. <br>
						Model & Controller를 Java Servlet으로 구현.<br>
						Tomcat 8.0.x / JSP 2.3 / Servlet 3.1 / Open JDK 1.8.x / MariaDB 10.1<br>
						HTML5 / CSS3 / Javascript / jQuery<br>
						MySQL(MariaDB)의 유저, 게시판, 장바구니 테이블과 데이터 운영<br>
						회원가입/로그인(중복체크)/게시판 CRUD/장바구니/CSS,jQuery 이용<br> <br>
						</h4>
				<a class="btn btn-primary btn-pull" href="http://www.ledlaputa.com/HelloVaps/main.jsp" role=button>사이트 방문하기</a>
			</div>
		</div>
	</div>
	
	<!-- 슬라이드 이미지 영역  -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" calss="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
				<li data-target="#myCarousel" data-slide-to="6"></li>
			</ol>
			<div class="carousel-inner" align="center" >
				<div class="item active">
					<img src="images/r1.JPG">
				</div>
				<div class="item">
					<img src="images/r2.JPG">
				</div>
				<div class="item">
					<img src="images/r3.JPG">
				</div>
				<div class="item">
					<img src="images/r4.JPG">
				</div>
				<div class="item">
					<img src="images/r5.JPG">
				</div>
				<div class="item">
					<img src="images/r6.JPG">
				</div>
				<div class="item">
					<img src="images/r7.JPG">
				</div>

			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
	<!-- 탭  -->
	
<br>	
<H3><b>Source 예제</b></H3><hr>		
<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#code01" aria-controls="code01" role="tab" data-toggle="tab">VapsFrontController.java</a></li>
    <li role="presentation"><a href="#code02" aria-controls="code02" role="tab" data-toggle="tab">CartDAO.java</a></li>
    <li role="presentation"><a href="#code03" aria-controls="code03" role="tab" data-toggle="tab">UserDAO.java</a></li>
    <li role="presentation"><a href="#code04" aria-controls="code04" role="tab" data-toggle="tab">HaevaLogin.java</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  
  
  
    <div role="tabpanel" class="tab-pane active" id="code01">
		<h4>MVC2 - Controller</h4>
		<pre class="brush:js;">

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

		</pre>
	</div>
    
    
    <div role="tabpanel" class="tab-pane" id="code02">
    	<h4>장바구니 DAO 메소드</h4>
		<pre class="brush:js;">
		
package vapsDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vapsDBConn.VapsDBConn;
import vapsVO.CartVO;

public class CartDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
/*	// 시작하자마자 생성자에서 접속 객체 get
	public CartDAO() throws ClassNotFoundException, SQLException {
		
		con = new VapsDBConn().getConnection();
	}*/
	
	public CartDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost/ledlaputa";
			String dbID = "ledlaputa";
			String dbPassword = "Ilovejayjung1!";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pstmtClose() throws SQLException {
		
		if (pstmt != null)
			pstmt.close();
		
	}
	
	public void getAllInfoClose() throws SQLException {
		
		if (rs != null)
			rs.close();
		
		if (pstmt != null)
			pstmt.close();
		
		if (con != null)
			con.close();
		
	}
	
	// 카트 목록 번호 조회하는 메소드
	public int getNo() throws SQLException {
		
		String sql = "SELECT MAX(cno) FROM cart";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		int cno = 0;
		
		if (rs.next())
			cno = rs.getInt(1);
		
		return cno;
		
	}

	// 카트에 추가하는 메소드
	public boolean insert_cart(int cno, String user_id, String menu, int price, int amount) throws SQLException {
		
		String sql = "INSERT INTO cart VALUES (?, ?, ?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, cno + 1);
		pstmt.setString(2, user_id);
		pstmt.setString(3, menu);
		pstmt.setInt(4, price);
		pstmt.setInt(5, amount);
		
		pstmt.executeUpdate();
		
		return true;
		
	}

	// 장바구니 목록 출력하는 메소드
	public ArrayList<CartVO> cartList(String user_id) throws SQLException {
		
		ArrayList<CartVO> carray = new ArrayList<CartVO>();
		
		String sql = "SELECT * FROM cart WHERE user_id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			int cno = rs.getInt("cno");
			
			String menu = rs.getString("menu");
			
			int price = rs.getInt("price");
			int amount = rs.getInt("amount");
			
			CartVO cv = new CartVO(cno, user_id, menu, price, amount);
			
			carray.add(cv);
			
		}
		
		return carray;
		
	}

	// 장바구니에 선택한 메뉴가 있는지 확인해주는 메소드
	public int countCart(String user_id, String menu) throws SQLException {
		
		String sql = "SELECT COUNT(*) FROM cart WHERE user_id = ? AND menu = ?";
		
		int count = 0;
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		pstmt.setString(2, menu);
		
		rs = pstmt.executeQuery();
		
		while (rs.next())
			count = rs.getInt(1);
			
		return count;
	}

	// 장바구니에 들어있는 메뉴의 수량 업데이트하는 메소드
	public boolean update_cart(int cno, String user_id, String menu, int price, int amount2) throws SQLException {
		
		String sql = "UPDATE cart SET amount = ? + amount WHERE user_id = ? AND menu = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, amount2);
		pstmt.setString(2, user_id);
		pstmt.setString(3, menu);

		pstmt.executeUpdate();
		
		return true;
		
	}

	// 장바구니의 메뉴 삭제하는 메소드
	public boolean delete_cart(int cno) throws SQLException {
		
		String sql = "DELETE FROM cart WHERE cno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, cno);
		
		pstmt.executeUpdate();
		
		return true;
		
	}
	
	

}

		</pre>
    </div>
    
    
    <div role="tabpanel" class="tab-pane" id="code03">
		<h4>사용자 DAO 메소드</h4>
		<pre class="brush:js;">
		
package vapsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vapsDBConn.VapsDBConn;
import vapsVO.VapsVO;

public class VapsDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
/*	// 시작하자마자 생성자에서 접속 객체 get
	public VapsDAO() throws ClassNotFoundException, SQLException {
			
		con = new VapsDBConn().getConnection();
	}*/
	
	public VapsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost/ledlaputa";
			String dbID = "ledlaputa";
			String dbPassword = "Ilovejayjung1!";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void pstmtClose() throws SQLException {
			
		if (pstmt != null)
			pstmt.close();
			
	}
		
	public void getAllInfoClose() throws SQLException {
			
		if (rs != null)
			rs.close();
			
		if (pstmt != null)
			pstmt.close();
			
		if (con != null)
			con.close();
			
	}
	
	public int login(String id, String pw) throws SQLException {
		
		String sql = "SELECT pw FROM member WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		// ID 가 존재한다면
		if (rs.next()) {
			
			// 패스워드가 일치한다면
			if (rs.getString(1).equals(pw))
				return 1;
			
			// 패스워드가 일치하지 않는다면
			else
				return 0;
			
		}
		
		// ID 가 존재하지 않는다면
		else
			return -1;
		
	}
	
	// 원하는 사원의 정보 검색하는 메소드
	public VapsVO getInfo(String oriId) throws SQLException {
			
		VapsVO vv = null;
			
		String sql = "SELECT * FROM member WHERE id = ?";
			
		pstmt = con.prepareStatement(sql);
			
		pstmt.setString(1, oriId);
			
		rs = pstmt.executeQuery();
			
		// rs 종이 박스에 해당 사원 정보가 있으면
		if (rs.next()) {
			
			int no = rs.getInt("no");				
			
			String id = rs.getString("id");
			String pw = rs.getString("pw");	
			String name = rs.getString("name");
			String email = rs.getString("email");
			String tel = rs.getString("tel");
				
			// 해당 사원 정보들을 모두 꺼내서 VO 그릇에 넣는다.
			vv = new VapsVO(no, id, pw, name, email, tel);
				
		}
			
		else
			vv = null;
			
		return vv;
			
	}
	
	public int getNo(String sid) throws SQLException {
		
		String sql = "SELECT no FROM member WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, sid);
		
		rs = pstmt.executeQuery();
		
		int no = 0;
		
		if (rs.next()) 
			no = rs.getInt(1);
		
		return no;
		
	}

	// 자신의 정보를 수정할 수 있는 메소드
	public boolean update_all(int no, String id, String name, String email, String tel, String sid) throws SQLException {
		
		String sql = "UPDATE member SET no = ?, id = ?, name = ?, email = ?, tel = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		pstmt.setString(5, tel);
		pstmt.setString(6, sid); // 링크로 넘어온 아이디
		
		pstmt.executeUpdate();
		
		return true;
		
	}
	public boolean join(String name, String id, String pw, String email, String tel ) throws SQLException {
		
		String sql = "insert into member"
	            + " (no,id,pw,name,email,tel)"
	            + " values"
//	            + " ((select NVL(MAX(no),0)+1 from member),?,?,?,?,?)";
	            + " ((SELECT IFNULL(MAX(no),0)+1 from member ALIAS_FOR_SUBQUERY),?,?,?,?,?)";
		

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2,  pw);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.setString(5, tel);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
			
		}
	
	// 아이디가 중복되었는지 검사하는 메소드
	public int confirmId(String id) throws SQLException {
			
			int x=-1;
			
			String sql = "SELECT id from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			
			rs = pstmt.executeQuery();
			if(rs.next())
				x= 1; //해당아이디 있음
			else
				x= -1; //해당아이디 없음
			
			
			
			return x;
			
		}

	// 아이디가 규칙에 맞는지 검사하는 메소드
	public void confirmId2(String id) {
	
		
	}

}

		    
		</pre>
	</div>
    	
		
    <div role="tabpanel" class="tab-pane" id="code04">
		<h4>로그인 로직</h4>
		<pre class="brush:js;">

	package com.haeva.vaps;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vapsDAO.VapsDAO;
import vapsVO.VapsVO;

public class HaevaLogin implements HaevaImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VapsDAO vdao = null;
		VapsVO vv = null;
		
		vdao = new VapsDAO();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		int status = vdao.login(id, pw);
		
		vv = vdao.getInfo(id);
		
		String msg = "";
		
		// 로그인에 성공하였다면
		if (status == 1) {
					
			request.setAttribute("sid", id);
			request.setAttribute("svv", vv);
					
			session.setAttribute("sessid", id);
			
		}
				
		// 로그인에 실패하였다면
		else {
					
			if (status == 0) 
				msg = "패스워드를 잘못 입력하였습니다.";
					
			else
				msg = "존재하지 않는 아이디입니다.";
					
			request.setAttribute("msg", msg);
					
			RequestDispatcher rd1 = request.getRequestDispatcher("errPage.jsp");
			
			rd1.forward(request, response);
					
		}
				
	}

}
		    
		</pre>
	</div>
    
    
  </div>
</div>
	
	

	
	
</body>
</html>