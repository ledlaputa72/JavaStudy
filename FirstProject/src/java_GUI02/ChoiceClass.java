package java_GUI02;

import java.awt.*;
import java.awt.event.*;

public class ChoiceClass extends Frame{

	public static void main(String[] args) {
		
		ChoiceClass cc1=new ChoiceClass();
		cc1.setTitle("콤보박스(초이스");
		
		Choice c1=new Choice();
		c1.add("서울");
		c1.add("경기");
		c1.add("인천");
		
		cc1.add(c1);
		//cc1.pack();
		cc1.setSize(300, 300);
		cc1.setVisible(true);
		
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기

	}//main end

}//class end
