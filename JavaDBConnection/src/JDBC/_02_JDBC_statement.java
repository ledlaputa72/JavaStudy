package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_JDBC_statement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//접속 구문
		Connection con1=null; //접속객체 con1선언		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db에 접속
		
		//검색 구문 ?로 검색 값 입력 가능한 구문 
		String sql2 = "select first_name 이름, salary 봉급"
				+" from employees" 
				+" where salary >= ?";
		
//		Statement st2 = con1.createStatement(); 
//		ResultSet rs2 = st2.executeQuery(sql2);

		  //PrepareStatement 사용 /////////////////////////// 
		PreparedStatement ps2 =	con1.prepareStatement(sql2);
		  
		  //?에 필요한 값 입력 
		ps2.setInt(1, 15000); //1st ? 에 급여 15000을 넣어라
		  
		ResultSet rs2 = ps2.executeQuery(); //괄호안에 없음
		 		
		///////////////////////////골라서 출력하기 ///////////////////////////////////////////
		while(rs2.next()) { //data가 있어?
			String fname=rs2.getString("이름");
			int salary=rs2.getInt("봉급");
			System.out.println(rs2.getRow()+"\t"+fname+"\t"+salary);
		} //while end
		
		con1.close();
		System.out.println("접속 끝");
	}
}
