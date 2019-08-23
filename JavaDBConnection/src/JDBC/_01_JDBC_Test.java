package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _01_JDBC_Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con1=null; //접속객체 con1선언
		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩
		//소대문자, 띄어쓰기 //스태틱메소드 (new 없이 사용) 
		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db에 접속
		//("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		
//		System.out.println("접속했다고 전해라");
		
		////////////////////////SQL 선택 검색문 //////////////////////////////////////////
//		String sql2="select * from employees"; //자바가 보기에는 String 문자열 , SQL입장에서는 검색문
//		String sql2="select * from employees where upper(first_name)='NANCY'"; //nancy 이름 검색	
//		String sql2="select * from employees" 
//		        +" where upper(first_name)='NANCY'"; //위의 문장을 두줄로 바꿀때 
		String sql2="select * from employees"
				+" where first_name like 'S%'"; //대문자 S로 시작하는 이름 검색 

		
		Statement st2 = con1.createStatement(); //접속 객체에 문장을 만들어라 . 위의 sql2를 SQL문장으로 처리 
		                //접속객체.메소드()
		
		ResultSet rs2 = st2.executeQuery(sql2); //sql2를 문장으로 바꿔 쿼리로 실행한다. 
		         //종이박스      //문장객체.execute
		//ResultSet Class : 쿼리 실행한 내용을 종이박스에 넣는다. (화면에 출력하지 않고 종이박스에 저장)
		
		///////////////////////////골라서 출력하기 ///////////////////////////////////////////
		while(rs2.next()) { //data가 있어?
			int id=rs2.getInt("employee_id");
			String fname=rs2.getString("first_name");
			String h_date=rs2.getString("hire_date");
			String hire_date=h_date.substring(0,10);
			System.out.println(rs2.getRow()+"\t"+id+"\t"+fname+"\t"+hire_date);
		} //while end
		con1.close();
		System.out.println("접속 끝");
		
	}// main end
}//class end
