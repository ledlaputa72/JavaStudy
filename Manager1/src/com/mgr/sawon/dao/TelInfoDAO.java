package com.mgr.sawon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mgr.dbconn.TelInfoDBConn;
import com.mgr.sawon.vo.TelInfoVO;

// @Repository : spring ���� DAO �������� �˷��ش�.
@Repository
public class TelInfoDAO {
	
	private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException {
		
		con = new TelInfoDBConn().getConnection();
		
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
	
	// ��� ��ü ��� �����ִ� �޼ҵ�
	public ArrayList<TelInfoVO> getAllTelinfo(TelInfoVO vo1) throws SQLException {
		
		ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO> ();
		
		String sql = "SELECT * FROM TelTable55 ORDER BY id";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			TelInfoVO telinfo = new TelInfoVO();
			
			telinfo.setId(rs.getInt("id"));
			telinfo.setName(rs.getString("name"));
			telinfo.setTel(rs.getString("tel"));
			
			tiarray.add(telinfo);
			
		}
		
		return tiarray;
		
	}
	
	// ��� �� �� ���� �����ִ� �޼ҵ�
	// ��ü ������ ���� �޴´�.
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws SQLException {
		
		TelInfoVO telinfo = null;
		
		String sql = "SELECT * FROM teltable55 WHERE name = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getName());
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			telinfo = new TelInfoVO();
			
			telinfo.setId(rs.getInt("id"));
			telinfo.setName(rs.getString("name"));
			telinfo.setTel(rs.getString("tel"));
			
		}
		
		return telinfo;
		
	}
	
	// ��� �� �� ���� �����ϴ� �޼ҵ�
	// ��ü ������ ���� �޴´�.
	public void updateTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "UPDATE TelTable55 SET id = ?, tel = ? WHERE name = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, vo1.getId());
		pstmt.setString(2, vo1.getTel());
		pstmt.setString(3, vo1.getName());
		
		pstmt.executeUpdate();
		
	}
	
	// ��� ���� �߰��ϴ� �޼ҵ�
	public void insertTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "INSERT INTO TelTable55 VALUES (?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, vo1.getId());
		pstmt.setString(2, vo1.getName());
		pstmt.setString(3, vo1.getTel());
		
		pstmt.executeUpdate();
		
	}
	
	// ��� ���� �����ϴ� �޼ҵ�
	public void deleteTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "DELETE TelTable55 WHERE name = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getName());
		
		pstmt.executeUpdate();
		
	}

}
