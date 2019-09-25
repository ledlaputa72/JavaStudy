package step04_multiServerTest_GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//필드 맴
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	static int p2X;
	static int p2Y;
	
	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //배경색 sw=1, 붓색 sw=2
	
	//컴퍼넌트 /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	
	//생성자/////////////////////////////////////////////////////////
	public Painter() { 
		p1.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		p1.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
		
		//메인 프레임 
		f1.setSize(400, 900);
		f1.setTitle("보내기 클라이언트");
		f1.setLayout(null);
		f1.setVisible(true);
		f1.add(p1);
		f1.add(p2);
		f1.setAlwaysOnTop(true);
		f1.setResizable(false);
		
		
		//p2 중앙 캔버스
		p1.setBackground(Color.YELLOW);
		p1.setBounds(0,0,400,400);

		
		//p3 하단 정보 
		p2.setBackground(Color.CYAN);
		p2.setBounds(0,400,400,400);
		
		//닫기
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	} //생성자 끝
	
	//이벤트 핸들러  ######################################
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=p1.getGraphics(); //중요!!! 그래픽의 객체를 만듬 (그림을 그릴 대상에)
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
}//Painter class end

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
				
			/*while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io 스트림을 통해 상대방에게 chat 보낸다.
				*/
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
/*class ThreadClientRcvClass extends Thread {

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

}*/

public class TcpMulClient {

	//상수 서버 화면크기, 좌표(모니터 중앙) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;


	public static void main(String[] args) throws NumberFormatException, IOException {

			
		try {
			
			Socket s1 = new Socket("127.0.0.1", 8888); // ip 주소, 포트 번호
			
			System.out.println("서버에 연결...");
			
			//그림 기능 작동 
			Painter sendClient=new Painter(); //그림 그리기 작동
			System.out.println("그림판 작동 - 클라이언트");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // 닉네임
			Thread tsend1 = new Thread(tcc1); // 보내는 chat 위해
			tsend1.start();
			
			/*//받고 출력하기 쓰레드
			ThreadRcv threadR =new ThreadRcv(s1);
			threadR.start();*/
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
			ThreadSend threadS=new ThreadSend(s1);
			threadS.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
