package Day046_Tcp_dis1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServer {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(7777);
		System.out.println("��ȭ�� �غ�Ǿ� ����....");

		while (true) {

			System.out.println("��ȭ��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ��ȭ�Գ�");
             
			/////////////////////////////
			DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());

			dos1.writeUTF("Long time no see man");//�漮���̷�
			
            //////////////////////////////////
			
			dos1.close();
			s1.close();

		}
	}
}
