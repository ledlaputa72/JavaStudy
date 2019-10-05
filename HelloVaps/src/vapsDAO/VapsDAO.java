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
	
/*	// �������ڸ��� �����ڿ��� ���� ��ü get
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
		
		// ID �� �����Ѵٸ�
		if (rs.next()) {
			
			// �н����尡 ��ġ�Ѵٸ�
			if (rs.getString(1).equals(pw))
				return 1;
			
			// �н����尡 ��ġ���� �ʴ´ٸ�
			else
				return 0;
			
		}
		
		// ID �� �������� �ʴ´ٸ�
		else
			return -1;
		
	}
	
	// ���ϴ� ����� ���� �˻��ϴ� �޼ҵ�
	public VapsVO getInfo(String oriId) throws SQLException {
			
		VapsVO vv = null;
			
		String sql = "SELECT * FROM member WHERE id = ?";
			
		pstmt = con.prepareStatement(sql);
			
		pstmt.setString(1, oriId);
			
		rs = pstmt.executeQuery();
			
		// rs ���� �ڽ��� �ش� ��� ������ ������
		if (rs.next()) {
			
			int no = rs.getInt("no");				
			
			String id = rs.getString("id");
			String pw = rs.getString("pw");	
			String name = rs.getString("name");
			String email = rs.getString("email");
			String tel = rs.getString("tel");
				
			// �ش� ��� �������� ��� ������ VO �׸��� �ִ´�.
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

	// �ڽ��� ������ ������ �� �ִ� �޼ҵ�
	public boolean update_all(int no, String id, String name, String email, String tel, String sid) throws SQLException {
		
		String sql = "UPDATE member SET no = ?, id = ?, name = ?, email = ?, tel = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		pstmt.setString(5, tel);
		pstmt.setString(6, sid); // ��ũ�� �Ѿ�� ���̵�
		
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
	
	// ���̵� �ߺ��Ǿ����� �˻��ϴ� �޼ҵ�
	public int confirmId(String id) throws SQLException {
			
			int x=-1;
			
			String sql = "SELECT id from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			
			rs = pstmt.executeQuery();
			if(rs.next())
				x= 1; //�ش���̵� ����
			else
				x= -1; //�ش���̵� ����
			
			
			
			return x;
			
		}

	// ���̵� ��Ģ�� �´��� �˻��ϴ� �޼ҵ�
	public void confirmId2(String id) {
	
		
	}

}
