package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TextField2 extends Frame implements ActionListener {
	
	private Button b1=new Button("오늘점심은 뭐니");
//	private Frame f1=new Frame();
	private TextField tf1=new TextField("콩나물밥!!!");
	
	public TextField2() {
		
		//버튼
		b1.setFont(new Font("굴림",Font.BOLD,24));
		b1.setSize(200, 50);
		b1.setLocation(100, 100);
		//b1.setBounds(100,100,200,50); //좌표와 크기를 합친것 (좌표,크기)
		b1.setBackground(Color.GREEN);
		//b1.setBackground(new Color(255,0,0));
		b1.setForeground(Color.RED);
		//b1.setForeground(new Color(0,255,0));
		b1.addActionListener(this);
		
		//텍스트필드
		tf1.setFont(new Font("굴림",Font.BOLD,24));
		tf1.setSize(200, 50);
		tf1.setLocation(100, 200);
		//tf1.setBounds(100,100,200,50);
		tf1.setBackground(new Color(255,255,0));
		
		//메인 프레임
		this.setLayout(null);
		this.add(b1);
		this.add(tf1);
		this.setSize(400, 400);
		this.setVisible(true);
		
		//창문 닫기 축약형/////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
	}//생성자 끝

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			tf1.setText("볶음밥");
			System.out.println(tf1.getText());
		}
	}
}//클래스 끝


public class TextFieldTest {

	public static void main(String[] args) {
		TextField2 tf2=new TextField2();
	}

}
