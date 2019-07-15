package java_GUI_Exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class JFrameExamClass extends JFrame implements ActionListener, ListSelectionListener  {
	
	JLabel jlb1=new JLabel("label1",JLabel.CENTER);
	JLabel jlb2=new JLabel("label2",JLabel.CENTER);
	JLabel jlb3=new JLabel("label3",JLabel.CENTER);
	
	JButton[] jbt=new JButton[7];
	
	JButton jbt1=new JButton("+10");
	JButton jbt2=new JButton("+50");
	JButton jbt3=new JButton("+100");
	
	JButton jbt4=new JButton("button4");
	JButton jbt5=new JButton("button5");
	JButton jbt6=new JButton("button6");
	
	JButton jbt7=new JButton("result");
	
	String[] strarr1= {"1","2","3","4","5"};
	JComboBox jcombo=new JComboBox(strarr1);
	
	String[] strarr2= {"A","B","C","D","E"};
	JList jlist=new JList(strarr2);
	
	static int sum=0;
	static String str="";
	
	public JFrameExamClass() {
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
		
		add(jbt1);
		add(jbt2);
		add(jbt3);
		
		add(jbt4);
		add(jbt5);
		add(jbt6);
		
		add(jbt7);
		add(jcombo);
		add(jlist);
		
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
		jbt6.addActionListener(this);
		
		jbt7.addActionListener(this);
		
		jcombo.addActionListener(this);
		jlist.addListSelectionListener(this);
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==jbt1) {
			sum=sum+10;
			str=str+jbt1.getText()+"\n";
		}
		if (e.getSource()==jbt2) {
			sum=sum+10;
			str=str+jbt1.getText()+"\n";
		}
		if (e.getSource()==jbt2) {
			sum=sum+10;
			str=str+jbt3.getText()+"\n";
		}
		if (e.getSource()==jbt3) {
			sum=sum+10;
			str=str+jbt3.getText()+"\n";
		}
		if (e.getSource()==jbt4) {
			sum=sum+10;
			str=str+jbt4.getText()+"\n";
		}
		if (e.getSource()==jbt5) {
			sum=sum+10;
			str=str+jbt5.getText()+"\n";
		}
		if (e.getSource()==jbt6) {
			sum=sum+10;
			str=str+jbt6.getText()+"\n";
		}
		
		if (e.getSource()==jbt7) {
			JOptionPane.showMessageDialog(null, str+"sum : "+sum);
			sum=0;
			str="";
			for (int i = 0; i < jbt.length-1; i++) {
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

public class JFrameExamMainClass {

	public static void main(String[] args) {
		JFrameExamClass2 jFrame=new JFrameExamClass2();

	}
}
