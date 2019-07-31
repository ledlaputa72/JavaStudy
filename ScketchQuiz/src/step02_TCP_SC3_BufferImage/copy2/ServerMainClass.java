package step02_TCP_SC3_BufferImage.copy2;

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

//서버 <--> 클라 받기 보내기 하나로 통한 ###############################################
class ServerRcvSend extends Thread {
	Socket s1;
	JFrame frame;
	
	BufferedImage bufferImage1=null;
	BufferedInputStream bis1;
	
	BufferedImage bufferImage2=null;
	BufferedOutputStream bos1;
	
	public ServerRcvSend(Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.frame = sf1;
		
		// 받아오기 ///////////////////////////////////////
		bis1 = new BufferedInputStream(s1.getInputStream());
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		
		bufferImage1= ImageIO.read(bis1); //받은 데이터를 버퍼에 저장
		System.out.println("받은 이미지 버퍼: " + bufferImage1); // 버퍼내용 확인
		
		while (true) {
			//받기 먼저#######################################
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);
			System.out.println("받은 이미지 스트림 : " + bis1);
			//보내기 
			System.out.println("받은 이미지 :  " + bis1);
			
			//보내기 다음######################################
			ImageIO.write(bufferImage1, "bmp", bos1);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("보내는  이미지 버퍼: " + bufferImage1);
			bos1.flush(); // 버퍼에 쓰인 이미지를 서버로 보
			System.out.println("보내는 이미지 스트림 : " + bos1);
		}
	}
}//ServerRcv end


//메인 클래스 #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf1 = new ServerFrame();
		sf1.setVisible(true);

		ServerSocket ss1 = new ServerSocket(8888);
		System.out.println("서버 대기중 ....");

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("접속자 정보 : " + s1.toString());
			//쓰레드 /////////////////////////////
			ServerRcvSend srs1 = new ServerRcvSend(s1,sf1);
			srs1.start();
			System.out.println("쓰레드밖 ");

		}
	}
}
