package java_GUI04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JButtonMainClass extends JFrame implements ActionListener{

	JButton jb1;
	
	public JButtonMainClass() {
		
		jb1 = new JButton("´­·¯ºÁ~~",new ImageIcon("aa.png"));
		jb1.setFont(new Font("±¼¸²",Font.BOLD,32));
		jb1.setBackground(Color.orange);
		
		jb1.addActionListener(this);
		getContentPane().add(jb1);
		
		setVisible(true);
		setSize(1000, 1000);
	}
	
	public static void main(String[] args) {

		JButtonMainClass jbtn=new JButtonMainClass();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
