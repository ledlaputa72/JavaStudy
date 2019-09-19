package step03_ScreenCaptureWindowFix_fullWindow;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//최종 레이아웃에서 그림 그리기 & 보여주기 영역에 대해서 화면 이동과 무관하게 스크린샷을 보여주는 기능 구현  


class JFramServerLayout extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	static JPanel panelCanvas;
	static JPanel panelView;

	//상수 서버 화면크기, 좌표(모니터 중앙) 
	final int w = 800, h = 700; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	
	public JFramServerLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.CYAN);
		panelTop.setBounds(0, 0, 1184, 60);
		contentPane.add(panelTop);
		panelTop.setLayout(null);
		
		panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 700);
		panelCanvas.setVisible(false);
		contentPane.add(panelCanvas);
		
		panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 60, 800, 700);
		panelView.setVisible(true);
		contentPane.add(panelView);
		
		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.GRAY);
		panelChat.setBounds(800, 60, 384, 700);
		contentPane.add(panelChat);
		panelChat.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 664, 384, 38);
		panelChat.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 384, 664);
		panelChat.add(textArea);
		
		JPanel panelUsers = new JPanel();
		panelUsers.setBackground(Color.ORANGE);
		panelUsers.setBounds(0, 759, 1184, 180);
		contentPane.add(panelUsers);
		
	}
}

//쓰레드 센드 
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
			//좌표 핵심##################################################################
			JFramTest2.panelCanvasX=(int)JFramTest2.panelCanvas.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
			JFramTest2.panelCanvasY=(int)JFramTest2.panelCanvas.getLocationOnScreen().getY();
			//###########################################################################
			image = robot.createScreenCapture(new Rectangle(JFramTest2.panelCanvasX-4, JFramTest2.panelCanvasY-60, 800, 700));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(image, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}


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

public class JFrameServer {

	public static void main(String[] args) {
		
		
		JFramServerLayout sc=new JFramServerLayout();
		sc.setVisible(true);
		
		
		//통신 준비 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		try {
			//클라이언트와 접속함
			socket_s = new ServerSocket(9999); //포트 열기 
			socket = socket_s.accept(); // Listen 
			
			System.out.println("클라이언트 연결 완료! - 서버" + socket);

			//소켓의 입력스트림을 버퍼스트림으로
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
	
			//이미지를 받아오는 동시에 화면에 그림
			while(true) {
				sc.panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, 800, 700, sc.panelView);
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
}
