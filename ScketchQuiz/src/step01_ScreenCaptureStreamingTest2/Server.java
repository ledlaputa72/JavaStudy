package step01_ScreenCaptureStreamingTest2;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ServerFrame extends JFrame {
	JFrame frame;
	final static int w = 400, h = 400; 
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
	//창을 만들고
	frame = new JFrame("server");
	frame.setBounds(x, y, w, h); //상수 크기 받아오기 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
	
}

class ThreadSend extends Thread{
	
	Socket s1;
	BufferedImage bi1;
	Robot r;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket s1) throws IOException, AWTException {
		this.s1 = s1;
		r = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			bi1 = r.createScreenCapture(new Rectangle(0, 0, 400, 400));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(bi1, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}

class ThreadRcv extends Thread{
	Socket s1;
	BufferedInputStream bin;
	//상수 서버 화면크기, 좌표(모니터 중앙) 
	ServerFrame sf1=new ServerFrame();
	
	public ThreadRcv(Socket s1) throws IOException{
		//소켓의 입력스트림을 버퍼스트림으로
		bin = new BufferedInputStream(s1.getInputStream());
		//이미지를 받아오는 동시에 화면에 그림
		while(true) {
		sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, 400, 700, sf1.frame);
		}
	}
	
}

public class Server {

	public static void main(String[] args) throws IOException {
		ServerFrame sf=new ServerFrame();
		sf.setVisible(true);
		
		ServerSocket ss1 = null;
		Socket s1 = null;
		ss1 = new ServerSocket(8888); //포트 열기 
		
		while(true) {
			//클라이언트와 접속함
			s1 = ss1.accept(); // Listen 
			System.out.println("클라이언트 연결 완료! - 서버" + s1);
			
			ThreadRcv tr1=new ThreadRcv(s1);
			tr1.start();
		} 
		


	}
}