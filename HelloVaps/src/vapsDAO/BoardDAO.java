package vapsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vapsDBConn.VapsDBConn;
import vapsVO.BoardVO;

public class BoardDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 시작하자마자 생성자에서 접속 객체 get
	public BoardDAO() throws ClassNotFoundException, SQLException {
			
		con = new VapsDBConn().getConnection();
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
	
	// 게시판 목록 출력하는 메소드
	public ArrayList<BoardVO> boardList() throws SQLException {
			
		ArrayList<BoardVO> barray = new ArrayList<BoardVO>();
			
		String sql = "SELECT * FROM board ORDER BY bno";
			
		pstmt = con.prepareStatement(sql);
			
		rs = pstmt.executeQuery();
			
		while (rs.next()) {
				
			int bno = rs.getInt("bno");
				
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
				
			Date regDate = rs.getDate("regDate");
				
			int hitCount = rs.getInt("hitCount");
				
			BoardVO bv = new BoardVO(bno, title, content, author, regDate, hitCount);
				
			barray.add(bv);
				
		}
			
		return barray;
		
	}

	// 게시판 목록 번호 조회하는 메소드 
	public int getNo() throws SQLException {
		
		String sql = "SELECT MAX(bno) FROM board";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		int bno = 0;
		
		if (rs.next())
			bno = rs.getInt(1);
		
		return bno;
		
	}

	public boolean insert_post(int bno, String title, String content, String author, String sDate, int hitCount) {
		
		String sql = "INSERT INTO board VALUES (?, ?, ?, ?, ?, ?)";
		
		try {

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno + 1);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, author);
			
			int year = Integer.parseInt(sDate.substring(0, 4)) - 1900;
			int month = Integer.parseInt(sDate.substring(5, 7)) - 1;
			int day = Integer.parseInt(sDate.substring(8, 10));
			
			Date regDate = new Date(year, month, day);
			
			pstmt.setDate(5, regDate);
			pstmt.setInt(6, hitCount);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("insert Exception");
			
			e.printStackTrace();
			
		}
		
		return true;
		
	}

	// 게시판 해당 글의 내용 보여주는 메소드
	public BoardVO borderView(int oriBno) throws SQLException {
		
		BoardVO bv = null;
		
		String sql = "SELECT * FROM board WHERE bno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, oriBno);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			int bno = rs.getInt("bno");
			
			String title = rs.getString("title");
			String author = rs.getString("author");
			
			Date regDate = rs.getDate("regDate");
			
			int hitCount = rs.getInt("hitCount");
			
			String content = rs.getString("content");
			
			bv = new BoardVO(bno, title, content, author, regDate, hitCount);
			
		}
		
		else 
			bv = null;		
		
		return bv;
	}

	// 게시글 삭제하는 메소드
	public boolean delete_board(int bno) throws SQLException {

		String sql = "DELETE FROM board WHERE bno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, bno);
		
		pstmt.executeUpdate();
		
		return true;
		
	}

	// 조회수 1 증가해주는 메소드
	public boolean increaseHitCount(int bno) throws SQLException {
		
		String sql = "UPDATE board SET hitCount = hitCount + 1 WHERE bno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, bno);
		
		pstmt.executeUpdate();
		
		return true;
	}

	public boolean update_board(int bno, String title, String content) throws SQLException {
		
		String sql = "UPDATE board SET title = ?, content = ? WHERE bno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, bno);
		
		pstmt.executeUpdate();
		
		return true;
		
	}

}
