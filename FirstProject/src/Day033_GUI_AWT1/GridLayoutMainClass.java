package Day033_GUI_AWT1;

import java.awt.*;
import java.awt.event.*;

//설명을 위해 one class 방식으로 했음 
public class GridLayoutMainClass extends Frame {
	public GridLayoutMainClass() {
		
		this.setLayout(new GridLayout(2,3));
		this.add(new Button("눌러봐"));
		this.add(new Button("골라봐"));
		this.add(new Button("웹열?드립실드치지마"));
		this.add(new Button("뭥미"));
		this.add(new Button("뭘 눌러?"));
		this.add(new Button("아무거나"));
		this.add(new Button("아무거나2"));
		this.setSize(300, 300);
		this.setVisible(true);
		//닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});		
	}//생성자 end
	
	public static void main(String[] args) {
		GridLayoutMainClass flc1=new GridLayoutMainClass();
	}

}
