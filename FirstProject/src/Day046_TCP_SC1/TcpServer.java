package Day046_TCP_SC1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServer {//����� .class �����ǰ� ������ x
	
	public static void main(String args[]) throws IOException {
		
	ServerSocket ss1 = new ServerSocket(7818); //port no.
		System.out.println("��ȭ�� �غ�Ǿ� ����....");
		
		while (true) {////////////
			System.out.println("��ȭ��ٸ��� ��....");

			Socket s1 = ss1.accept();//��ٸ��� ��
			System.out.println(s1.getInetAddress() + "���� ��ȭ�Գ�");
                               //��ȭ�⿡ ���� �����ȣ 
			BufferedWriter bw1 = 
		new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
			                               
			bw1.write ("How are you today.");////////
			bw1.newLine();   bw1.flush();///////////
			
			System.out.println("��~~~");
			bw1.close();	s1.close();
		}//while-end
	}
}
