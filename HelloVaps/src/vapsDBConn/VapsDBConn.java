package vapsDBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VapsDBConn {
	
	private Connection con; // ���� ��ü

	// ���� ��ü ȣ�� �� getConnection() �� ȣ��
	public Connection getConnection() {
		return con;
	}
	
	public VapsDBConn() throws ClassNotFoundException, SQLException {
		
		String dbURL = "jdbc:mysql://ledlaputa.com:3306/ledlaputa";
		String dbID = "ledlaputa";
		String dbPassword = "Ilovejayjung1!";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, dbID, dbPassword);
		
		
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");*/
	}
	
	

}
