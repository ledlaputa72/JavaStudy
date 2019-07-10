package java_SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;

class JToolBarClass extends JFrame implements ActionListener {

	private JButton jbutton1,jbutton2,jbutton3,jbutton4,jbutton5;
	private JLabel jlabel1;
	private JToolBar jtoolbar1;
	private Color pickColor;
	
	//생성자
	public JToolBarClass() {
		setLayout(new FlowLayout());
		
		jtoolbar1=new JToolBar();
		
		jbutton1=new JButton("red", new ImageIcon("e:/icon_red.png"));
		jbutton1.addActionListener(this);
		
		jbutton2=new JButton("green", new ImageIcon("e:/icon_green.png"));
		jbutton2.addActionListener(this);
		
		jbutton3=new JButton("30폰트", new ImageIcon("e:/icon_12.png"));
		jbutton3.addActionListener(this);
		
		jbutton4=new JButton("50폰트", new ImageIcon("e:/icon_32.png"));
		jbutton4.addActionListener(this);
		
		jbutton5=new JButton("종료", new ImageIcon("e:/icon_stop.png"));
		jbutton5.addActionListener(this);
		
		jtoolbar1.add(jbutton1);
		jtoolbar1.add(jbutton2);
		jtoolbar1.add(jbutton3);
		jtoolbar1.add(jbutton4);
		jtoolbar1.add(jbutton5);
		
		jtoolbar1.setVisible(true);
		this.add(jtoolbar1);
		
		jlabel1=new JLabel("JToolBar로 멋지게 디자인 하라는");
		add(jlabel1);
		
		setSize(700, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbutton1) {
			pickColor=JColorChooser.showDialog(null,"Color",Color.YELLOW);
			jlabel1.setForeground(pickColor);
		}else if (e.getSource()==jbutton2) {
			pickColor=JColorChooser.showDialog(null,"Color",Color.YELLOW);
			jlabel1.setForeground(pickColor);
		}else if (e.getSource()==jbutton3) {
			jlabel1.setFont(new Font("굴림",Font.BOLD,20));
		}else if (e.getSource()==jbutton4) {
			jlabel1.setFont(new Font("굴림",Font.BOLD,40));
		}else if (e.getSource()==jbutton5) {
			System.exit(0);
		}
	}
	
}


public class JToolBarMainClass {

	public static void main(String[] args) {
		new JToolBarClass();
	}

}
