package java_GUI01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonClassExam extends Frame {
	
	public ButtonClassExam() { //생성자
		
		//창문 닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		//메인 프레임//////////////////////////////////
		ButtonClassExam bc1=new ButtonClassExam(); 
		bc1.setSize(500, 500);
		//Panel p1=new Panel(); //패널
		//p1.setSize(300,300); //패널 크기 
		bc1.setTitle("Button이야");
		bc1.setLayout(null); //No Layout 
		bc1.setVisible(true);
		
		//Button 버튼///////////////////////////////
		Button b1=new Button("눌러봐"); //내장 클래스, 사용자 정의 클래스 
		b1.setSize(200,200);
		b1.setLocation(100, 100);
		//Button b1=new Button();
		//b1.setLabel("눌러봐");
		
		//p1.add(b1);
		b1.setVisible(true);
		bc1.add(b1); //버튼 붙이기 
		
		System.out.println(b1.getLabel());
		//버튼의 title dos창에 인쇄하기 
	}

}
