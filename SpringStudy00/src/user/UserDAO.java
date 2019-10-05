package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//접속 객체 - Data Base 접속 
	public UserDAO() {
		try {
//			String dbURL = "jdbc:mysql://localhost/ledlaputa";
			String dbURL = "jdbc:mysql://ledlaputa.com:3306/ledlaputa";
			String dbID = "ledlaputa";
			String dbPassword = "Ilovejayjung1!";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인 생성자 
	public int login(String userID, String userPassword) {
		//DB 검색 구문
		String SQL = "SELECT userPassword FROM USER WHERE userID= ? ";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//비밀번호 체크 
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}
				else 
					return 0; //비밀번호 불일치 
			}
			return -1; //아이디가 없음 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return -2; //데이터 베이스 오류 
	}
	
	//회원 가입 생성자 
	public int join(User user) {
		//DB 데이터 입력 구문 
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	

}
