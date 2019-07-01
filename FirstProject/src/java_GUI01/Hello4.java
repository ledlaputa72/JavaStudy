package java_GUI01;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowDada extends WindowAdapter{ //이벤트 처리를 위해서는 상속받아야 함 
	public void windowClosing(WindowEvent e) { //내장 메소드 
		System.exit(0); //창문 닫기 
		//reture -> C언어 : exit(0);, 자바 : System.exit(0);
	}
} //창문 종료 클래스 

public class Hello4 extends Frame {

	public static void main(String[] args) {
		
		GUI_Java03 h4=new GUI_Java03();
		h4.setSize(300, 300);
		h4.setTitle("나야");
		h4.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서
		h4.setVisible(true);
		h4.addWindowListener(new WindowDada());//창문 종료를 위한 클래스 , 이벤트
	}

}
