package java_GUI02;

import java.awt.*;
import java.awt.event.*;

public class ChoiceClass extends Frame{

	public static void main(String[] args) {
		
		ChoiceClass cc1=new ChoiceClass();
		cc1.setTitle("�޺��ڽ�(���̽�");
		
		Choice c1=new Choice();
		c1.add("����");
		c1.add("���");
		c1.add("��õ");
		
		cc1.add(c1);
		//cc1.pack();
		cc1.setSize(300, 300);
		cc1.setVisible(true);
		
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�

	}//main end

}//class end
