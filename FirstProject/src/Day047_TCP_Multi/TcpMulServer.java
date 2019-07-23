package Day047_TCP_Multi;

import java.io.*;
import java.net.*;
import java.util.*;

//////////////////////////////////////////////////////////
class ServerClass {
	//collection에 들어가는 것은 ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //제네릭
	
	Socket socket; //클라이언트 받아 저장할 곳
	DataOutputStream outputStream; //출력 스트림 
	
	public ServerClass(int portno) throws IOException { //생성자 
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); //서버소켓 생성 Listen 
		System.out.println("서버가동......");
		
		while (true ) {
			s1 = ss1.accept(); //기다리는 중 
			System.out.println("접속주소 : "+ s1.getInetAddress() + ", 접속포트: "+s1.getPort());
			//===================================================
			ThreadServerClass tServer1 = new ThreadServerClass(s1);//s1초기치 
			tServer1.start();
			threadList.add(tServer1);//컬랙션에 add
			//=====================================================
			System.out.println("접속자 수 : " + threadList.size()+" 명");
		}// while end
	}// 생성자 end
	
	
	//////////////////////////////////////////////////
	class ThreadServerClass extends Thread {
		Socket socket1;
		DataInputStream inputStream;
		DataOutputStream outputStram;

		public ThreadServerClass(Socket s1) throws IOException { //생성자 
			socket1 = s1;
			inputStream = new DataInputStream(s1.getInputStream());
			outputStream = new DataOutputStream(s1.getOutputStream());
			//입출력 스트림
		}//생성자 end
		
	}// ThreadServerClass end
	
}// ServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		if(args.length != 1) {
			System.out.println("사용법 : 서버실행은 "+" \'java 패키지명.파일명 포트번호\' 형식으로 입력");
		}
		
		//new ServeClass()
		new ServerClass(Integer.parseInt(args[0]));
		//객체생성 - 초기치 생성자 
	}

}

