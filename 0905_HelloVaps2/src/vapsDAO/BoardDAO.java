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
		
		System.out.println(sql);
			
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
			
			System.out.println(barray);
				
		}
			
		return barray;
		
	}

}
