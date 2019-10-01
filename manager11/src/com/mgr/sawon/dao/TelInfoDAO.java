package com.mgr.sawon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mgr.dbconn.TelInfoDBConn;
import com.mgr.sawon.vo.TelInfoVO;

@Repository //�� DAO��� spring�� �˷���
public class TelInfoDAO {
	
	private Connection con;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	//SimpleDateFormat sdf1=new SimpleDateFormat("yyy-MM-dd");
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException {
		con = new TelInfoDBConn().getConnection();
	}
	
	public void pstmtClose() throws SQLException{
		if(pstmt != null) {
			pstmt.close();
		}
	}
	
	public void getAllInfoClose() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	//��ü ���� ///////////////////////////////////////
	public ArrayList<TelInfoVO> getAllTellinfo(TelInfoVO vo1) throws SQLException {
		
		ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO>();
		String sql = "SELECT * FROM TelTable55 ORDER BY id";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			TelInfoVO telinfo=new TelInfoVO();
			telinfo.setId(rs.getInt("id"));
			telinfo.setName(rs.getString("name"));
			telinfo.setTel(rs.getString("tel"));
			
			tiarray.add(telinfo);
		}
		return tiarray;
	}//getAllTelinfo end
	
	//��ü ���� ���� ���� - �Ѹ� ó��  //getAllTelinfo (��ü) getTelinfo(�Ѹ�)////
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws SQLException { //���޵� ��ü ���� 
		
		TelInfoVO telinfo = null;
		String sql = "SELECT * FROM TelTable55 WHERE name =? ";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,  vo1.getName());
		rs = pstmt.executeQuery();
		while(rs.next()) {
			telinfo =new TelInfoVO();
			telinfo.setId(rs.getInt("id"));
			telinfo.setName(rs.getString("name"));
			telinfo.setTel(rs.getString("tel"));
		}
		return telinfo; //��ü ���� 
	}//getTelinfo end
	
	//������Ʈ /////////////////////////////////
	public void updateTelinfo(TelInfoVO vo1) throws SQLException, ClassNotFoundException { //������ ��ü ����
		
		String sql = "UPDATE TelTable55 set id=?, tel=? where name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId()); //�̰ɷ� id=?�� �ִ´�. 
		pstmt.setString(2,  vo1.getTel());
		pstmt.setString(3,  vo1.getName());
		
		pstmt.executeUpdate();
	}//update end
	
	//���� insert 
	public void insertTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "INSERT into TelTable55 values(?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId()); 
		pstmt.setString(2,  vo1.getTel());
		pstmt.setString(3,  vo1.getName());
		
		pstmt.executeUpdate();
	} //insert end
	
	//���� delete
	public void deleteTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "DELETE TelTable55 WHERE name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId());  
		
		pstmt.executeUpdate();
	} //delete end

}//class end
