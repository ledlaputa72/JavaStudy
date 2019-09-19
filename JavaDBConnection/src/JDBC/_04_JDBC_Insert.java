package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _04_JDBC_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//접속하기 
		Connection con1=null; //접속객체 con1선언		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //드라이버 로딩		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db에 접속
		
		//자료 추가 INSERT
		String sql2="insert into teltable5 values(?,?,?,?)";
		PreparedStatement pst1= con1.prepareStatement(sql2);
		
		//자료 입력 
		Scanner sc1=new Scanner(System.in);
		System.out.print("사번 : ");
		int id=sc1.nextInt();
				
		System.out.print("이름 : ");
		String name=sc1.next();
		
		System.out.print("전화번호 : ");
		String tel=sc1.next();

		System.out.print("입사일 : ");
		String ipsail=sc1.next();
		
		//받은 자료 ?에 입력 
		pst1.setInt(1, id); //1st ? 아이디 2번
		pst1.setString(2, name); 
		pst1.setString(3, tel); 
		pst1.setString(4, ipsail); 
		
		//실행
		int rowcnt1=pst1.executeUpdate(); //insert, delete, update 모두 executeUpdate로 함 
		System.out.println("잘들어봐"+ rowcnt1+"행 insert 했다는~~");
		con1.close();
		System.out.println("접속 끝");
	}
}
