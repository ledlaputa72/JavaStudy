package Day048_01_ImageTCP;

import java.io.*;
import java.net.*;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss1 = new ServerSocket(37781);
		System.out.println("���� �غ�Ǿ� ����....");
		
		while (true) {
			
			System.out.println("��ٸ��� ��...");
			
			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress()+"���� ����");
			
			//�ޱ� ���� ó�� (�Է�)
			File file1=new File("e:/aa.jpg");
			FileInputStream fis1=new FileInputStream(file1);
			DataInputStream dis1=new DataInputStream(fis1);
			//DataInputStream dis1=new DataInputStream(new FileInputStream(file1));
			
			//������ ó��  (���)
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream());
			
			//������ ó�� - byte �迭 �̿� //////////////////////
			byte[] byteBae = new byte[(int)file1.length()]; //���� ���̸�ŭ �迭 ���� 
			System.out.println("file ---> byte��...");
			
			//�ڷ� �ޱ� 
			dis1.readFully(byteBae); //���ϳ��� -->����Ʈ�迭
			
			//�ڷ� ������ 
			dos1.writeInt(byteBae.length); //���� ���� ���� ����
			dos1.write(byteBae); //����Ʈ �迭 ����
			
			System.out.println("�����ߴ�~~~");
			
		}//while end
	}//main end
}//class end
