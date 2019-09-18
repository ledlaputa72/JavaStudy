package Day051_Project;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
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
import javax.swing.JPanel;


//보내기 쓰레드 ////////////////////////////////////////
class ThreadSend extends Thread{
	
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket socket;
	BufferedImage image;
	Robot r;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket s1) throws IOException, AWTException {
		this.socket = s1;
		r = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			image = r.createScreenCapture(new Rectangle(0, 60, 800, 700));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(image, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}////////////////////////////////////////

//받기 쓰레드 ////////////////////////////////////////
class ThreadRcv extends Thread{
	
	Socket socket;
	BufferedInputStream bis1;
	JPanel panelView;
	
	public ThreadRcv(Socket s1,JPanel panelView) throws IOException, AWTException {
		this.socket = s1;
		this.panelView = panelView;
		bis1 = new BufferedInputStream(s1.getInputStream());
		//소켓의 입력스트림을 버퍼스트림으로
		while(true) {
			panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 700, 800, panelView);
		}
	}
}/////////////////////////////////////////////


//메인///////////////////////////////////////
public class Server {
	
	//사용자의 해상도를 받아오고 창생성
	public static void main(String[] args) throws IOException, AWTException {
		
		ServerSocket ss1=new ServerSocket(9999); //포트 열기 
		System.out.println("클라이언트 연결 완료! - 서버");

		
		while (true) {
			System.out.println("연결 중....");
			Socket s1=ss1.accept(); //연결
			System.out.println(s1.getInetAddress()+"접속되었습니다.");
			
			/*ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1 = new ThreadRcv(s1);
			ts1.start();
			tr1.start();*/
		}

	}

}