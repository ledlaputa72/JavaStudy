package Day046_Client_Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss1 = new ServerSocket(7111); //Listen ����, 7111:port��ȣ 
		//�� ������ ���� Ŭ���̾�Ʈ �� ���� port ��ȣ�� �ѹ� ����ϰ� ���� ����־� �ٸ� ��ȣ�� �ٲ���Ѵ�. 
		Socket s1 = ss1.accept(); //������� ����� ������ ���� 
		InputStream is1 = s1.getInputStream(); //���Ͽ��� �Է� ��Ʈ�� ��� 
		OutputStream os1 = s1.getOutputStream(); //���Ͽ��� ��� ��Ʈ�� ��� 
		
		int b1; //byte stream�� ó�� 
			while (true) {
				b1=is1.read(); //���ڿ� �б� Client --> Server
				if(b1==-1) break;
				os1.write(b1); //���ڿ� ��� Server --> Client 
			}
			//������ ���� ���� run ���� Ŭ�󸮾�Ʈ run
	}
}
