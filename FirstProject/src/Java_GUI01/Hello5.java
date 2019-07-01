package Java_GUI01;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class Hello5 extends Frame{

	public static void main(String[] args) {
		//라벨 : 출력 only 예)키는?[  ]
		//메인 프레임////////////////////////////////
		Hello5 lc1=new Hello5(); 
		lc1.setSize(500,500);
		lc1.setTitle("라벨이란");
		System.out.println("나는 라벨~~~");//콘솔화면 출력
		
		//awt
		//라벨 컴퍼넌트//////////////////////////////
		Label l1=new Label("나는 라벨~~~", Label.CENTER);
		l1.setFont(new Font("굴림", Font.BOLD, 24));
		lc1.add("North",l1); //lc1에 l1을 붙인다. 방향으로 North를 사용(top방향) 
		//lc1.add("South",12);
		l1.setSize(200, 100);
		l1.setVisible(true); //Label 보이기
		
		//메인 프레임 보이기,닫기 //////////////////////
		lc1.setVisible(true); //프레임 보이기
		lc1.addWindowListener(new WindowDada()); //닫기 클래스 필요
	}

}
