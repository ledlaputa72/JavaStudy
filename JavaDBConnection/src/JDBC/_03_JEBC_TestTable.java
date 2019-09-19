package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_JEBC_TestTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//접속하기 
		Connection con1=null; //접속객체 con1선언		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db에 접속
		
		//테이블 검색문 SELECT 
		String sql2 = "select id 아이디, name 이름, tel 전화번호"
				+" from TelTable5" 
				+" where id >= ?";
		
		//?내용 검색 
		PreparedStatement ps2 =	con1.prepareStatement(sql2);
		ps2.setInt(1, 2); //1st ? 아이디 2번 
		ResultSet rs2 = ps2.executeQuery(); 
		 		
		//출력
		while(rs2.next()) { //data가 있어?
			int id=rs2.getInt("아이디");
			String name=rs2.getString("이름");
			String tel=rs2.getString("전화번호");
			System.out.println(rs2.getRow()+"\t"+id+"\t"+name+"\t"+tel);
		} //while end
		
		con1.close();
		System.out.println("접속 끝");
	}
}
