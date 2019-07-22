package Day046_Client_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc1=new Scanner(System.in);
		
		Socket socket = new Socket("127.0.0.1", 7111); //connect ����, Server�� ServerSocket�� �����ϹǷ�  
		
		InputStream is1=socket.getInputStream(); // ���� �ҽ�  //socket���� �̾ƿ� inputStream�� is1�� ���� 
		InputStreamReader isr1=new InputStreamReader(is1); //
		BufferedReader br1= new BufferedReader(isr1);
		//BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream()));  //����� 

		
		BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		while (true) {
			System.out.println("���ڸ� �־��");
			String bada1forServer = sc1.nextLine();
			if(bada1forServer.length()==0)
				break;
			bw1.write(bada1forServer, 0, bada1forServer.length());
			//server�� ���� // Ű���� ���� ���� 01��°���� ��� ���̸�ŭ ���δ� ����
			bw1.newLine(); //�ٹٲ޵� ������
			bw1.flush(); //������ �������� buffer��� 
			
			String bada2fromServer = br1.readLine(); //serve�� ���� ���� 
			System.out.println("�����κ��� �ٽ� �Դٴ� "+ bada2fromServer);
		}
		socket.close();
		//������ �������� run�� ��  Ŭ���̾�Ʈ run
	}

}
