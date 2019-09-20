package vapsDBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VapsDBConn {
	
	private Connection con; // 접속 객체

	// 접속 객체 호출 시 getConnection() 를 호출
	public Connection getConnection() {
		return con;
	}
	
	public VapsDBConn() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}

}
