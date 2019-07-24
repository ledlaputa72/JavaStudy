package Day047_10_tcp_thread_multiChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerClass {
	
	// collection 에 들어가는 것은 ThreadServerClass only
	// Vector
	// HashMap, Collections.synchronizedMap()
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); // 제네릭
	
	Socket socket; // 클라이언트 받아 저장할 곳
	DataOutputStream outputStream; // 출력 스트림
	
	// 생성자
	public ServerClass(int portno) throws IOException {
		
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); // 서버 소켓 생성
		
		System.out.println("서버 가동...");
		
		while (true) {
			
			s1 = ss1.accept(); // 기다리는 중 // 받아들이는 여부
			
			System.out.println("접속 주소 : " + s1.getInetAddress() + ", 접속 포트 : " + s1.getPort());
			
			ThreadServerClass tServer1 = new ThreadServerClass(s1); // s1 초기치
			
			tServer1.start();
			
			threadList.add(tServer1); // 컬렉션에  add
			
			System.out.println("접속자 수 : " + threadList.size() + " 명");
		}
		
	}
	
	// 접속 중인 쓰레드에게 chat 내용 보낸다.
	// sendChat() 메소드 정의문
	public void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
		
	}
	
	class ThreadServerClass extends Thread {
		
		Socket socket1;
		
		DataInputStream inputStream;
		DataOutputStream outputStream;
		
		// 생성자
		public ThreadServerClass(Socket s1) throws IOException {
	
			socket1 = s1;
			inputStream = new DataInputStream(s1.getInputStream()); // 입력 스트림
			outputStream = new DataOutputStream(s1.getOutputStream()); // 출력 스트림
			
		}
		
		public void run() {
			
			String nickname = "";
			
			try {
				
				if (inputStream != null) {
					
					nickname = inputStream.readUTF();
					
					sendChat(nickname + " 님 입장~");
					
				}
				
				while (inputStream != null)
					sendChat(inputStream.readUTF()); // 클라이언트가 보낸 채팅 내용을 접속한 모두에게 보낸다.
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} finally {
				
				// 나간 쓰레드의 인덱스 찾기
				for (int i=0; i<threadList.size(); i++) {
					
					if (socket1.equals(threadList.get(i).socket1)) {
						
						threadList.remove(i); // 퇴장 시 remove
						
						try {
							
							sendChat(nickname + " 님 퇴장~");
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
				}
				
				System.out.println("접속자 수 : " + threadList.size() + " 명");
				
			}
			
		}
	}
	
}

public class TcpMulServer {

	public static void main(String[] args) throws IOException {

		if (args.length != 1) 
			System.out.println("사용법 : 서버실행은 \'java 패키지명.파일명 포트번호 \' 형식으로 입력");
		
		// 객체 생성 - 초기치 생성자
		new ServerClass(Integer.parseInt(args[0])); 
		
	}

}
