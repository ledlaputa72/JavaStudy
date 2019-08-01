package step03_Day047_01_TCP_Multi;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


class TestFrameClass extends JFrame implements MouseListener, MouseMotionListener, ActionListener  {
	JPanel contentPane; //메인 컨텐츠페인
	static JPanel panelCanvas; //그림 그리는 패널
	static JPanel panelView; //그림 그리는 패널
	static int panelCanvasX;
	static int panelCanvasY;
	
	int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수
	
	//그리기 옵션용 컴포넌트
	Color bgColor=Color.WHITE; //background color
	Color brColor=Color.BLUE; //bruch color
	int brSize=10; //brush Size
	int sw=0; //배경색 sw=1, 붓색 sw=2
	
	public TestFrameClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		setResizable(false);
		setAlwaysOnTop(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 300);
		panelCanvas.setVisible(true);
		contentPane.add(panelCanvas);//추가
		
		panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(true);
		contentPane.add(panelView);//추가
		
		panelCanvas.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		panelCanvas.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
		}

	
	
	public JPanel getPanelCanvas() {
		return panelCanvas;
	}

	public void setPanelCanvas(JPanel panelCanvas) {
		this.panelCanvas = panelCanvas;
	}

	public JPanel getPanelView() {
		return panelView;
	}

	public void setPanelView(JPanel panelView) {
		this.panelView = panelView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Graphics g=panelCanvas.getGraphics(); //중요!!! 그래픽의 객체를 만듬 (그림을 그릴 대상에)
		g.setColor(brColor); //칼라를 설정 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(brSize));
		
		//whichiX,whichiY : 처음위치 
		int badaX=e.getX(); //방금(끝) 마우스 위치 
		int badaY=e.getY();
		
		g.drawLine(witchiX, witchiY, badaX, badaY); //처음 -> 끝 위치까지 선 그리기
		witchiX=badaX; //다시 처음 위치 값에 끝 값을 넣는다. 
		witchiY=badaY;
		//다시 위의 것을 반복한다. 
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		witchiX=e.getX(); //마우스X의 현재 위치 
		witchiY=e.getY(); //마우스Y의 현재 위치 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}//TestFrameClass end


class ThreadClientSendClass extends Thread {
	
	Socket socket;
	DataOutputStream outputStream;
	String nickname;
	
	// 초기치로 소켓 객체, 닉네임이 넘어온다.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // 닉네임 send
				
			while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
				
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
class ThreadClientRcvClass extends Thread {

	Socket socket;
	DataInputStream inputStream;
	
	// 생성자
	public ThreadClientRcvClass(Socket socket) throws IOException {
		
		this.socket = socket;
		
		inputStream = new DataInputStream(socket.getInputStream()); // read
		
	}
	
	public void run() {
		
		while (inputStream != null) {
			
			try {
				
				System.out.println(inputStream.readUTF());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}


//#########################################################
//보내기 쓰레드 ////////////////////////////////////////
class ThreadSend extends Thread{
	
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket s1;
	Robot robot;
	static BufferedImage bufferImage1;
	static BufferedOutputStream bos1;
	
	TestFrameClass mainFrame;
	
	public ThreadSend(Socket s1, TestFrameClass mainFrame) throws IOException, AWTException {
		this.s1 = s1;
		this.mainFrame = mainFrame;		
		
		robot = new Robot();
		
		while(true) {
			//보내기 ######################################################
			bos1 = new BufferedOutputStream(s1.getOutputStream()); 
			
			//좌표 핵심##################################################################
			TestFrameClass.panelCanvasX=(int)TestFrameClass.panelCanvas.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
			TestFrameClass.panelCanvasY=(int)TestFrameClass.panelCanvas.getLocationOnScreen().getY();
			//###########################################################################
			bufferImage1 = robot.createScreenCapture(new Rectangle(TestFrameClass.panelCanvasX-4, TestFrameClass.panelCanvasY-60, 800, 700));//스크린샷을 찍어서 image에 저장해
			//image = robot.createScreenCapture(new Rectangle(0, 60, 800, 300));//스크린샷을 찍어서 image에 저장해
			System.out.println("CS1) 보내는 이미지 : " + bufferImage1);
			
			ImageIO.write(bufferImage1, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("CS2) 보내는 이미지 : " + bos1);
			
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			System.out.println("CS3) 보내는 이미지 : " + bos1);
		}
	}
}////////////////////////////////////////

//#########################################################
//받기 쓰레드 ////////////////////////////////////////
class ThreadRcv extends Thread{
	
	Socket s1;
	static BufferedImage bufferImage2;
	static BufferedInputStream bis1;
	TestFrameClass mainFrame;
	
	public ThreadRcv(Socket s1, TestFrameClass mainFrame) throws IOException, AWTException {
		this.s1 = s1;
		this.mainFrame = mainFrame;

		while(true) {
			bis1 = new BufferedInputStream(s1.getInputStream());
			System.out.println("CR1) 받은 이미지 : " + bis1);
			
			bufferImage2=ImageIO.read(bis1); //받은 이미지를 버퍼에
			System.out.println("CR2) 받은 이미지 : " + bufferImage2);
			
			mainFrame.panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 360, 800, 400, mainFrame.panelView);
			System.out.println("CR3) 받은 이미지 : " + bis1);
		}
	}
}/////////////////////////////////////////////

public class TcpMulClient {

	public static void main(String[] args) throws IOException {

		try {
			Socket s1 = new Socket("127.0.0.1", 9999); // ip 주소, 포트 번호
			System.out.println("서버에 연결...");
			
			TestFrameClass mainFrame=new TestFrameClass(); //그림 그리기 작동
			mainFrame.setVisible(true);
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // 닉네임
			ThreadClientRcvClass tcr1 = new ThreadClientRcvClass(s1);
			ThreadSend ts1=new ThreadSend(s1,mainFrame);
			ThreadRcv tr1=new ThreadRcv(s1,mainFrame);
			
			/*Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			Thread trcv1 = new Thread(tcr1); // 받는 chat 위해
			Thread tsend2 = new Thread(ts1); // 보내는 이미지 위해
			Thread trcv2 = new Thread(tr1); // 받는 이미지 위해
			
			tsend1.start();
			trcv1.start();
			tsend2.start();
			trcv2.start();*/
			
			tcc1.start();
			tcr1.start();
			ts1.start();
			tr1.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
