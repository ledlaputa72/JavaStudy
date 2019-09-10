package vapsDAO;

import java.sql.Connection;
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
	
	// �������ڸ��� �����ڿ��� ���� ��ü get
	public CartDAO() throws ClassNotFoundException, SQLException {
		
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
	
	// īƮ ��� ��ȣ ��ȸ�ϴ� �޼ҵ�
	public int getNo() throws SQLException {
		
		String sql = "SELECT MAX(cno) FROM cart";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		int cno = 0;
		
		if (rs.next())
			cno = rs.getInt(1);
		
		return cno;
		
	}

	// īƮ�� �߰��ϴ� �޼ҵ�
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

	// ��ٱ��� ��� ����ϴ� �޼ҵ�
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

	// ��ٱ��Ͽ� ������ �޴��� �ִ��� Ȯ�����ִ� �޼ҵ�
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

	// ��ٱ��Ͽ� ����ִ� �޴��� ���� ������Ʈ�ϴ� �޼ҵ�
	public boolean update_cart(int cno, String user_id, String menu, int price, int amount2) throws SQLException {
		
		String sql = "UPDATE cart SET amount = ? + amount WHERE user_id = ? AND menu = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, amount2);
		pstmt.setString(2, user_id);
		pstmt.setString(3, menu);

		pstmt.executeUpdate();
		
		return true;
		
	}

	// ��ٱ����� �޴� �����ϴ� �޼ҵ�
	public boolean delete_cart(int cno) throws SQLException {
		
		String sql = "DELETE FROM cart WHERE cno = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, cno);
		
		pstmt.executeUpdate();
		
		return true;
		
	}
	
	

}
