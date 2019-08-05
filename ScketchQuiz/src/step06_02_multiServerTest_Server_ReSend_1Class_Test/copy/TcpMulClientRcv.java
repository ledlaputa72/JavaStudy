package step06_02_multiServerTest_Server_ReSend_1Class_Test.copy;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;

class Painter2 extends Frame {
	//필드 맴
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	
	//컴퍼넌트 /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	
	//생성자/////////////////////////////////////////////////////////
	public Painter2() { 
		
		//메인 프레임 
		f1.setSize(400, 900);
		f1.setTitle("받기 클라이언트");
		f1.setLayout(null);
		f1.setVisible(true);
		f1.add(p1);
		f1.add(p2);
		f1.setAlwaysOnTop(true);
		f1.setResizable(false);
		
		
		//p2 중앙 캔버스
		p1.setBackground(Color.BLUE);
		p1.setBounds(0,0,400,400);

		
		//p3 하단 정보 
		p2.setBackground(Color.WHITE);
		p2.setBounds(0,400,400,400);
		
		//닫기
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	} //생성자 끝
}

public class TcpMulClientRcv {
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			
			Socket s1 = new Socket("127.0.0.1", 8888); // ip 주소, 포트 번호
			
			System.out.println("서버에 연결...");
			
			//그림 기능 작동 
			Painter2 rcvClient=new Painter2(); //받기만 하는 
			System.out.println("그림판 작동 - 클라이언트");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // 닉네임
			Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			tsend1.start();
			
			//받고 출력하기 쓰레드
			ThreadRcv threadR =new ThreadRcv(s1);
			threadR.start();

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
