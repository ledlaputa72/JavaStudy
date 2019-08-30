package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_JDBC_statement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//���� ����
		Connection con1=null; //���Ӱ�ü con1����		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db�� ����
		
		//�˻� ���� ?�� �˻� �� �Է� ������ ���� 
		String sql2 = "select first_name �̸�, salary ����"
				+" from employees" 
				+" where salary >= ?";
		
//		Statement st2 = con1.createStatement(); 
//		ResultSet rs2 = st2.executeQuery(sql2);

		  //PrepareStatement ��� /////////////////////////// 
		PreparedStatement ps2 =	con1.prepareStatement(sql2);
		  
		  //?�� �ʿ��� �� �Է� 
		ps2.setInt(1, 15000); //1st ? �� �޿� 15000�� �־��
		  
		ResultSet rs2 = ps2.executeQuery(); //��ȣ�ȿ� ����
		 		
		///////////////////////////��� ����ϱ� ///////////////////////////////////////////
		while(rs2.next()) { //data�� �־�?
			String fname=rs2.getString("�̸�");
			int salary=rs2.getInt("����");
			System.out.println(rs2.getRow()+"\t"+fname+"\t"+salary);
		} //while end
		
		con1.close();
		System.out.println("���� ��");
	}
}
