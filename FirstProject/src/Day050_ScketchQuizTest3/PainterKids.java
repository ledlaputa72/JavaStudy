package Day050_ScketchQuizTest3;

import java.awt.*;
import java.awt.event.*;

//컬러 페인트 클래스 ////////////////////////////////////////////////////////
class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//전역변수 //////////////////////////////////////////////////////////////
	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //배경색 sw=1, 붓색 sw=2
	
	//컴퍼넌트 /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	private GridLayout glo1=new GridLayout(1,8); //p1 상단 메뉴 용 
	
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	//메뉴 컴퍼넌트
	static Button btnBG=new Button("배경색"); //클릭하면 색을 바꾸기 
	static Label lblBG=new Label("빨간색",Label.CENTER); //현재 배경 색을 표시해 줌
	
	static Button btnBColor=new Button("붓색"); //클릭하면 색을 바꾸기 
	static Label lblBColor=new Label("파란색",Label.CENTER); //현재 브러시 색을 표시해 줌
	
	private Label lblBSize=new Label(Integer.toString(brSize,Label.CENTER)); //현재 브러시 사이즈를 표시해 줌 (숫자로) 
	private Button btnBSizeUp=new Button("+");
	private Button btnBSizeDn=new Button("-");
	
	private Button btnReset=new Button("그림 지우기");
	
	//생성자/////////////////////////////////////////////////////////
	public Painter() { 
		p2.addMouseListener(this); //중요!!!! 마우스 이벤트 등록
		p2.addMouseMotionListener(this); //중요!!! 마우스 액션 이벤트 등록
		
		//메인 프레임 
		f1.setSize(700, 700);
		f1.setTitle("Kids Painter");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1 상단 메뉴 
		p1.setBackground(Color.CYAN);
		p1.setLayout(glo1);
		//배경색
		p1.add(btnBG); //버튼
		p1.add(lblBG);
		lblBG.setBackground(bgColor);
		//브러쉬 색
		p1.add(btnBColor); //버튼
		p1.add(lblBColor);
		lblBColor.setBackground(brColor);
		//브러쉬 사이즈
		p1.add(lblBSize); 
		p1.add(btnBSizeUp); //+버튼
		p1.add(btnBSizeDn); //-버튼
		lblBSize.setText(Integer.toString(brSize));
		
		//화면 지우기
		p1.add(btnReset); //버튼
		
		//p1버튼 이벤트 리스너
		btnBG.addActionListener(this);
		btnBColor.addActionListener(this);
		btnBSizeUp.addActionListener(this);
		btnBSizeDn.addActionListener(this);
		btnReset.addActionListener(this);
		
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
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==btnBG) { //배경 칼라 
			SubPainter.f2.setVisible(true); //칼라 선택 창 오픈(보이기)
			sw=1; //배경 변경 옵션
		}
		else if(arg0.getSource()==btnBColor) { //브러쉬 칼라
			SubPainter.f2.setVisible(true); //칼라 선택 창 오픈(보이기)
			sw=2; //붓 변경 옵션
		}
		else if(arg0.getSource()==btnBSizeUp) { //브러쉬 사이즈 +
			brSize=brSize+2;
			lblBSize.setText(Integer.toString(brSize));
		}
		else if(arg0.getSource()==btnBSizeDn) {//브러쉬 사이즈-
			brSize=brSize-2;
			lblBSize.setText(Integer.toString(brSize));
		}
		else if(arg0.getSource()==btnReset) {
			p2.setBackground(Color.BLACK);
			bgColor=Color.WHITE;
			p2.setBackground(Color.WHITE);
			lblBG.setBackground(bgColor);
		}
	}
	
}//Painter class end

//서브 칼라 선택 창 ///////////////////////////////////////////////
class SubPainter extends Frame implements ActionListener{
	//메인  페인터 화면에서 호출
	static Frame f2=new Frame();
	
	//색지정 버튼 컴퍼넌트 
	private Color pickColor; //칼라값을 담는 임시 저장소 
	private Button btnWhite=new Button("White");
	private Button btnBlack=new Button("Black");
	private Button btnRed=new Button("Red");
	private Button btnBlue=new Button("Blue");
	private Button btnYellow=new Button("Yellow");
	private Button btnGreen=new Button("Green");
	private Button btnOrange=new Button("Orange");
	private Button btnPink=new Button("Pink");
	private Button btnCyan=new Button("Cyan");
	private Button btnMagenta=new Button("Magenta");
	private Button btnLGray=new Button("LGray");
	private Button btnGray=new Button("Gray");
	private Button btnDGray=new Button("DGray");
	
	//서브창 생성자/////////////////////////////////////////////
	public SubPainter() {
		//f2  프레임 
		f2.setSize(200, 200);
		f2.setTitle("서브창");
		f2.setLayout(new GridLayout(4,5));
		f2.setVisible(false); //디폴트는 안보인다. 
		
		//버튼 
		f2.add(btnWhite);
		f2.add(btnBlack);
		f2.add(btnRed);
		f2.add(btnBlue);
		f2.add(btnYellow);
		f2.add(btnGreen);
		f2.add(btnOrange);
		f2.add(btnPink);
		f2.add(btnCyan);
		f2.add(btnMagenta);
		f2.add(btnLGray);
		f2.add(btnGray);
		f2.add(btnDGray);
		
		//버튼 이벤트 
		btnWhite.addActionListener(this);
		btnBlack.addActionListener(this);
		btnRed.addActionListener(this);
		btnBlue.addActionListener(this);
		btnYellow.addActionListener(this);
		btnGreen.addActionListener(this);
		btnOrange.addActionListener(this);
		btnPink.addActionListener(this);
		btnCyan.addActionListener(this);
		btnMagenta.addActionListener(this);
		btnLGray.addActionListener(this);
		btnGray.addActionListener(this);
		btnDGray.addActionListener(this);
		
		//서브 칼라창 가리기
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f2.setVisible(false);
			}
		});	//창 닫기
	}
	
	//버튼 색 이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼의 색을 pickColor에 할당
		if (e.getSource()==btnWhite) {
			pickColor=Color.WHITE;
		}else if (e.getSource()==btnBlack) {
			pickColor=Color.BLACK;
		}else if (e.getSource()==btnRed) {
			pickColor=Color.RED;
		}else if (e.getSource()==btnBlue) {
			pickColor=Color.BLUE;
		}else if (e.getSource()==btnYellow) {
			pickColor=Color.YELLOW;
		}else if (e.getSource()==btnGreen) {
			pickColor=Color.GREEN;
		}else if (e.getSource()==btnOrange) {
			pickColor=Color.ORANGE;
		}else if (e.getSource()==btnPink) {
			pickColor=Color.PINK;
		}else if (e.getSource()==btnCyan) {
			pickColor=Color.CYAN;
		}else if (e.getSource()==btnMagenta) {
			pickColor=Color.MAGENTA;
		}else if (e.getSource()==btnLGray) {
			pickColor=Color.LIGHT_GRAY;
		}else if (e.getSource()==btnGray) {
			pickColor=Color.GRAY;
		}else if (e.getSource()==btnDGray) {
			pickColor=Color.DARK_GRAY;
		}else {
			
		}
		
		//눌러진 버튼에 따라 다른 처리 (sw=1:BG sw=2:BR)
		if (Painter.sw==1) {
			Painter.bgColor=pickColor;
			Painter.p2.setBackground(Painter.bgColor);
			Painter.lblBG.setBackground(Painter.bgColor);
		}else if (Painter.sw==2) {
			Painter.brColor=pickColor;
			Painter.lblBColor.setBackground(Painter.brColor);
		}else {
			
		}
		f2.setVisible(false); //창 가리기 
	}
	
}

//main class/////////////////////////////////////////////////////
public class PainterKids {
	
	public static void main(String[] args) {
		Painter sc=new Painter();
		SubPainter sc1=new SubPainter();
		
	}

}//main class end
