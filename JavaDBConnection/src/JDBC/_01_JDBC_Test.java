package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _01_JDBC_Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con1=null;
		
		Class.forName ("oracle.jdbc.driver.OracleDreiver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db�� ����
		//("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("�����ߴٰ� ���ض�");

	}

}
