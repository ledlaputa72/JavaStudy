package step06_02_multiServerTest_Server_ReSend_1Class_Test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;

// ########################################################
// ServerClass
// ########################################################
class ServerClass {
	// collection에 들어가는 것은 ThreadServerClass only
	// Vector
	// HashMap, Collection.synchronizedMap
	static ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); // 제네릭

	DataOutputStream outputStream; // 출력 스트림

	public ServerClass(int portno) throws IOException, AWTException { // 생성자
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); // 서버소켓 생성 Listen
		System.out.println("서버가동......");

		while (true) {
			s1 = ss1.accept(); // 기다리는 중
			System.out.println("접속주소 : " + s1.getInetAddress() + ", 접속포트: " + s1.getPort());

			// ===================================================
			ThreadServerClass tServer1 = new ThreadServerClass(s1);// s1초기치
			tServer1.start();
			threadList.add(tServer1);// 컬랙션에 add

			System.out.println("접속자 수 : " + threadList.size() + " 명");

			// 서버 받기 //////////////////////////////
			EchoThreadServer ets = new EchoThreadServer(s1);
			ets.start();
			/////////////////////////////////////////
			// =====================================================

		} // while end
	}// 생성자 end

	// 접속 중인 쓰레드에게 chat 내용 보낸다.
	// sendChat() 메소드 정의문
	static void sendChat(String chat) throws IOException {

		for (int i = 0; i < threadList.size(); i++)
			threadList.get(i).dataOutputStream.writeUTF(chat);
	}

}// ServerClass end////////////////////////////////////////////

// ########################################################
// ThreadServerClass
// 이안에 받기와 보내기 쓰레드를 포함 시킨다.
// ########################################################
class ThreadServerClass extends Thread {
	Socket s1;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	// 이미지 받기

	public ThreadServerClass(Socket s1) throws IOException { // 생성자
		this.s1 = s1;
		dataInputStream = new DataInputStream(s1.getInputStream());
		dataOutputStream = new DataOutputStream(s1.getOutputStream());
		// 입출력 스트림
	}// 생성자 end

	public void run() {
		// run
		/*String nickname = "";
		try {
			if (dataInputStream != null) {
				nickname = dataInputStream.readUTF();
				ServerClass.sendChat(nickname + " 님 입장 !!!(^^)");
			}
			
			// 서버 받기 //////////////////////////////
			EchoThreadServer ets=new EchoThreadServer(s1);
			ets.start();
			/////////////////////////////////////////
			
		} catch (IOException e) { //
			e.printStackTrace();// 에러내용 출력을 안하려면 주석단다
		} finally {// 나간 쓰레드의 인덱스 찾기
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if (s1.equals(ServerClass.threadList.get(i).s1)) {
					ServerClass.threadList.remove(i);
					// ===============
					try {
						ServerClass.sendChat(nickname + " 님 퇴장~~~ (ㅠㅠ)");
					} catch (IOException e) {
						e.printStackTrace();
					}
					// ===============
				} // if end
		
			} // for end
			System.out.println("접속자 수 : " + ServerClass.threadList.size() + " 명");
		} // finally end
		*/ } // run end
}// ThreadServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer = new Painter(); // 그림 그리기 포함 작동
		System.out.println("그림판 작동 - 서버");

		// new ServeClass()
		new ServerClass(9999);

	}

}
