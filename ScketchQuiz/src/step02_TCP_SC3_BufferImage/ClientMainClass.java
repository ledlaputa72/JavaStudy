package step02_TCP_SC3_BufferImage;

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
	JPanel contentPane; //메인 컨텐츠페인
	JPanel panelCanvas; //그림 그리는 패널
	JPanel panelView; //그림 그리는 패널
	
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
//보내기 쓰레드 ////////////////////////////////////////
class ThreadSend extends Thread{
	
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket socket;
	BufferedImage image;
	Robot robot;
	BufferedOutputStream bos1; 
	JPanel panelCanvas;
	
	public ThreadSend(Socket s1, JPanel panelCanvas) throws IOException, AWTException {
		this.socket = s1;
		this.panelCanvas = panelCanvas;
		
		robot = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		
		while(true) {
			image = robot.createScreenCapture(new Rectangle(0, 60, 800, 300));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(image, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("보내는 이미지 : " + bos1);
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}////////////////////////////////////////

//#########################################################
//받기 쓰레드 ////////////////////////////////////////
class ThreadRcv extends Thread{
	
	Socket socket;
	BufferedInputStream bis1;
	JPanel panelView;
	
	public ThreadRcv(Socket s1, JPanel panelView) throws IOException, AWTException {
		this.socket = s1;
		this.panelView = panelView;
		bis1 = new BufferedInputStream(s1.getInputStream());
		//소켓의 입력스트림을 버퍼스트림으로

		while(true) {
			panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 360, 800, 300, panelView);
			System.out.println("받은 이미지 : " + bis1);
		}
	}
}/////////////////////////////////////////////



//#########################################################
public class ClientMainClass {
public static void main(String[] args) throws IOException {
	
		Socket s1=new Socket("127.0.0.1", 8888);
		System.out.println("접속완료 - 클라이언트");
	
		TestFrameClass mainFrame=new TestFrameClass(); //그림 그리기 작동
		mainFrame.setVisible(true);
		
		//######쓰레드 #######################################
		
		ThreadSend st;
		ThreadRcv rt;
		try {
			st=new ThreadSend(s1,mainFrame.getPanelCanvas());
			rt = new ThreadRcv(s1,mainFrame.getPanelView());
			st.start();
			rt.start();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//######쓰레드 #######################################
		
		System.out.println("클라이언트 끝");
	}
	
}
