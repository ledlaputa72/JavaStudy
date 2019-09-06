package java_GUI_Exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI_Exam01 extends JFrame implements ActionListener {

	public GUI_Exam01() {
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}

public class GUI_ExamMain01 {

	public static void main(String[] args) {
		GUI_Exam01 ge1=new GUI_Exam01();
		ge1.setSize(500, 500);
		ge1.setVisible(true);
		Cursor c1=new Cursor(Cursor.HAND_CURSOR);
		ge1.setCursor(c1);
		//ge1.setCursor(new Cursor(Cursor.HAND_CURSOR)); //위의 두개를 하나로 합친것 
		
	}

}
