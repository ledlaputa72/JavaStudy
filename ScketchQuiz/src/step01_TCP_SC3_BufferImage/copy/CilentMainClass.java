package step01_TCP_SC3_BufferImage.copy;

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
		//
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

class SendThread extends Thread {
	//클라이언트에서 서버로 데이타 보내기 
	Socket s1;
	MainFrameLayout mainFrame;
	
	public SendThread(Socket s1,MainFrameLayout mainFrame) throws IOException {
		this.s1 = s1;
		this.mainFrame = mainFrame;
	}
	
	public void run(){
		try {
			File file1=new File("aa.png");
			//BufferedImage bufferImage = ImageIO.read(file1); // 기존 파일 read 하여 이미지화한다.
			BufferedImage bufferImage = ImageIO.read((ImageInputStream)mainFrame.getPanelCanvas()); // 캔버스 이미지를 읽어 이미지버터에 저장
			ImageIO.write(bufferImage, "png", s1.getOutputStream()); // 소켓의 io stream 을 통해 보낸다.
			
			System.out.print("클라이언트 : 이미지를 서버로 보냄"+"\t");
			System.out.println("보낸 파일 : " + bufferImage);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}


class RcvThread extends Thread {
	//클라이언트에서 서버로 부터 받은 데이터 처리 
	Socket s1;
	MainFrameLayout mainFrame;
	
	public RcvThread(Socket s1,MainFrameLayout mainFrame) throws IOException {
		this.s1 = s1;
		this.mainFrame = mainFrame;
	}
	
	public void run(){
		try {
			BufferedImage bufferImage = ImageIO.read(s1.getInputStream());//read - 네트웍에서 받은
			ImageIO.write(bufferImage, "png", (ImageOutputStream) mainFrame.getPanelView()); //
			//ImageIO.write(bufferImage, "png", viewPanel); //viewPanel에 그리기 
			
			System.out.print("클라이언트 : 서버에서 받은 이미지 그리기"+"\t");
			System.out.println("받은 파일 : " + bufferImage);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}

//메인 클래스 #######################################################
public class CilentMainClass {
	
	public static void main(String[] args) throws IOException {
		MainFrameLayout mainFrame;
		
		mainFrame=new MainFrameLayout(); //그림 그리기 작동
		mainFrame.setVisible(true);
		
		try {
			Socket s1=new Socket("127.0.0.1", 8888);
			
			SendThread st=new SendThread(s1,mainFrame);
			RcvThread rt=new RcvThread(s1,mainFrame);
			
			st.start();
			rt.start();
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		System.out.println("클라이언트 끝");
	}

}
