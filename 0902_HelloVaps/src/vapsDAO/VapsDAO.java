package vapsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vapsDBConn.VapsDBConn;

public class VapsDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 시작하자마자 생성자에서 접속 객체 get
	public VapsDAO() throws ClassNotFoundException, SQLException {
			
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

}
