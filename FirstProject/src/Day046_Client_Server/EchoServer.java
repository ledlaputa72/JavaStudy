package Day046_Client_Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss1 = new ServerSocket(7111); //Listen 상태, 7111:port번호 
		//내 스스로 서버 클라이언트 인 경우는 port 번호는 한번 사용하고 나면 살아있어 다른 번호로 바꿔야한다. 
		Socket s1 = ss1.accept(); //방금전에 연결된 정보를 저장 
		InputStream is1 = s1.getInputStream(); //소켓에서 입력 스트림 얻기 
		OutputStream os1 = s1.getOutputStream(); //소켓에서 출력 스트림 얻기 
		
		int b1; //byte stream을 처리 
			while (true) {
				b1=is1.read(); //문자열 읽기 Client --> Server
				if(b1==-1) break;
				os1.write(b1); //문자열 출력 Server --> Client 
			}
			//실행은 서버 먼저 run 한후 클라리언트 run
	}
}
