package Day050_ScketchQuizTest4;

import java.awt.*;
import java.awt.event.*;

public class My_Scribble extends Frame implements MouseListener, MouseMotionListener, ActionListener{

	private int witchiX=0, witchiY=0; //마우스의 좌표 , 클래스 밑에 생긴 전역 변수 
	
	public My_Scribble() { //생성자
		this.addMouseListener(this); //마우스 이벤트 등록
		this.addMouseMotionListener(this); //마우스 액션 이벤트 등록
		
		//닫기
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	} //생성자 끝
	
	public static void main(String[] args) {
		My_Scribble sc=new My_Scribble();
		
		sc.setSize(700, 700);
		sc.setTitle("마음대로 낙서장");
		sc.setVisible(true);
		
	}
	
	//이벤트 핸들러 
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g1=getGraphics(); //그래픽의 객체를 만듬 
		g1.setColor(Color.red); //칼라를 설정 
		Graphics2D g2d = (Graphics2D)g1;
		g2d.setStroke(new BasicStroke(10));
		
		//whichiX,whichiY : 처음위치 
		int badaX=e.getX(); //방금(끝) 마우스 위치 
		int badaY=e.getY();
		
		g1.drawLine(witchiX, witchiY, badaX, badaY); //처음 -> 끝 위치까지 선 그리기
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


}
