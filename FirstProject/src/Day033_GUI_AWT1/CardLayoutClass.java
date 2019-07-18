package Day033_GUI_AWT1;
//one class로 설명 
import java.awt.*;
import java.awt.event.*;

public class CardLayoutClass extends Frame implements MouseListener {
	
	//객체 선언
	Frame f1;
	Panel pan1;
	Panel pan2;
	Panel pan3;
	CardLayout clo1;
	
	public CardLayoutClass() { //생성자
		
		f1=new Frame("나는 프레임이야");
		clo1=new CardLayout();
		f1.setLayout(clo1);//카드식 레이아웃 
		
		pan1=new Panel();
		pan1.setBackground(Color.red);
		f1.add(pan1,"pan1");//pan1의 별명은 pan1
		pan1.addMouseListener(this); //마우스 이벤트 리스너
		
		pan2=new Panel();
		pan2.setBackground(Color.yellow);
		f1.add(pan2,"pan2");//pan2의 별명은 pan2
		pan2.addMouseListener(this); //마우스 이벤트 리스너
		
		pan3=new Panel();
		pan3.setBackground(Color.blue);
		f1.add(pan3,"pan3");//pan3의 별명은 pan3
		pan3.addMouseListener(this); //마우스 이벤트 리스너
		
		clo1.show(f1, "pan1"); //3장의 카드중에 초기에 보이는 것은 pan1
		
		f1.setSize(500, 500);
		f1.setVisible(true);
		
		//닫기
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}//생성자 종료 
	
	//마우스 이벤트 
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
		clo1.previous(f1); //앞 패널로 이동
		//clo1.next(f1); //뒤 패널로 이동 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}
	
}
