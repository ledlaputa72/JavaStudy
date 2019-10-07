package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _04_JDBC_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//�����ϱ� 
		Connection con1=null; //���Ӱ�ü con1����		
		Class.forName ("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�		
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:" + "1521:xe", "hr", "hr"); //db�� ����
		
		//�ڷ� �߰� INSERT
		String sql2="insert into teltable5 values(?,?,?,?)";
		PreparedStatement pst1= con1.prepareStatement(sql2);
		
		//�ڷ� �Է� 
		Scanner sc1=new Scanner(System.in);
		System.out.print("��� : ");
		int id=sc1.nextInt();
				
		System.out.print("�̸� : ");
		String name=sc1.next();
		
		System.out.print("��ȭ��ȣ : ");
		String tel=sc1.next();

		System.out.print("�Ի��� : ");
		String ipsail=sc1.next();
		
		//���� �ڷ� ?�� �Է� 
		pst1.setInt(1, id); //1st ? ���̵� 2��
		pst1.setString(2, name); 
		pst1.setString(3, tel); 
		pst1.setString(4, ipsail); 
		
		//����
		int rowcnt1=pst1.executeUpdate(); //insert, delete, update ��� executeUpdate�� �� 
		System.out.println("�ߵ���"+ rowcnt1+"�� insert �ߴٴ�~~");
		con1.close();
		System.out.println("���� ��");
	}
}
