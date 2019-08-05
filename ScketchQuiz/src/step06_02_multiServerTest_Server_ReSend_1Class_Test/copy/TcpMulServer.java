package step06_02_multiServerTest_Server_ReSend_1Class_Test.copy;

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
class ThreadSend extends Thread {
	// 필드 컴포넌트
	Socket socket; // 소켓
	BufferedImage imageSendC = null; // 보내기 용 버퍼
	Robot robot; // 스크린 캡쳐를 위한 로보트
	BufferedOutputStream outputStreamC; // 출려 스트림 클래스

	public ThreadSend(Socket socket) throws IOException, AWTException {// 생성자 ////
		this.socket = socket;
		robot = new Robot();
		outputStreamC = new BufferedOutputStream(socket.getOutputStream()); // 소켓 출력
	}// 생성자 끝

	public void run() {

		try {
			while (true) {
				// 좌표 핵심##################################################################
				Painter.p2X = (int) Painter.p1.getLocationOnScreen().getX(); // 좌표 변수를 만들고 static으로 변경
				Painter.p2Y = (int) Painter.p1.getLocationOnScreen().getY();
				// ###########################################################################
				imageSendC = robot.createScreenCapture(new Rectangle(Painter.p2X - 0, Painter.p2Y - 0, 400, 400));// 스크린샷을 찍어서 image에 저장해
				System.out.println("###보내기1 : outputStreamC )소켓으로 보냄  : " + outputStreamC);
				ImageIO.write(imageSendC, "bmp", outputStreamC);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				System.out.println("###보내기2 : imageSendC )소켓으로 보냄  : " + imageSendC);
				outputStreamC.flush(); // 버퍼에 쓰인 이미지를 서버로 보냄
			}
		} catch (Exception e) {
			System.out.println("에러출력 : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////

// ########################################################
// 클라이언트를 위한 받기 쓰레드
// ########################################################
class ThreadRcv extends Thread {
	// 상수 서버 화면크기, 좌표(모니터 중앙)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// 필드 컴포넌트
	Socket socket;
	BufferedImage imageRcvC = null; // 받기용 버퍼
	BufferedInputStream inputStreamC;

	public ThreadRcv(Socket socket) throws IOException {// 생성자////////////////
		this.socket = socket;
		inputStreamC = new BufferedInputStream(socket.getInputStream());
	}// 생성자 끝

	public void run() {// run 메소드 //////////////

		try {
			while (true) {
				imageRcvC = ImageIO.read(inputStreamC); 
				System.out.println("$$$$$$클라 받기1)소켓에서 받음 : " + inputStreamC);
				Painter2.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, Painter2.p2);
				System.out.println("$$$$$$클라 받기2)소켓에서 받음 : " + imageRcvC);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.println("에러출력 : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////





// ########################################################
// 서버를 위한 받기 쓰레드
// ########################################################
class ThreadRcvServer extends Thread {
	// 상수 서버 화면크기, 좌표(모니터 중앙)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// 필드 컴포넌트
	Socket socket;
	BufferedImage imageRcvS=null; // 받기용 버퍼
//	BufferedImage imsi=null; // 받기용 버퍼 #방법1)
	static BufferedImage imsi=null; // 받기용 버퍼 ####방법2)
	BufferedInputStream inputStreamS;

	public BufferedImage getImsi() {
		return imsi;
	}

	public void setImsi(BufferedImage imsi) {
		this.imsi = imsi;
	}

	public ThreadRcvServer() {// 생성자////////////////
		
	}// 생성자 끝
	
	public ThreadRcvServer(Socket socket) throws IOException {// 생성자////////////////
		this.socket = socket;
		inputStreamS = new BufferedInputStream(socket.getInputStream());
	}// 생성자 끝

	public void run() {// run 메소드 //////////////

		try {
			while (true) {
				imageRcvS = ImageIO.read(inputStreamS); // 데이터를 받아서 버퍼에 저장
				imsi = imageRcvS;
				System.out.println("$$$$$$서버 받기1)소켓에서 받음 : " + inputStreamS);
//				ThreadSendServer.imageSend=imageRcv; //받기 버퍼에 보내기용 버퍼 내용 붙임
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				System.out.println("$$$$$$서버 받기2)소켓에서 받음 : " + imageRcvS);
				System.out.println("$$$$$$서버 받기3)소켓에서 받음 : " + imsi);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.println("에러출력 : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////
	// ########################################################

/*//########################################################
//서버를 위한 보내기 쓰레드 1
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
*/

//쓰레드 서버 보내기 테스트 2 ###################################################
class ThreadSendServer extends Thread{
	Socket socket; //소켓
//	File inputFile = new File("e:/aa.jpg"); //보내기 테스트용
//	FileInputStream infile = new FileInputStream(inputFile); ////보내기 테스트용
	BufferedImage imageSendS; //보내기 용 버퍼
	BufferedOutputStream outputStreamServer; //출려 스트림 클래스  ////
//	 File file7 = new File("e:/aa7.png");
	
	public ThreadSendServer(Socket socket) throws IOException, AWTException {//생성자 ////
		this.socket = socket;
		outputStreamServer = new BufferedOutputStream(socket.getOutputStream()); //소켓 출력
//		imageSend=ImageIO.read(infile);//방법1 보내기 테스트용
	}
	
	public void run() {
		try {
		while(true) {
			System.out.println("################서버 보내기 테스트###################");
			System.out.println("########서버보내기 1:imageSend )"+imageSendS);
			System.out.println("########서버보내기 2:outputStreamServer )"+outputStreamServer);
			
			//방법0
//			imageSendS=ThreadRcvServer.imsi;
//			ImageIO.write(imageSendS, "bmp", outputStreamServer);
//			outputStreamServer.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
//			Thread.sleep(100);
			
			
//			//방법1 파일 저장 테스트 ########################
//			try {
//				ImageIO.write(ThreadRcvServer.imageRcv, "png", file7);
//				outputStreamServer.flush();
//			} catch (IOException e1) {}//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
									
			
//			//방법 2 직접 읽어오기 #################################
//			try {
//				ImageIO.write(ImageIO.read(ImageIO.createImageInputStream(ThreadRcvServer.inputStreamServer)), "bmp", outputStreamServer);
//				outputStreamServer.flush();
//			} catch (IOException e1) {}//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				
			
			
//			//방법3 버퍼 방식 읽어오기 ###########################################
//			//버퍼 읽는 방식으로 변경 시도 /////////////////////////////
//			byte[] buf = new byte[4096];
//			 
//			int read = 0;
//			//		        while((read = imageSend.read(buf,0,buf.length))!=-1){
//			    try {
//					while((read = imageSend(buf,0,buf.length))!=-1){
//					   outputStreamServer.write(buf,0,read);
//					   outputStreamServer.flush();
//					   Thread.sleep(50);
//					}
//				} catch (IOException | InterruptedException e1) {}
			//#####################################################
							       
			
				Thread.sleep(50);
			
			System.out.println("########서버보내기 3:imageSend )"+imageSendS);
			System.out.println("########서버보내기 4:outputStreamServer )"+outputStreamServer);
			System.out.println("##############################################");
		}
		} catch ( InterruptedException e) {}//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
	}
	
}
//###################################################



/*// 쓰레드 서버 보내기 테스트 3 ###################################################
class ThreadSendServer extends Thread {
	Socket socket; // 소켓
	BufferedImage imageSendS=null; // 보내기 용 버퍼
	BufferedOutputStream outputStreamS; // 출려 스트림 클래스 ////

	public ThreadSendServer(Socket socket) throws IOException, AWTException {// 생성자 ////
		this.socket = socket;
		outputStreamS = new BufferedOutputStream(socket.getOutputStream()); // 소켓 출력
//		imageSend = ThreadRcvServer.imsi; // 받기 버퍼에 보내기용 버퍼 내용 붙임
	}

	ThreadRcvServer trs=new ThreadRcvServer(); //방법1 ) getter setter
	
	
	public void run() {
			while (true) {
				System.out.println("################서버 보내기 테스트###################");
				imageSendS = trs.getImsi(); // 받기 버퍼에 보내기용 버퍼 내용 붙임 //방법1 ) getter setter
//				imageSendS = ThreadRcvServer.imsi; // 받기 버퍼에 보내기용 버퍼 내용 붙임 //방법2) static으로 
				System.out.println("########서버보내기 1:imageSend )" + imageSendS);
				System.out.println("########서버보내기 2:outputStreamServer )" + outputStreamS);

				// 방법 1
				try {
					ImageIO.write(imageSendS, "bmp", outputStreamS);
					outputStreamS.flush();
//					Thread.sleep(100);

				} catch (IOException e1) {// | InterruptedException e1) {//
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println("########서버보내기 3:imageSend )" + imageSendS);
				System.out.println("########서버보내기 4:outputStreamServer )" + outputStreamS);
				System.out.println("##############################################");
		} // 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
	}
}*/

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

			// =====================================================

			System.out.println("접속자 수 : " + threadList.size() + " 명");
		} // while end
	}// 생성자 end

	// 접속 중인 쓰레드에게 chat 내용 보낸다.
	// sendChat() 메소드 정의문
	static void sendChat(String chat) throws IOException {

		for (int i = 0; i < threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
	}

}// ServerClass end////////////////////////////////////////////

// ########################################################
// ThreadServerClass
// 이안에 받기와 보내기 쓰레드를 포함 시킨다.
// ########################################################
class ThreadServerClass extends Thread {
	Socket socket1;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	// 이미지 받기

	public ThreadServerClass(Socket s1) throws IOException { // 생성자
		socket1 = s1;
		inputStream = new DataInputStream(s1.getInputStream());
		outputStream = new DataOutputStream(s1.getOutputStream());
		// 입출력 스트림
	}// 생성자 end

	public void run() { // run
		String nickname = "";
		try {
			if (inputStream != null) {
				nickname = inputStream.readUTF();
				ServerClass.sendChat(nickname + " 님 입장 !!!(^^)");
			}
			// while (inputStream !=null) {
			// //System.out.printlin(inputStream.readUTF();
			// ServerClass.sendChat(inputStream.readUTF());
			// //클라이언트가 보낸 채팅 내용을 접속한 모두에게 보냄
			// }
			// ##############################################
			// 받고 출력하기 쓰레드
			// ##############################################
			/*//클라이언트 받기 
			ThreadRcv threadR =new ThreadRcv(socket1);
			threadR.start();
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리
			ThreadSend ts1=new ThreadSend(socket1);
			ts1.start();*/

			// 서버 받기
			ThreadRcvServer threadRserver = new ThreadRcvServer(socket1);
			threadRserver.start();

			// 서버 보내기
			ThreadSendServer threadSserver = new ThreadSendServer(socket1);
			threadSserver.start();

			// ##############################################

		} catch (IOException | AWTException e) { //
			e.printStackTrace();// 에러내용 출력을 안하려면 주석단다
		} finally {// 나간 쓰레드의 인덱스 찾기
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if (socket1.equals(ServerClass.threadList.get(i).socket1)) {
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
	} // run end
}// ThreadServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer = new Painter(); // 그림 그리기 포함 작동
		System.out.println("그림판 작동 - 서버");

		// new ServeClass()
		new ServerClass(8888);

	}

}
