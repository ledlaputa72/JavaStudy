package step04_multiServerTest_GUI2;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;

//########################################################
//클라이언트를 위한 보내기 쓰레드
//########################################################
class ThreadSend extends Thread{
	//필드 컴포넌트 
	Socket socket; //소켓
	static BufferedImage imageSend=null; //보내기 용 버퍼
	Robot robot; //스크린 캡쳐를 위한 로보트 
	BufferedOutputStream outputStream; //출려 스트림 클래스  
	
	public ThreadSend(Socket socket) throws IOException, AWTException {//생성자 ////
		this.socket = socket;
		robot = new Robot();
		
		outputStream = new BufferedOutputStream(socket.getOutputStream()); //소켓 출력
	}//생성자 끝
	
	public void run() {

		try {
			while(true) {
				//좌표 핵심##################################################################
				Painter.p2X=(int)Painter.p1.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
				Painter.p2Y=(int)Painter.p1.getLocationOnScreen().getY();
				//###########################################################################
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-0, 400, 400));//스크린샷을 찍어서 image에 저장해
				System.out.println("###보내기)소켓으로 보냄  : " + outputStream);
				
				ThreadRcv.imageRcv=imageSend; //받기 버퍼에 보내기용 버퍼 내용 붙임 
				
				ImageIO.write(imageSend, "bmp", outputStream);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				outputStream.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//클라이언트를 위한 받기 쓰레드
//########################################################
class ThreadRcv extends Thread{
	//상수 서버 화면크기, 좌표(모니터 중앙) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	//필드 컴포넌트 
	Socket socket;
	static BufferedImage imageRcv=null; //받기용 버퍼
	BufferedInputStream inputStream;
	
	
	public ThreadRcv(Socket socket) throws IOException {//생성자////////////////
		this.socket = socket;
		inputStream = new BufferedInputStream(socket.getInputStream());
	}//생성자 끝
	
	
	public void run() {//run 메소드 //////////////
	
		try {
			while(true) {
				System.out.println("###받기)소켓에서 받음 : " + inputStream);
				ThreadSend.imageSend=imageRcv; //받기 버퍼에 보내기용 버퍼 내용 붙임 
				Painter2.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter2.p2);
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//ServerClass
//########################################################
class ServerClass {
	//collection에 들어가는 것은 ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	static ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //제네릭
	
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
	
	// 접속 중인 쓰레드에게 chat 내용 보낸다.
	// sendChat() 메소드 정의문
	static void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
	}
	
}// ServerClass end////////////////////////////////////////////


//########################################################
//서버를 위한 받기 쓰레드
//########################################################
class ThreadRcvServer extends Thread{
	//상수 서버 화면크기, 좌표(모니터 중앙) 
		static int w = 400, h = 400; 
		static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
		
	
	//필드 컴포넌트 
	Socket socket;
	static BufferedImage imageRcv=null; //받기용 버퍼
	BufferedInputStream inputStreamServer;
	
	public ThreadRcvServer(Socket socket) throws IOException {//생성자////////////////
		this.socket = socket;
		inputStreamServer = new BufferedInputStream(socket.getInputStream());
	}//생성자 끝
	
	public void run() {//run 메소드 //////////////
	
		try {
			while(true) {
				imageRcv=ImageIO.read(inputStreamServer); //데이터를 받아서 버퍼에 저장
				System.out.println("$$$$$$서버 받기1)소켓에서 받음 : " + inputStreamServer);
				ThreadSendServer.imageSend=imageRcv; //받기 버퍼에 보내기용 버퍼 내용 붙임
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamServer)), 0, 0, w, h, Painter.p2);
				System.out.println("$$$$$$서버 받기2)소켓에서 받음 : " + ThreadSendServer.imageSend);
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//서버를 위한 보내기 쓰레드
//########################################################
class ThreadSendServer extends Thread{
	//필드 컴포넌트 
	Socket socket; //소켓
	static BufferedImage imageSend; //보내기 용 버퍼
	BufferedOutputStream outputStreamServer; //출려 스트림 클래스  
	
	public ThreadSendServer(Socket socket) throws IOException, AWTException {//생성자 ////
		this.socket = socket;
		outputStreamServer = new BufferedOutputStream(socket.getOutputStream()); //소켓 출력
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!보내기 서버 쓰레드 시작...");
	}//생성자 끝
	
	public void run() {
		try {
			while(true) {
				System.out.println("&&&&&&&&&서버보내기1)소켓으로 보냄  : " + outputStreamServer);
//				ThreadRcvServer.imageRcv=imageSend; //받기 버퍼에 보내기용 버퍼 내용 붙임 
				System.out.println("&&&&&&&&&서버 보내기2)소켓에서 받음 : " + imageSend);
				ImageIO.write(imageSend, "bmp", outputStreamServer);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				outputStreamServer.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//ThreadServerClass
// 이안에 받기와 보내기 쓰레드를 포함 시킨다. 
//########################################################
class ThreadServerClass extends Thread {
	Socket socket1;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	//이미지 받기 

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
				ServerClass.sendChat(nickname + " 님 입장 !!!(^^)");
			}
//			while (inputStream !=null) {
//				//System.out.printlin(inputStream.readUTF();
//				ServerClass.sendChat(inputStream.readUTF());
//				//클라이언트가 보낸 채팅 내용을 접속한 모두에게 보냄
//			}
			//##############################################
			//받고 출력하기 쓰레드
			//##############################################
			/*//클라이언트 받기 
			ThreadRcv threadR =new ThreadRcv(socket1);
			threadR.start();
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리
			ThreadSend ts1=new ThreadSend(socket1);
			ts1.start();*/
			//서버 받기
			ThreadRcvServer threadRserver = new ThreadRcvServer(socket1);
			threadRserver.start();
			
			//서버 보내기
			ThreadSendServer threadSserver = new ThreadSendServer(socket1);
			threadSserver.start();
			
			//##############################################
			
			}
		catch(IOException | AWTException e) {
			e.printStackTrace();//에러내용 출력을 안하려면 주석단다
			}
		finally {//나간 쓰레드의 인덱스 찾기 
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if(socket1.equals(ServerClass.threadList.get(i).socket1)) {
					ServerClass.threadList.remove(i);
					//===============
					try {
						ServerClass.sendChat(nickname + " 님 퇴장~~~ (ㅠㅠ)");
					}catch(IOException e) {
						e.printStackTrace();
					}
					//===============
				}//if end
				
			}// for end
			System.out.println("접속자 수 : " + ServerClass.threadList.size()+ " 명");
		} // finally end
	} //run end
}// ThreadServerClass end


public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer=new Painter(); //그림 그리기 포함 작동
		System.out.println("그림판 작동 - 클라이언트");
		
		//new ServeClass()
		new ServerClass(8888);

	}

}




