package Day048_01_ImageTCP;

import java.io.*;
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1",37781);
		
		DataInputStream dis1=new DataInputStream(s1.getInputStream());
		
		int len1=dis1.readInt(); //������ ���� ���� ���� ���� �޾ƿ� 
		byte[] byteBae2=new byte[len1]; //���̸�ŭ �迭�� ���� 
		dis1.readFully(byteBae2); //�׸��� ������ �޾�Ʈ�迭�� 
		
		FileOutputStream fos1 = new FileOutputStream("e:/bb.jpg");
		fos1.write(byteBae2);//���� ����Ʈ �迭 --> ���Ϸ� 
		
		System.out.println("��~~~");
	}
}
