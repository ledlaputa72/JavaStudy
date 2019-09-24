package Day039_GUI_Swing2;

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
		//½ºÅ©¸° Áß¾Ó¿¡ ¶ç¿ì±â 
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(screen.getWidth()/2-this.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2-this.getHeight()/2);
		setLocation(xpos, ypos);
	}
	
	public static void main(String[] args) {

		JButtonMainClass jbtn=new JButtonMainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jb1.setIcon(new ImageIcon("bb.png"));
		jb1.setText("Have a Good Time!");
		jb1.setFont(new Font("±¼¸²",Font.BOLD,22));
		jb1.setBackground(Color.yellow);
		
	}

}
