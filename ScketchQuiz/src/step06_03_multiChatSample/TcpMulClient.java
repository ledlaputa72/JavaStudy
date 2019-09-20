package step06_03_multiChatSample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//Ŭ���̾�Ʈ ������ ������ Ŭ���� ############
class ThreadClientSendClass extends Thread {
	//�ʵ� 
	Socket s1;
	String nickname;
	DataOutputStream outputStream;
	
	// ������, ����(��Ʈ), �г���, �ʱ�ġ�� ���� ��ü, �г����� �Ѿ�´�.
	public ThreadClientSendClass(Socket s1, String nickname) throws IOException {
		this.s1 = s1;
		this.nickname = nickname;
		outputStream = new DataOutputStream(s1.getOutputStream());
	}//������ end
	
	public void run() { //������ ������ �ؽ�Ʈ ���� (in1--> �Է� ����)==> chat(�Ű� ������ ��������) sendChat(String chat)
		Scanner in1 = new Scanner(System.in);
		try {
			if (outputStream != null)
				outputStream.writeUTF(nickname); // �г��� send\
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io ��Ʈ���� ���� ���濡�� chat ������.
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //run end
}//ThreadClientSendClass class end####
	
//Ŭ���̾�Ʈ �ޱ� ������ Ŭ���� ##################
class ThreadClientRcvClass extends Thread {

	Socket s1;
	DataInputStream inputStream;
	
	// ������
	public ThreadClientRcvClass(Socket s1) throws IOException {
		this.s1 = s1;
		inputStream = new DataInputStream(s1.getInputStream()); // read
	}
	
	public void run() {
		while (inputStream != null) {
			try {
				System.out.println(inputStream.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} //run end
}// ThreadClientRcvClass class end##########

//TcpMulClient main class
public class TcpMulClient {
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		try {
			Socket s1 = new Socket("127.0.0.1",9999); // ip �ּ�, ��Ʈ ��ȣ
			System.out.println("������ ����...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, args[0]); // �г���
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1);
			
			Thread tsend1 = new Thread(tcc1); // ������ chat ����
			Thread trcv1 = new Thread(tcr1); // �޴� chat ����
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try end
	} //main end
}// TcpMulClient end
