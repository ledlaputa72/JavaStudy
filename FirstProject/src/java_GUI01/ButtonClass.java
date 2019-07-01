package java_GUI01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ButtonClass2 extends Frame implements ActionListener{ //창문 만들기 위해서 필수 
	
	private Button b1=new Button("눌러봐"); //속성역할
	private Label la1=new Label("여기에 나온다."); //속성역할 
	
	public ButtonClass2() { //생성자
		
		this.setLayout(null); //Layout은 사용자 정의로 
		
		//버튼///////////////////////////////
		b1.setSize(100, 70); //버튼 크기
		b1.setLocation(200, 300); //버튼 내부위치
		this.add(b1); //버튼추가 
		b1.addActionListener(this);//버튼에 이벤트 발생 시 이벤트 핸들러
		//버튼만 이벤트 가능하다는 뜻 /b1.에만 달려있으므로 
		
		//라벨///////////////////////////////
		la1.setSize(100, 70);
		la1.setLocation(200, 150);//라벨 내부위치
		this.add(la1);//라벨추가
		
		//메인 프레임//////////////////////////
		this.setSize(500, 500);//프레임 크기
		this.setVisible(true);
		
		//창문 닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
		
	}//생성자 end

	//이벤트 처리할 내용을 적는 자리 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) { //버튼이 눌러졌으면 처리 (이벤트 핸들러)
			la1.setText("안녕~~ 자바");
		}
	} //actionPerformed end
	
	
	
}//ButtonClass2 end

public class ButtonClass {

	public static void main(String[] args) {

		ButtonClass2 bee1=new ButtonClass2(); //새로만드는 클래스,two class 방식
		
	}
}//main class end
