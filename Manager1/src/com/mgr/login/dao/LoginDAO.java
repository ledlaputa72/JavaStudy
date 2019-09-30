package com.mgr.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.mgr.dbconn.TelInfoDBConn;
import com.mgr.login.vo.LoginVO;

@Repository
public class LoginDAO {
	
private Connection con;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public LoginDAO() throws ClassNotFoundException, SQLException {
		
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
	
	// 회원 가입하는 메소드
	public void registerAccount(LoginVO vo1) throws SQLException {
		
		String sql = "INSERT INTO LoginTable55 VALUES (?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getId());
		pstmt.setString(2, vo1.getPwd());
		
		pstmt.executeUpdate();
		
	}
	
	// 회원 탈퇴하는 메소드
	public void deleteAccount(LoginVO vo1) throws SQLException {
		
		String sql = "DELETE LoginTable55 WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getId());
		
		System.out.println(vo1.getId());
		
		pstmt.executeUpdate();
		
	}
	
	// 로그인하는 메소드
	public int loginCheck(String id, String pwd, HttpSession session) throws SQLException {
		
		String sql = "SELECT pwd FROM LoginTable55 WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		// 아이디가 존재한다면
		if (rs.next()) {
			
			// 패스워드가 일치한다면
			if (pwd.equals(rs.getString("pwd"))) {
				
				session.setAttribute("sid", id);
				
				return 1;
				
			}
				
			
			// 패스워드가 일치하지 않는다면
			else
				return 0;
			
		}
		
		// 아이디가 존재하지 않는다면
		else
			return -1;
		
	}

	// 내 정보 보는 메소드
	public LoginVO getInfo(LoginVO vo1) throws SQLException {
		
		LoginVO myInfo = null;
		
		String sql = "SELECT * FROM LoginTable55 WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getId());
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			myInfo = new LoginVO();
			
			myInfo.setId(rs.getString("id"));
			myInfo.setPwd(rs.getString("pwd"));
			
		}
		
		return myInfo;
		
	}

	// 내 정보 수정하는 메소드
	public void updateMyInfo(LoginVO vo1, HttpSession session) throws SQLException {

		String sql = "UPDATE LoginTable55 SET id = ?, pwd = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo1.getId());
		pstmt.setString(2, vo1.getPwd());
		pstmt.setString(3, (String) session.getAttribute("sid"));
		
		pstmt.executeUpdate();
		
	}
	
}
