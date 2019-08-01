package step03_TCP_SC3_1ThreadSendRcv;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//서버 테스트 프레임 #########################################
class ServerFrame extends JFrame {
	JFrame frame;
	final static int w = 800, h = 400;
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
		// 창을 만들고
		frame = new JFrame("server");
		frame.setBounds(x, y, w, h); // 상수 크기 받아오기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}//ServerFrame end

//서버 <-- 클라 받기 ###############################################
class ServerRcv extends Thread {
	Socket s1;
	JFrame sf1;

	BufferedInputStream bis1=null;
	
	public BufferedInputStream getBis1() {
		return bis1;
	}

	public void setBis1(BufferedInputStream bis1) {
		this.bis1 = bis1;
	}

	public ServerRcv(Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.sf1 = sf1;
		bis1 = new BufferedInputStream(s1.getInputStream());
		while (true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);
			System.out.println("받은 이미지 : " + bis1);
		}
	}
}//ServerRcv end

//서버 --> 클라 보내기 ###############################################
class ServerSend extends Thread {
	Socket s1;
	ServerRcv rcv; 
	
	BufferedImage bi1;
	BufferedOutputStream bos1;

	public ServerSend(Socket s1) throws IOException {
		this.s1 = s1;
		
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		while (true) {
			bi1= ImageIO.read(rcv.getBis1());;
			ImageIO.write(bi1, "bmp", bos1);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("보내는 이미지 : " + bos1);
			bos1.flush(); // 버퍼에 쓰인 이미지를 서버로 보
			System.out.println("보내는 이미지 : " + bos1);
		}
	}
}//ServerSend end

//메인 클래스 #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf1 = new ServerFrame();
		sf1.setVisible(true);

		ServerSocket ss1 = new ServerSocket(9999);
		System.out.println("서버 대기중 ....");
		

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("접속자 정보 : " + s1.toString());
			//쓰레드 /////////////////////////////
			ServerRcv sr1 = new ServerRcv(s1,sf1);
			sr1.start();
			
			ServerSend sd1 = new ServerSend(s1);
			sd1.start();
		}
	}
}
