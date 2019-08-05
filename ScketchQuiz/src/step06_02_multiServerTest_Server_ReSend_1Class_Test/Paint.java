package step06_02_multiServerTest_Server_ReSend_1Class_Test;

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
import java.net.Socket;

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
		
		
		//p1 상단 캔버스
		p1.setBackground(Color.YELLOW);
		p1.setBounds(0,0,400,400);

		
		//p2 하단 정보 
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
