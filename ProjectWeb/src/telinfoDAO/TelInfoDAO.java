package telinfoDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import telinfoDBConn.TelInfoDBConn;
import telinfoVO.TelInfoVO;

public class TelInfoDAO {
	
	private Connection con;
	PreparedStatement pstmt = null; 
	ResultSet rs = null; //���� �ڽ� 
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException{
		con=new TelInfoDBConn().getConnection();	//���� ��ü ����
	}
	
	public void pstmtClose() throws SQLException { //pstmt ������ 
		if(pstmt != null) {pstmt.close();}
	} 
	
	public void getAllInfoClose() throws SQLException { //rs �������� ��� �ݴ� �޼ҵ� ���
		if(rs != null ) {rs.close();}
		if(pstmt != null) {pstmt.close();}
		if(con != null) {con.close();}
	}
	
	//��ü�� �ο��� ã�� �޼ҵ� /////////////////////////////////////
	public ArrayList<TelInfoVO> getAllInfo() throws SQLException {
		ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO>();
		String sql = "SELECT * FROM TelTable5 ORDER BY id"; //���ù�
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d");
			
			TelInfoVO tv = new TelInfoVO(id,name,tel,d);
			tiarray.add(tv);
		}
		return tiarray; //tiarray //���� ��ȯ��(ArrayList<TelInfoVO>)
	}// getAllInfo() end///////////////////////////////////////
	
	//���ϴ� �ѻ�� ã�� �޼ҵ� ///////////////////////////////////////
	public TelInfoVO search_nametel(String oriName) throws SQLException { 
		TelInfoVO tv = null; //�ѻ���� ã�� 
		String sql = "SELECT * FROM TelTable5 WHERE NAME=?"; //? : ���ϴ� ��� �̸� ���ù�
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, oriName);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d"); //ȫ�浿 ���� ���� ������ 
			
			tv=new TelInfoVO(id,name,tel,d); //vo �׸��� �ְ� //�����ڷ� ���� 
		} else { //�׷� �̸��� ������
			tv=null; //tv��ü ���� ������ null (return null)
		}
		return tv; //�׷� �̸��� ������ tv ���� //��ȯ��(TelInfoVO)
	} //search_nametel() end/////////////////////////////////////
	
	//��ȭ��ȣ�� �ٲٰ� ������Ʈ == ���� �޼ҵ� /////////////////////////////
	public boolean update_nametel (String tel2, String name2) {
		String sql = "UPDATE TelTable5 SET tel=? WHERE name=?";
		try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,  tel2);
				pstmt.setString(2,  name2);
				
				pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
//			return false;
		}
		return true;
	}//update_nametel end //////////////////////////////////////
	
	
}//class end
