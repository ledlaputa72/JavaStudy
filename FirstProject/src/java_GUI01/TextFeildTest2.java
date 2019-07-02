package java_GUI01;

import java.awt.*;
import java.awt.event.*;

class RollDice extends Frame implements ActionListener{
	
	//컴퍼넌트
	private Button bt001=new Button("주사위를 굴리세요");
	private TextField tf01=new TextField("주사위 값이 나옵니다. ");
	private Frame mf01=new Frame();
	
	public RollDice() { //생성자
		//버튼
		bt001.setBounds(100, 100, 300, 50);
		bt001.setFont(new Font("굴림",Font.BOLD,24));
		bt001.setForeground(new Color(255,0,0));
		bt001.setBackground(new Color(255,255,0));
		bt001.addActionListener(this);
		
		//필드
		tf01.setBounds(100, 200, 300, 50);
		tf01.setFont(new Font("굴림",Font.BOLD,24));
		tf01.setForeground(new Color(0,0,255));
		tf01.setBackground(new Color(0,255,255));
		
		//메인프레임
		mf01.setLayout(null);
		mf01.add(bt001);
		mf01.add(tf01);
		mf01.setSize(500, 500);
		mf01.setVisible(true);
		
		//창문 닫기 축약형/////////////////////////////////////////
		mf01.addWindowListener(new WindowAdapter() {
		//addWindowListener(new WindowAdapter() { //프레임을 지정하지 않은 this일떄
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
	}//생성자 종료
	
	//이벤트 핸들러
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bt001) {
			int num=(int)Math.ceil(6*Math.random());
			tf01.setText(num+"");
			System.out.println(tf01.getText());
			
		}
	}//이벤트 종료
	
}//클래스 종료

public class TextFeildTest2 {

	public static void main(String[] args) {

		RollDice rd=new RollDice();

	}

}//메인 클래스 종료
