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
	public TelInfoVO getInfo(String oriName) throws SQLException { 
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
	
	//ȸ���� �����ϱ� - ���� �޼ҵ� ////////////////////////////////////
	public boolean delete_nametel (String name3){
		String sql = "DELETE FROM TelTable5 WHERE name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,  name3);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
			return false;
		}
		return true;
	} //delete_nametel ////////////////////////////////////////
	
	//���� �����͸� �߰�  == ���� �޼ҵ� /////////////////////////////
	public boolean insert_nametel (int id,  String name, String tel, String sDate) {
		String sql = "insert into TELTABLE5 values (?, ?, ?, ?)";
		try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,  id);
				pstmt.setString(2,  name);
				pstmt.setString(3,  tel);
				int year = Integer.parseInt(sDate.substring(0,4))-1900;
				int month = Integer.parseInt(sDate.substring(4,6))-1;
				int day = Integer.parseInt(sDate.substring(6,8));
				Date d = new Date(year,month,day);
				pstmt.setDate(4, d);
				pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
			return false;
		}
		return true;
	}//insert_nametel end //////////////////////////////////////
	/*
	 * �ڹٿ� sql�� Dateó���� �ٸ��� . - Java.util.Date java.sql.Date 
	 * 1) to_date(?,'yyyy-MM-dd')
	 * 2) SimpleDateFormat
	 *     .parse(��¥->����)   .format(����->��¥)
	 * 3) java Ư�� �̿� + substring ���     
	 */

	public boolean update_all(int id1, String name1, String tel1, String d, String sname) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "update TelTable5 set id=?, name=?, tel=?, d=TO_DATE(?, 'YYYY-MM-DD') where name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id1);
		pstmt.setString(2, name1);
		pstmt.setString(3, tel1);
		pstmt.setString(4, d);
		pstmt.setString(5, sname);
		
		pstmt.executeUpdate();
		return true;
		
	}
    	
	
}//class end
