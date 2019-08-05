package step06_02_multiServerTest_Server_ReSend_1Class_Test;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;




class ThreadClientSendClass extends Thread {
	
	Socket s1;
	DataOutputStream DataOutputStream;
	String nickname;
	
	// 초기치로 소켓 객체, 닉네임이 넘어온다.
	public ThreadClientSendClass(Socket s1, String nickname) throws IOException {

		this.s1 = s1;
		this.nickname = nickname;
		
		DataOutputStream = new DataOutputStream(s1.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (DataOutputStream != null)
				DataOutputStream.writeUTF(nickname); // 닉네임 send
				
			/*while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
				*/
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
}

public class TcpMulClient {

	//상수 서버 화면크기, 좌표(모니터 중앙) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;


	public static void main(String[] args) throws NumberFormatException, IOException, AWTException {
			
		Socket s1 = new Socket("127.0.0.1", 8888); // ip 주소, 포트 번호
		
		System.out.println("서버에 연결...");
		
		//그림 기능 작동 
		Painter sendClient=new Painter(); //그림 그리기 작동
		System.out.println("그림판 작동 - 클라이언트");
		
		ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // 닉네임
		Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
		tsend1.start();
		
		//화면 이미지 스크린샷 전송 - 쓰레드 처리###############################################
		//받고 출력하기 쓰레드
		ThreadRcvClient threadR =new ThreadRcvClient(s1);
		threadR.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {		}
		
		//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
		ThreadSendClient ts1=new ThreadSendClient(s1);
		ts1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {		}
		//#########################################################################
			
	}

}
