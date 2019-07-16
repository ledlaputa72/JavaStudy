package java_GUI_Exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class JFrameExamClass2 extends JFrame implements ActionListener, ListSelectionListener  {
	
	JLabel jlb1=new JLabel("label1",JLabel.CENTER);
	JLabel jlb2=new JLabel("label2",JLabel.CENTER);
	JLabel jlb3=new JLabel("label3",JLabel.CENTER);
	
	JButton[] jbt=new JButton[7];
	
	String[] strarr1= {"1","2","3","4","5"};
	JComboBox jcombo=new JComboBox(strarr1);
	
	String[] strarr2= {"A","B","C","D","E"};
	JList jlist=new JList(strarr2);
	
	static int sum=0;
	static String str="";
	
	public JFrameExamClass2() {
		setLayout(new GridLayout(0,3,30,30));
		
		add(jlb1);
		add(jlb2);
		add(jlb3);

		jbt[0]=new JButton("10");
		jbt[1]=new JButton("50");
		jbt[2]=new JButton("100");
		
		jbt[3]=new JButton("200");
		jbt[4]=new JButton("500");
		jbt[5]=new JButton("1000");
		
		jbt[6]=new JButton("result");
		
		for (int i = 0; i <7; i++) {
			add(jbt[i]);
		}
		
		add(jcombo);
		add(jlist);
		
		for (int i = 0; i < jbt.length; i++) {
			jbt[i].addActionListener(this);
		}
		
		jcombo.addActionListener(this);
		jlist.addListSelectionListener(this);
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 6; i++) {
			if (e.getSource()==jbt[i]) {
//				StringBuffer sb=new StringBuffer(jbt[i].getText());
				str=str+jbt[i].getText()+"\n";
				sum=sum+Integer.parseInt(jbt[i].getText());
			}
//			jbt[i].setEnabled(false);
			System.out.println(jbt[i].getText()+"\n");
		}
		if (e.getSource()==jbt[6]) {
			JOptionPane.showMessageDialog(null, str+"sum : "+sum);
			sum=0;
			str="";
			for (int i = 0; i < jbt.length-1; i++) {
				jbt[i].setEnabled(true);
			}
		}
		else if (e.getSource()==jcombo) {
			JOptionPane.showMessageDialog(null, jcombo.getSelectedItem());
		}
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class JFrameExamMainClass2 {

	public static void main(String[] args) {
		JFrameExamClass jFrame=new JFrameExamClass();

	}
}
