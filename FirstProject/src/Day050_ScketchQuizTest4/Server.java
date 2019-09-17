package Day050_ScketchQuizTest4;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ServerFrame extends Frame {
	
	private Frame f2=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	static Color bgColor=Color.WHITE; //bruch color

	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	static Button btnStart=new Button("버튼1");
	
	public ServerFrame() {
		//메인 프레임 
		f2.setSize(1280, 720);
		f2.setTitle("Scketch Quiz Server");
		f2.setLayout(blo1);
		f2.setVisible(true);
		f2.add(p1,"North");
		f2.add(p2,"Center");
		f2.add(p3,"South");
		
		//p1설정 
		p1.add(btnStart); //
		
		//p2 중앙 캔버스
		p2.setBackground(bgColor);
		
		//p3 하단 정보 
		p3.setBackground(Color.BLUE);
		
		//닫기
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f2.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}
	
	
}

class ThreadSend extends Thread{
	
	Socket socket;
	BufferedImage image;
	Robot robot;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket socket) throws IOException, AWTException {
		this.socket = socket;
		robot = new Robot();
		bos1 = new BufferedOutputStream(socket.getOutputStream()); 
		while(true) {
			image = robot.createScreenCapture(new Rectangle(0, 0, 1280, 720));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(image, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}

class ThreadRcv extends Thread{
	
	//상수 서버 화면크기, 좌표(모니터 중앙)  //사용자의 해상도를 받아오고 창생성//////////////////
	final int w = 1280, h = 720; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket socket;
	BufferedImage image;
	BufferedInputStream bis1; 
	
	
	public ThreadRcv (Socket socket, ServerFrame sf) throws IOException {
		
		//소켓의 입력스트림을 버퍼스트림으로
		bis1 = new BufferedInputStream(socket.getInputStream());
		//이미지를 받아오는 동시에 화면에 그림
		while(true) {
			sf.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, w, h, sf.p2);
		}
	}
}

public class Server {

	public static void main(String[] args) throws IOException {

		//통신 준비 
			ServerSocket socket_s = null;
			Socket socket = null;
			
		//클라이언트와 접속함
		socket_s = new ServerSocket(12345); //포트 열기 
		ServerFrame sf=new ServerFrame();
		
		while (true) {
		socket = socket_s.accept(); // Listen 
		System.out.println(socket.getInetAddress() + "에서 접속함");
		System.out.println("클라이언트 연결 완료! - 서버" + socket);
		
		//Thread 
		ThreadRcv tr1=new ThreadRcv(socket, sf);
		tr1.start();
		}
	}
}
