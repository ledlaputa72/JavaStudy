package step04__SC2window_pireSendRcv_OK;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//#############################################################
//                      보내기 쓰레드
//#############################################################
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
				Painter.p2X=(int)Painter.p2.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
				Painter.p2Y=(int)Painter.p2.getLocationOnScreen().getY();
				//###########################################################################
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-400, 400, 400));//스크린샷을 찍어서 image에 저장해
				System.out.println("###보내기)소켓으로 보냄  : " + outputStream);
				
				ThreadRcv.imageRcv=imageSend; //받기 버퍼에 보내기용 버퍼 내용 붙임 
				
				ImageIO.write(imageSend, "bmp", outputStream);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				outputStream.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end
//#############################################################

//#############################################################
//							받기 쓰레드
//#############################################################
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
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter.p2);
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}//ThreadRcv end
//#############################################################

//main class/////////////////////////////////////////////////////
public class Server {

	public static void main(String[] args) throws Exception {
		
		//JFrame GUI 
		Painter frameClinet=new Painter(); //그림 그리기 포함 작동
		System.out.println("그림판 작동 - 클라이언트");
		
		new Server(); //클라이언트방식과 똑같이 생성자 호출
	}//main end

	public Server() throws IOException { //생성자////////////////
	
		//통신 준비 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		socket_s = new ServerSocket(9999); //포트 열기 
		socket = socket_s.accept(); // Listen 
		System.out.println("클라이언트 연결 완료! - 서버" + socket);

		//########### 쓰레드 ###############
		try {
			//받고 출력하기 쓰레드
			ThreadRcv threadR =new ThreadRcv(socket);
			threadR.start();
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
			ThreadSend ts1=new ThreadSend(socket);
			ts1.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}//try end
		//########### 쓰레드 ###############
	}//생성자 end
}//Server Class end


