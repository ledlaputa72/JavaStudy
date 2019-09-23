package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_JEBC_TestTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//�����ϱ� 
		Connection con1=null; //���Ӱ�ü con1����		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db�� ����
		
		//���̺� �˻��� SELECT 
		String sql2 = "select id ���̵�, name �̸�, tel ��ȭ��ȣ"
				+" from TelTable5" 
				+" where id >= ?";
		
		//?���� �˻� 
		PreparedStatement ps2 =	con1.prepareStatement(sql2);
		ps2.setInt(1, 2); //1st ? ���̵� 2�� 
		ResultSet rs2 = ps2.executeQuery(); 
		 		
		//���
		while(rs2.next()) { //data�� �־�?
			int id=rs2.getInt("���̵�");
			String name=rs2.getString("�̸�");
			String tel=rs2.getString("��ȭ��ȣ");
			System.out.println(rs2.getRow()+"\t"+id+"\t"+name+"\t"+tel);
		} //while end
		
		con1.close();
		System.out.println("���� ��");
	}
}
