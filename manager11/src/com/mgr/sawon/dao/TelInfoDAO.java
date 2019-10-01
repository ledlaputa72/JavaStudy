package com.mgr.sawon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mgr.dbconn.TelInfoDBConn;
import com.mgr.sawon.vo.TelInfoVO;

@Repository //나 DAO라고 spring에 알려줌
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
	
	//전체 보기 ///////////////////////////////////////
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
	
	//객체 단위 정보 보기 - 한명 처리  //getAllTelinfo (전체) getTelinfo(한명)////
	public TelInfoVO getTelinfo(TelInfoVO vo1) throws SQLException { //전달도 객체 단위 
		
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
		return telinfo; //객체 단위 
	}//getTelinfo end
	
	//업데이트 /////////////////////////////////
	public void updateTelinfo(TelInfoVO vo1) throws SQLException, ClassNotFoundException { //전달은 객체 단위
		
		String sql = "UPDATE TelTable55 set id=?, tel=? where name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId()); //이걸로 id=?에 넣는다. 
		pstmt.setString(2,  vo1.getTel());
		pstmt.setString(3,  vo1.getName());
		
		pstmt.executeUpdate();
	}//update end
	
	//삽입 insert 
	public void insertTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "INSERT into TelTable55 values(?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId()); 
		pstmt.setString(2,  vo1.getTel());
		pstmt.setString(3,  vo1.getName());
		
		pstmt.executeUpdate();
	} //insert end
	
	//삭제 delete
	public void deleteTelinfo(TelInfoVO vo1) throws SQLException {
		
		String sql = "DELETE TelTable55 WHERE name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  vo1.getId());  
		
		pstmt.executeUpdate();
	} //delete end

}//class end
