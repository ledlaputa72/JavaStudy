package guiJava01;

import java.awt.Frame;

class GUI_Java02 extends Frame{ 

	public GUI_Java02(String me) {
		super(me); //상속에서의 생성자 
		//부모생성자를 찾아감(Frame이 부모인데 이미 내장 클래스이므로 따로 부모 클래스를 만들 필요가 없음) 
	}

	public static void main(String[] args) {

		GUI_Java02 h2=new GUI_Java02("나야"); //나의 객체를 만드는(일반적으로 자기 클래스 밖에서 만드나)
		// 객체생성+초기치 => 생성자 필요  	//"나야"는 타이틀 
		h2.setSize(300,300);
		h2.setVisible(true);
		//Ctrl+Shift+Esc ==> 작업관리자 
	}

}
