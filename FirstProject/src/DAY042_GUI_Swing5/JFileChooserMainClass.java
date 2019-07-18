package DAY042_GUI_Swing5;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
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
	public void actionPerformed(ActionEvent e) {
		//���� ����
		if (e.getSource()==jbutton1) {
			int isOpenClose = jfilechooser1.showOpenDialog(jbutton1); 
			//showOpenDialog = ���� ��ȭ����, �ݴ�� showSaveDialog
			File filePath1 = jfilechooser1.getSelectedFile();
			//getSelectedFile = ��ȭ���ڿ��� ���� ������ �����ϸ� - ���ó�� 
			//String fileString2 = jfilechooser1.getSelectedFile().getName();
			if(isOpenClose==JFileChooser.APPROVE_OPTION)
			{//0�� ����, 1�� ����
				jlabel1.setText("���ϰ�ι� �̸� :"+filePath1);
				//System.out.println(filePath1);
			}
		}
		//���� ����
		if(e.getSource()==jbutton3) {
			int isOpenClose3 = jfilechooser1.showSaveDialog(jbutton3); 
			File filePath3 = jfilechooser1.getSelectedFile();
			if(isOpenClose3==JFileChooser.APPROVE_OPTION)
			{//0�� ����, 1�� ����
				jlabel1.setText("���ϰ�ι� �̸� :"+filePath3);
			}
		}
		
	} // event end
	
} //class end

public class JFileChooserMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFileChooserClass();
		
	}//main end

}//main class end
