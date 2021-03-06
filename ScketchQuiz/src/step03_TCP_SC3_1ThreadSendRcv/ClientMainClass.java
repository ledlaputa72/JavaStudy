package step03_TCP_SC3_1ThreadSendRcv;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.io.ObjectInputStream.*;
import java.net.*;

import javax.imageio.*;
import javax.imageio.stream.*;
import javax.swing.*;
import javax.swing.border.*;


class TestFrameClass extends JFrame implements MouseListener, MouseMotionListener, ActionListener  {
	static JPanel contentPane; //메인 컨텐츠페인
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
}

//#########################################################
//보내기받기 하나로 통합 ////////////////////////////////////////
class ThreadSendRcv extends Thread{
	
	private static  int w = 800, h = 700; 
	private static  int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket s1;
	Robot robot;
	
	static BufferedImage bufferImage1=null;
	static BufferedImage bufferImage2=null;
	static BufferedOutputStream bos1; 
	static BufferedInputStream bis1;
	
	TestFrameClass mainFrame;
	
	public ThreadSendRcv(Socket s1, TestFrameClass mainFrame) throws IOException, AWTException {
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
			System.out.println("CS1) 보내는 이미지1 : " + bufferImage1);
			
			ImageIO.write(bufferImage1, "png", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("CS2) 보내는 이미지2 : " + bufferImage1);
			
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			System.out.println("CS3) 보내는 이미지3 : " + bos1);
			
			
			//받기
			bis1 = new BufferedInputStream(s1.getInputStream());
			System.out.println("CR1) 받은 이미지1 : " + bis1);
			
			/*bufferImage2=ImageIO.read(bis1); //받은 이미지를 버퍼에
			System.out.println("CR2) 받은 이미지 : " + bufferImage2);*/
			
			mainFrame.panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), mainFrame.panelView.getX(), mainFrame.panelView.getY(), 800, 400, mainFrame.panelView);
			System.out.println("CR3) 받은 이미지2 : " + bis1);
		}
	}
}////////////////////////////////////////


//#########################################################
public class ClientMainClass {
public static void main(String[] args) throws IOException, AWTException {
	
		Socket s1=new Socket("127.0.0.1", 7777);
		System.out.println("접속완료 - 클라이언트");
	
		TestFrameClass mainFrame=new TestFrameClass(); //그림 그리기 작동
		mainFrame.setVisible(true);
		
		//######쓰레드 #######################################

		ThreadSendRcv tsr = new ThreadSendRcv(s1,mainFrame);
		tsr.start();
		System.out.println("쓰레드밖5 ");
		//######쓰레드 #######################################
		
		System.out.println("클라이언트 끝");
	}
	
}
