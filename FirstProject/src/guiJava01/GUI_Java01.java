package guiJava01;

import java.awt.Frame;

public class GUI_Java01 {

	public static void main(String[] args) {
		Frame f1=new Frame(); //내장 클래스 import java.awt
		f1.setTitle("나라니까"); //객체.메소드 윈도우 타이틀 출력 
//		Frame f1=new Frame("나라니까"); //위 두줄을 합친것 
		f1.setSize(700, 700); //pixel = picture element
		f1.setVisible(true); 
		//ctrl+alt+del에서 해당 프로세스 stop
	}

}
