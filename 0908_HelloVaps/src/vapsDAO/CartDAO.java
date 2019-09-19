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
	
	// 시작하자마자 생성자에서 접속 객체 get
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
