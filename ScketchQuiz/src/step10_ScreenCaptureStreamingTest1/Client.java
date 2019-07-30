package step10_ScreenCaptureStreamingTest1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//컬러 페인트 클래스 ////////////////////////////////////////////////////////
class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//전역변수 //////////////////////////////////////////////////////////////
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	
	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //배경색 sw=1, 붓색 sw=2
	
	//컴퍼넌트 /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)

	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	static Button btnStream=new Button("화면 전송");
	
	//생성자/////////////////////////////////////////////////////////
	public Painter() { 
		p2.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		p2.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
		
		//메인 프레임 
		f1.setSize(400, 400);
		f1.setTitle("Scketch Quiz Client");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1설정 
		p1.add(btnStream); //화면 전송 버튼
		btnStream.addActionListener(this);
		
		//p2 중앙 캔버스
		p2.setBackground(bgColor);
		
		//p3 하단 정보 
		p3.setBackground(Color.BLUE);
		
		//닫기
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	} //생성자 끝
	
	//이벤트 핸들러 //////////////////////////////////////////////////////
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=p2.getGraphics(); //중요!!! 그래픽의 객체를 만듬 (그림을 그릴 대상에)
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
		/*//화면 이미지 스크린샷 전송 - 쓰레드 처리  (문제 한번만 가고 그뒤로 그림이 안그려짐 )
		ThreadSend ts1;
		try {
			ts1 = new ThreadSend(ss);
			ts1.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}
}//Painter class end


//main class/////////////////////////////////////////////////////
public class Client {
	
	public static void main(String[] args) {
		
		String serverip = "127.0.0.1";//접속 IP
		Socket socket = null; //통신 준비 
		System.out.println("클라이언트 준비완료");//일단 소켓생성
	
	
		try {
			//소켓으로 접속
			socket = new Socket(serverip, 12345); 
			System.out.println("접속완료 - 클라이언트");
			
			
			//그림 기능 작동 
			Painter sc=new Painter(); //그림 그리기 작동
			System.out.println("그림판 작동 - 클라이언트");
			sc.ss=socket;
			
			/*//이미지 전송 - 스크린샵을 이용 --> server에 ThreadSend 클래스로 변경 /////////////////////////
			BufferedImage image; //스크린샷이 저장될 버퍼공간
			Robot r = new Robot(); //스크린샷을 찍는 로봇클래스
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream()); //아웃풋스트림을 버퍼아웃풋으로
			
			while(true) {
			image = r.createScreenCapture(new Rectangle(0, 0, 1280, 720));//스크린샷을 찍어서 image에 저장해
			ImageIO.write(image, "bmp", bout);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bout.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}*/
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
			ThreadSend ts1=new ThreadSend(socket);
			ts1.start();
			
		} catch (Exception e) {
			e.printStackTrace(); //오류 처리
			System.out.println("접속실패 - 클라이언트");
		}

	}//main class end

}//main class end
