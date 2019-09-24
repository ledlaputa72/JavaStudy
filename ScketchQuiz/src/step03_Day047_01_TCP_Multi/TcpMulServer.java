package step03_Day047_01_TCP_Multi;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;


//////////////////////////////////////////////////////////
class ServerClass {
	//collection에 들어가는 것은 ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //제네릭
	
	Socket socket; //클라이언트 받아 저장할 곳
	DataOutputStream outputStream; //출력 스트림 
	
	public ServerClass(int portno) throws IOException, InterruptedException { //생성자 
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); //서버소켓 생성 Listen 
		System.out.println("서버가동......");
		
		while (true ) {
			s1 = ss1.accept(); //기다리는 중 
			System.out.println("접속주소 : "+ s1.getInetAddress() + ", 접속포트: "+s1.getPort());
			//#############################################################
			ServerRcvSend serverRS = new ServerRcvSend(s1);//s1초기치 
			ThreadServerClass tServer1 = new ThreadServerClass(s1);//s1초기치 
			serverRS.start();
			tServer1.start();
			
			threadList.add(tServer1);//컬랙션에 add
			//#############################################################
			System.out.println("접속자 수 : " + threadList.size()+" 명");
		}// while end
	}// 생성자 end
	
	// 접속 중인 쓰레드에게 chat 내용 보낸다.
	// sendChat() 메소드 정의문
	public void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
		
	}
	
	//#########################################
	//##    쓰레드 채팅 클래스                                                 ##
	//#########################################
	class ThreadServerClass extends Thread {
		Socket socket1;
		DataInputStream inputStream;
		DataOutputStream outputStream;

		public ThreadServerClass(Socket s1) throws IOException { //생성자 
			socket1 = s1;
			inputStream = new DataInputStream(s1.getInputStream());
			outputStream = new DataOutputStream(s1.getOutputStream());
			//입출력 스트림
		}//생성자 end
		
		public void run() { //run
			String nickname = "";
			try {
				if(inputStream != null) {
					nickname = inputStream.readUTF();
					sendChat(nickname + " 님 입장 !!!(^^)");
				}
				while (inputStream !=null) {
					//System.out.printlin(inputStream.readUTF();
					sendChat(inputStream.readUTF());
					//클라이언트가 보낸 채팅 내용을 접속한 모두에게 보냄
				}
			}
			catch(IOException e) {
				e.printStackTrace();//에러내용 출력을 안하려면 주석단다
			}
			finally {//나간 쓰레드의 인덱스 찾기 
				for (int i = 0; i < threadList.size(); i++) {
					if(socket.equals(threadList.get(i).socket1)) {
						threadList.remove(i);
						//===============
						try {
							sendChat(nickname + " 님 퇴장~~~ (ㅠㅠ)");
						}catch(IOException e) {
							e.printStackTrace();
						}
						//===============
					}//if end
					
				}// for end
				System.out.println("접속자 수 : " + threadList.size()+ " 명");
			} // finally end
		} //run end
	}// ThreadServerClass end
	
	//#########################################
	//##    쓰레드 이미지 통신 클래스                                       ##
	//#########################################
	class ServerRcvSend extends Thread {
		Socket s1;
		 
		BufferedInputStream bufferInput;
		BufferedOutputStream bufferOutput;
		
		BufferedImage bufferImage1; //추가)
		BufferedImage bufferImage2;
		 
		public ServerRcvSend(Socket s1) throws IOException, InterruptedException {
			this.s1 = s1;
			bufferInput = new BufferedInputStream(s1.getInputStream());
			bufferOutput = new BufferedOutputStream(s1.getOutputStream());
		}//생성자
	
		public void run() { //run
			try{
				while (true) {
					bufferImage1= ImageIO.read(bufferInput); //추가) 받은 데이터를 버퍼에 저장
					System.out.println("SR1) 받은 이미지 버퍼: " + bufferImage1); //추가) 버퍼내용 확인
					//받기 먼저#######################################
					System.out.println("1111################################################");
					System.out.println("SR2) 받은 이미지 스트림 : " + bufferInput); //추가) 받은 스트림 데이터 확인 
					System.out.println("22222################################################");
					
					
					//버퍼에 저장############################################
					bufferImage2=bufferImage1;
					System.out.println("버퍼1 :  " + bufferImage1);
					System.out.println("버퍼2 :  " + bufferImage2 );
					
					
					//보내기##############################################
					System.out.println("SS1) 버퍼2 :  " + bufferImage2 );
		
					ImageIO.write(bufferImage2, "bmp", bufferOutput);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
					System.out.println("SS2) 보내는  이미지 버퍼 : " + bufferImage2);
					bufferOutput.flush(); // 버퍼에 쓰인 이미지를 서버로 보
					System.out.println("SS3) 보내는 이미지 : " + bufferOutput);
				
				}//while end
			}
			catch(Exception e) {
				System.out.println("ServerRcvSend 에러내용 : " + e);
			}
		}//run end
	}//ServerRcv end
}// ServerClass end


public class TcpMulServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//new ServeClass()
		new ServerClass(9999);
		//객체생성 - 초기치 생성자 
	}

}

