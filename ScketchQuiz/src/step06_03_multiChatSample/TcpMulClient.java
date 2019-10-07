package step06_03_multiChatSample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//클라이언트 보내기 스레드 클래스 ############
class ThreadClientSendClass extends Thread {
	//필드 
	Socket s1;
	String nickname;
	DataOutputStream outputStream;
	
	// 생성자, 소켓(포트), 닉네임, 초기치로 소켓 객체, 닉네임이 넘어온다.
	public ThreadClientSendClass(Socket s1, String nickname) throws IOException {
		this.s1 = s1;
		this.nickname = nickname;
		outputStream = new DataOutputStream(s1.getOutputStream());
	}//생성자 end
	
	public void run() { //서버로 보내는 텍스트 내용 (in1--> 입력 내용)==> chat(매개 변수로 보내진다) sendChat(String chat)
		Scanner in1 = new Scanner(System.in);
		try {
			if (outputStream != null)
				outputStream.writeUTF(nickname); // 닉네임 send\
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	} //run end
}//ThreadClientSendClass class end####
	
//클라이언트 받기 스레드 클래스 ##################
class ThreadClientRcvClass extends Thread {

	Socket s1;
	DataInputStream inputStream;
	
	// 생성자
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
			Socket s1 = new Socket("127.0.0.1",9999); // ip 주소, 포트 번호
			System.out.println("서버에 연결...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, args[0]); // 닉네임
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1);
			
			Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			Thread trcv1 = new Thread(tcr1); // 받는 chat 위해
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try end
	} //main end
}// TcpMulClient end
