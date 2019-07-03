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
		
		//닫기
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}//생성자 종료 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}

}
