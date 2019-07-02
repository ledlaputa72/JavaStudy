package java_GUI02;

import java.awt.*;
import java.awt.event.*;

class TextAreaClass extends Frame  {
	
	TextArea ta1=new TextArea("댓글을 쓰세요",5,50); //5행 50열
	
	public TextAreaClass() {
//		ta1.setSize(100, 400);
		ta1.setFont(new Font("굴림",Font.BOLD, 20));
		ta1.append("(추가되는군요)"); //문자열 추가시 사용
		//String str1="이걸로 댓글 기본글자 정함";
		//ta1.setText(str1);
		ta1.setVisible(true);
		this.add(ta1);
		this.setTitle("TextArea구만");
		this.setSize(700, 700);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		
		//창문 닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
	}//생성자 end
}//class end


public class TextAreaEx01 {

	public static void main(String[] args) {
		TextAreaClass tac1=new TextAreaClass();
		
	}

}
