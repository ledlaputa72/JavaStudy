package java_GUI02;
//one class로 설명 
import java.awt.*;
import java.awt.event.*;

public class CardLayoutClass extends Frame {
	
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
		
		pan2=new Panel();
		pan2.setBackground(Color.yellow);
		f1.add(pan2,"pan2");//pan2의 별명은 pan2
		
		pan3=new Panel();
		pan3.setBackground(Color.blue);
		f1.add(pan3,"pan3");//pan3의 별명은 pan3
		
		clo1.show(f1, "pan3");
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}

}
