package step10_ScreenCaptureStreamingTest2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//메인 GUI 프레임////////////////////////////////////////////////
class JFramTest2 extends JFrame implements MouseListener, MouseMotionListener, ActionListener{
	//컴퍼넌트 필드/////////////////////////////////////////////////
	//레이아웃용 컴포넌트
	private JPanel contentPane;
	private JPanel panelCanvas;
	private JPanel panelView;
	private JPanel panelChat;
	private JTextField textField;
	private JTextArea textArea;
	private JPanel panelUsers;
	
	//그리기용 컴포넌트
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수
	
	//그리기 옵션용 컴포넌트
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //배경색 sw=1, 붓색 sw=2
	
	//통신용 컴포넌트
	static Socket ss;
	
	//생성자 - 레이아웃 잡기 /////////////////////////////////////////////////
	public JFramTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel(); //contentPane 객체 생성
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// 패널 생성
		JPanel panelTop = new JPanel(); //panelTop 객체 생성
		panelTop.setBackground(Color.CYAN);
		panelTop.setBounds(0, 0, 1184, 60);
		panelTop.setLayout(null);
		contentPane.add(panelTop); //추가
		
		panelCanvas = new JPanel(); //panelCanvas 객체 생성
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 400);
		panelCanvas.setVisible(true);
		contentPane.add(panelCanvas);//추가
		
		panelView = new JPanel(); //panelView 객체 생성
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(false);
		contentPane.add(panelView);//추가
		
		panelChat = new JPanel(); //panelChat 객체 생성
		panelChat.setBackground(Color.GRAY);
		panelChat.setBounds(800, 60, 384, 700);
		panelChat.setLayout(null);
		contentPane.add(panelChat);//추가
		
		panelUsers = new JPanel(); // panelUsers 객체 생성
		panelUsers.setBackground(Color.ORANGE);
		panelUsers.setBounds(0, 759, 1184, 180);
		contentPane.add(panelUsers);//추가
		
		// 채팅 필드와 에어리어 생성 
		textField = new JTextField(); //textField 객체 생성
		textField.setBounds(0, 664, 384, 38);
		textField.setColumns(10);
		panelChat.add(textField);//추가
		
		textArea = new JTextArea(); //textArea 객체 생성
		textArea.setBounds(0, 0, 384, 664);
		panelChat.add(textArea);//추가
		
		//마우스 그리기 이벤트용 생성자
		panelCanvas.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		panelCanvas.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
	}//생성자 끝내기 ///////////////////////////////////////
	
	//이벤트 핸들러 //////////////////////////////////////////////////////
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { //마우스가 누르고 있을 때
		witchiX=e.getX(); //마우스X의 현재 위치 
		witchiY=e.getY(); //마우스Y의 현재 위치 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}//JFramTest2 클래스 종료 /////////////////////////////////////////////////////////////


//메인 클래스 
public class JFrameClient {

	public static void main(String[] args) throws IOException, AWTException {
		
		//소켓으로 접속//////////////
		Socket s1 = new Socket("127.0.0.1", 9999); 
		System.out.println("접속완료 - 클라이언트");
		
		//그림 기능 작동////////////// 
		JFramTest2 sc=new JFramTest2(); //그림 그리기 작동
		sc.setVisible(true);
		System.out.println("그림판 작동 - 클라이언트");
		JPanel panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(false);
//		sc.setContentPane(contentPane.add(panelView));
//		contentPane.add(panelView);//추가
		//****panelView add 필요
		
		//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
		ThreadSend ts1=new ThreadSend(s1);
		ts1.start();

	
	}//main class end
		
}

