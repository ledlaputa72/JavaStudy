package Day049_01_FileIO;

import java.io.*;
import java.net.*;

public class TcpServerFILE {

	public static void main(String[] args) throws IOException {

		ServerSocket ss1=new ServerSocket(37799);
		System.out.println("���� �غ�Ǿ�����.....");
		
		while (true) {
			
			System.out.println("��ٸ��� �� ....");
			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");
			
			//���� ����� ���� DataStream ���� ////////////////////
			File file1=new File("e:/aaa.ppt");
			FileInputStream fis1=new FileInputStream(file1); //�б� ����
			DataInputStream dis1=new DataInputStream(fis1); //�����͸� �ޱ� ���ؼ� 
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //������ ���ؼ�
			//////////////////////////////////////////////
			
			int len=1024;
			byte[] byteBae=new byte[len];
			int chk;
			while ((chk=dis1.read(byteBae, 0, byteBae.length)) != -1) {
				dos1.write(byteBae); //file --> �迭�� �־� byte�� ����
			}
			dos1.flush(); dis1.close(); dos1.close(); s1.close();
			System.out.println("�����ߴ�....");
		} //while end
	}//main end
}
