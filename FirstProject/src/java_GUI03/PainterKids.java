package java_GUI03;

import java.awt.*;
import java.awt.event.*;

class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//전역변수 //////////////////////////////////////////////////////////////
	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수 
	
	static int bgColor=0; //background color, 0:WHITE 1:BLACK 2:RED 2:BLUE 3:GREEN 4:YELLOW 5:GRAY
	static int brColor=1; //brush color
	static int brSize=10; //brush Size
	
	
	
	//컴퍼넌트 /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	private GridLayout glo1=new GridLayout(1,8); //p1 상단 메뉴 용 
	
	private Panel p1=new Panel();
	private Panel p2=new Panel();
	private Panel p3=new Panel();
	
	//메뉴 컴퍼넌트
	private Button btnBG=new Button("배경색"); //클릭하면 색을 바꾸기 
	private Label lblBG=new Label(Integer.toString(bgColor)); //현재 배경 색을 표시해 줌
	
	private Button btnBColor=new Button("붓색"); //클릭하면 색을 바꾸기 
	private Label lblBColor=new Label(Integer.toString(brColor)); //현재 브러시 색을 표시해 줌
	
	private Label lblBSize=new Label(Integer.toString(brSize)); //현재 브러시 사이즈를 표시해 줌 (숫자로) 
	private Button btnBSizeUp=new Button("+");
	private Button btnBSizeDn=new Button("-");
	
	private Button btnReset=new Button("그림 지우기");
	
	
	public Painter() { //생성자//////////////////////////////////////////////////////
		f1.addMouseListener(this); //마우스 이벤트 등록
		f1.addMouseMotionListener(this); //마우스 액션 이벤트 등록
		
		//메인 프레임 
		f1.setSize(700, 700);
		f1.setTitle("Kids Painter");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1 상단 메뉴 
		p1.setBackground(Color.RED);
		
		//p2 중앙 캔버스
//		p2.setBackground(Color.GRAY);
		
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
		Graphics g=getGraphics(); //그래픽의 객체를 만듬 
		g.setColor(Color.red); //칼라를 설정 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(10));
		
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
	public void mousePressed(MouseEvent e) { //마우스가 누르고 있을 때
		witchiX=e.getX(); //마우스X의 현재 위치 
		witchiY=e.getY(); //마우스Y의 현재 위치 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}//class end


public class PainterKids {
	
	public static void main(String[] args) {
		Painter sc=new Painter();
		
	}

}//main class end
