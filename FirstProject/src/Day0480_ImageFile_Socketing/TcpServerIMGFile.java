package Day0480_ImageFile_Socketing;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServerIMGFile {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(37787);
		System.out.println("���� �غ�Ǿ� ����....");

		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");

						/////////////////////////////
			File file1 = new File("d:/aa.jpg"); //�������� 
			                        //.doc  
			//���� input �غ�
			FileInputStream fis1 = new FileInputStream(file1);
			DataInputStream dis1 = new DataInputStream(fis1);

			 //output �غ� 
			DataOutputStream dos1 =
					 new DataOutputStream(s1.getOutputStream());
             
			//���� ���� ����
			int len = 1024;
			byte[] byteBae = new byte[len];
			int chk;
			while ((chk = dis1.read(byteBae, 0, byteBae.length)) != -1) {
				dos1.write(byteBae); //file ---> �迭�� �־� byte ���� 
			}
			//�̰͵� �翬�� ����
			// dis1.readFully(byteBae);//������ ����Ʈ �о�� �迭��
			// dos1.write(byteBae);//����
             dos1.flush(); 
             dis1.close(); dos1.close(); s1.close();
			 
			System.out.println("�����ߴ�~~~");
		}

		
		//////////////////////////////////

	}
}
