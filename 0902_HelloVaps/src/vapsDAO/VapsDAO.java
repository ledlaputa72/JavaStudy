package vapsDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vapsDBConn.VapsDBConn;
import vapsVO.VapsVO;

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
		
		System.out.println(no);
		
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

}
