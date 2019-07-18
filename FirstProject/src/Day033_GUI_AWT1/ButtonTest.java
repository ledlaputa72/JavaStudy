package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ButtonTest2 extends Frame implements ActionListener{
	
	private Label lb=new Label("버튼 테스트");
	private Button b1=new Button("누르세요");
	
	public ButtonTest2(){
		
		this.setLayout(null);
		
		//버튼
		b1.setSize(100, 100);
		b1.setLocation(100, 200);
		this.add(b1);
		b1.addActionListener(this);
		
		//라벨
		lb.setSize(100, 100);
		lb.setLocation(100, 100);
		this.add(lb);
		
		//메인프레임
		this.setSize(400, 400);
		this.setVisible(true);
		
		//창문닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) { //버튼이 눌러졌으면 처리 (이벤트 핸들러)
			lb.setText("눌러요");
		}
		
	}
	
}

public class ButtonTest {

	public static void main(String[] args) {
		ButtonTest2 bt1=new ButtonTest2();
		
	}

}
