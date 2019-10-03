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
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">레스토랑 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li ><a href="restoInfo.jsp">레스토랑 소개</a></li>
						<li><a href="http://www.ledlaputa.com/HelloVaps/main.jsp">레스토랑 이동</a>
					</ul>
				</li>
				
				<!-- jsp 게시판 프로젝트  -->
				<li class="dropdown active">
					<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown" role="button" aria-haspopup="true" 
					aria-expanded="false">게시판 프로젝트<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li  class="active"><a href="bbsInfo.jsp">게시판 소개</a></li>
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
				<h2 id="main_title" > JSP/Servlet 기반 게시판 </h2>
					<hr color="black">
					<h4>
						BootStrip을 활용한 JSP/Servlet 기반의 심플 게시판 <br>
						Tomcat 8.0.x / JSP 2.3 / Servlet 3.1 / Open JDK 1.8.x / MariaDB 10.1 <br>
						HTML5 / CSS3 / Javascript / BootStrip <br>
						MySQL(MariaDB)의 유저, 게시판 테이블과 데이터 운영 <br>
						부트스트립을 활용 간편한 회원 가입/로그인 및 게시판 개발 <br> <br>
					</h4>
				<a class="btn btn-primary btn-pull" href="bbs.jsp" role=button>사이트 방문하기</a>
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
			</ol>
			<div class="carousel-inner" align="center" >
				<div class="item active">
					<img src="images/b1.JPG">
				</div>
				<div class="item">
					<img src="images/b2.JPG">
				</div>
				<div class="item">
					<img src="images/b3.JPG">
				</div>
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
	
		<!-- 탭 -->
	
<br>	
<H3><b>Source 예제</b></H3><hr>		
<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#code01" aria-controls="code01" role="tab" data-toggle="tab">BbsDAO.java</a></li>
    <li role="presentation"><a href="#code02" aria-controls="code02" role="tab" data-toggle="tab">UserDAO.java</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="code01">
		<h4>게시판 관련  DAO 메소드</h4>
		<pre class="brush:js;">

package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;

	//접속 객체 - Data Base 접속 
	public BbsDAO() {
		try {
//			String dbURL = "jdbc:mysql://localhost/ledlaputa";
			String dbURL = "jdbc:mysql://ledlaputa.com:3306/ledlaputa";
			String dbID = "ledlaputa";
			String dbPassword = "Ilovejayjung1!";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//날짜 가져오기 ////////////////////////////////
	public String  getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ""; //데이터 베이스 오류 
	}
	
	//게시물 번호 부여하기 ////////////////////////////////
	public int  getNext() {
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1; //게시물에 번호 1을 증가 시킴 
			}
			return 1; //첫번째 게시물인 경우 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	
	//글 작성하기 /////////////////////////////////////////
	public int write(String bbsTitle, String userID, String bbsContent) {
		String SQL = "INSERT INTO BBS VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	
	//게식들 보기 ///////////////////////////////////////////////
	public ArrayList<Bbs> getList(int pageNumber) {
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list=new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	//
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	//
	public Bbs getBbs(int bbsID) {
		String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  bbsID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	//글 수정
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String SQL = "UPDATE BBS SET bbsTitle = ? , bbsContent = ? WHERE bbsID = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	
	//글의 삭제 
	public int delete (int bbsID) {
		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	
	
}

		</pre>
	</div>
    
    
    <div role="tabpanel" class="tab-pane" id="code02">
    	<h4>사용자 관련 DAO 메소드</h4>
		<pre class="brush:js;">
		
package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//접속 객체 - Data Base 접속 
	public UserDAO() {
		try {
//			String dbURL = "jdbc:mysql://localhost/ledlaputa";
			String dbURL = "jdbc:mysql://ledlaputa.com:3306/ledlaputa";
			String dbID = "ledlaputa";
			String dbPassword = "Ilovejayjung1!";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인 생성자 
	public int login(String userID, String userPassword) {
		//DB 검색 구문
		String SQL = "SELECT userPassword FROM USER WHERE userID= ? ";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//비밀번호 체크 
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}
				else 
					return 0; //비밀번호 불일치 
			}
			return -1; //아이디가 없음 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return -2; //데이터 베이스 오류 
	}
	
	//회원 가입 생성자 
	public int join(User user) {
		//DB 데이터 입력 구문 
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	

}


		</pre>
    </div>

    
    
  </div>

</div>
	
	
</body>
</html>