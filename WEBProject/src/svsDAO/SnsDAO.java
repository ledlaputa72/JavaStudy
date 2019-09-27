package svsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import snsDBConn.SnsDBConn;
import snsVO.SnsVO;

public class SnsDAO {
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public SnsDAO() throws ClassNotFoundException, SQLException {
		con = new SnsDBConn().getConnection();
	}
	
	public ArrayList<SnsVO> SnsAllView() throws SQLException {
		
		ArrayList<SnsVO> sarray = new ArrayList<SnsVO>();
		String sql = "SELECT * FROM snstable ORDER BY name";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getNString("name");
			String sns = rs.getNString("sns");
			
			SnsVO sv = new SnsVO(name, sns);
			sarray.add(sv);
		}
		
	 return sarray;	
		
	}

}
