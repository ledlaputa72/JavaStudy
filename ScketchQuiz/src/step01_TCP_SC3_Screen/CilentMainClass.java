package step01_TCP_SC3_Screen;

import java.net.*;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


class MainFrameLayout extends JFrame  implements MouseListener, MouseMotionListener, ActionListener {
	//필드 정의 ##############################################
	JPanel contentPane; //메인 컨텐츠페인
	JPanel panelCanvas; //그림 그리는 패널
	JPanel panelView; //그림 그리는 패널
	
	//그리기용 컴포넌트
	int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수
	
	//그리기 옵션용 컴포넌트
	Color bgColor=Color.WHITE; //background color
	Color brColor=Color.BLUE; //bruch color
	int brSize=10; //brush Size
	int sw=0; //배경색 sw=1, 붓색 sw=2
	
	//getter setter##############################################
	public JPanel getContentPane() {
		return contentPane;
	}


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
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

	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int getWitchiX() {
		return witchiX;
	}


	public void setWitchiX(int witchiX) {
		this.witchiX = witchiX;
	}


	public int getWitchiY() {
		return witchiY;
	}


	public void setWitchiY(int witchiY) {
		this.witchiY = witchiY;
	}


	public Color getBgColor() {
		return bgColor;
	}


	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}


	public Color getBrColor() {
		return brColor;
	}


	public void setBrColor(Color brColor) {
		this.brColor = brColor;
	}


	public int getBrSize() {
		return brSize;
	}


	public void setBrSize(int brSize) {
		this.brSize = brSize;
	}


	public int getSw() {
		return sw;
	}


	public void setSw(int sw) {
		this.sw = sw;
	}


	public MainFrameLayout() {
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
		
		//마우스 그리기 이벤트용 생성자
		panelCanvas.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		panelCanvas.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
		
	}
	
	
	//####################################################################
	//이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
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
		witchiX=e.getX(); //마우스X의 현재 위치 
		witchiY=e.getY(); //마우스Y의 현재 위치 
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
} // MainFrameLayout end

//#####################################################################
class SendThread extends Thread {
	//클라이언트에서 서버로 데이타 보내기 
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket s1;
	BufferedImage image;
	Robot robot;
	BufferedOutputStream bos1; 
	JPanel panelCanvas=null;

	public SendThread(Socket s1,JPanel panelCanvas) throws IOException, AWTException {
		this.s1 = s1;
		this.panelCanvas = panelCanvas;
		robot = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		
	}
	public void run(){
		try {
			while(true) {
				image = robot.createScreenCapture(new Rectangle(0, 0, 800, 300));//스크린샷을 찍어서 image에 저장해
				ImageIO.write(image, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}

//#####################################################################
class RcvThread extends Thread {
	//클라이언트에서 서버로 부터 받은 데이터 처리 
	Socket socket;
	BufferedInputStream bis1;
	JPanel panelView=null;
	
	public RcvThread(Socket s1,JPanel panelView) throws IOException {
		this.socket = s1;
		this.panelView = panelView;
		bis1 = new BufferedInputStream(s1.getInputStream());
	}
	
	public void run(){
		try {
			panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 700, 300, panelView);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}

//메인 클래스 #######################################################
public class CilentMainClass {
	
	public static void main(String[] args) throws IOException, AWTException {
		
		
		Socket s1=new Socket("127.0.0.1", 7890);
		System.out.println("접속완료 - 클라이언트");
		
		MainFrameLayout mainFrame=new MainFrameLayout(); //그림 그리기 작동
		mainFrame.setVisible(true);

		
		/*try {
			SendThread st=new SendThread(s1,mainFrame.panelCanvas);
			RcvThread rt=new RcvThread(s1,mainFrame.panelView);
			
			st.start();
			rt.start();
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		}*/
		System.out.println("클라이언트 끝");
	}

}
