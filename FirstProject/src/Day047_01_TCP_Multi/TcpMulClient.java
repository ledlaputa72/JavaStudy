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
	
	// 초기치로 소켓 객체, 닉네임이 넘어온다.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // 닉네임 send
				
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
				
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
class ThreadClientRcvClass extends Thread {

	Socket socket;
	DataInputStream inputStream;
	
	// 생성자
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
			
			System.out.println("사용법 : 클라이언트실행은 \'java 패키지명.파일명 ip주소 포트번호 닉네임 \' 형식으로 입력");
			
			System.exit(1);
		}
			
		try {
			
			Socket s1 = new Socket(args[0], Integer.parseInt(args[1])); // ip 주소, 포트 번호
			
			System.out.println("서버에 연결...");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, args[2]); // 닉네임
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1);
			
			Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			Thread trcv1 = new Thread(tcr1); // 받는 chat 위해
			
			tsend1.start();
			trcv1.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
