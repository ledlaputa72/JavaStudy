package java_SwingGUI02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JFileChooserClass extends JFrame implements ActionListener {
	//components
	JFileChooser jfilechooser1; //���� �����ϴ� Ŭ���� - JFileChooser
	JButton jbutton1, jbutton2, jbutton3;
	JLabel jlabel1; 	
	
	//constructor ///////////////////////////////
	public JFileChooserClass() {
		setLayout(new FlowLayout());
		jfilechooser1 = new JFileChooser("c:");
		
		jbutton1 = new JButton("���� ����");
		add(jbutton1);
		jbutton1.addActionListener(this);
		
		jbutton3 = new JButton("���� ����");
		add(jbutton3);
		jbutton3.addActionListener(this);
		
		jlabel1 = new JLabel("���ϰ�ΰ� ������ ��");
		add(jlabel1);
		
		setSize(700,700);
		setVisible(true);
	} //constructor end
	
	@Override //event //////////////////////////
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} // event end
	
} //class end

public class JFileChooserMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFileChooserClass();
		
	}//main end

}//main class end
