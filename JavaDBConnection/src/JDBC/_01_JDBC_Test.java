package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _01_JDBC_Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con1=null; //���Ӱ�ü con1����
		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		//�Ҵ빮��, ���� //����ƽ�޼ҵ� (new ���� ���) 
		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db�� ����
		//("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		
//		System.out.println("�����ߴٰ� ���ض�");
		
		////////////////////////SQL ���� �˻��� //////////////////////////////////////////
//		String sql2="select * from employees"; //�ڹٰ� ���⿡�� String ���ڿ� , SQL���忡���� �˻���
//		String sql2="select * from employees where upper(first_name)='NANCY'"; //nancy �̸� �˻�	
//		String sql2="select * from employees" 
//		        +" where upper(first_name)='NANCY'"; //���� ������ ���ٷ� �ٲܶ� 
		String sql2="select * from employees"
				+" where first_name like 'S%'"; //�빮�� S�� �����ϴ� �̸� �˻� 

		
		Statement st2 = con1.createStatement(); //���� ��ü�� ������ ������ . ���� sql2�� SQL�������� ó�� 
		                //���Ӱ�ü.�޼ҵ�()
		
		ResultSet rs2 = st2.executeQuery(sql2); //sql2�� �������� �ٲ� ������ �����Ѵ�. 
		         //���̹ڽ�      //���尴ü.execute
		//ResultSet Class : ���� ������ ������ ���̹ڽ��� �ִ´�. (ȭ�鿡 ������� �ʰ� ���̹ڽ��� ����)
		
		///////////////////////////��� ����ϱ� ///////////////////////////////////////////
		while(rs2.next()) { //data�� �־�?
			int id=rs2.getInt("employee_id");
			String fname=rs2.getString("first_name");
			String h_date=rs2.getString("hire_date");
			String hire_date=h_date.substring(0,10);
			System.out.println(rs2.getRow()+"\t"+id+"\t"+fname+"\t"+hire_date);
		} //while end
		con1.close();
		System.out.println("���� ��");
		
	}// main end
}//class end
