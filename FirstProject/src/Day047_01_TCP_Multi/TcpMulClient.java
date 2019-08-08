package Day047_01_TCP_Multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ThreadClientSendClass extends Thread {
	
	Socket socket;
	DataOutputStream outputStream;
	String nickname;
	
	// �ʱ�ġ�� ���� ��ü, �г����� �Ѿ�´�.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // �г��� send
				
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io ��Ʈ���� ���� ���濡�� chat ������.
				
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
class ThreadClientRcvClass extends Thread {

	Socket socket;
	DataInputStream inputStream;
	
	// ������
	public ThreadClientRcvClass(Socket socket) throws IOException {
		
		this.socket = socket;
		
		inputStream = new DataInputStream(socket.getInputStream()); // read
		
	}
	
	public void run() {
		
		while (inputStream != null) {
			
			try {
				
				System.out.println(inputStream.readUTF());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}

public class TcpMulClient {

	public static void main(String[] args) throws NumberFormatException, IOException {

		if (args.length != 3) {
			
			System.out.println("���� : Ŭ���̾�Ʈ������ \'java ��Ű����.���ϸ� ip�ּ� ��Ʈ��ȣ �г��� \' �������� �Է�");
			
			System.exit(1);
		}
			
		try {
			
			Socket s1 = new Socket(args[0], Integer.parseInt(args[1])); // ip �ּ�, ��Ʈ ��ȣ
			
			System.out.println("������ ����...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, args[2]); // �г���
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1);
			
			Thread tsend1 = new Thread(tcc1); // ������ chat ����
			Thread trcv1 = new Thread(tcr1); // �޴� chat ����
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
