package java_GUI_Exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class JList_ExamClass extends JFrame implements ActionListener, ListSelectionListener {
	
	JLabel[] jLabel=new JLabel[3];
	JButton[] jButton=new JButton[3];
	
	String[] comboArr1= {"1","2","3"};
	String[] comboArr2= {"10","20","30"};
	String[] comboArr3= {"100","200","300"};
	JComboBox[] jCombo=new JComboBox[3];
	
	String[] listArr1= {"A","B","C"};
	String[] listArr2= {"AA","BB","CC"};
	String[] listArr3= {"AAA","BBB","CCC"};
	JList[] jList=new JList[3];
	
	public JList_ExamClass() {
		setLayout(new GridLayout(0,3,30,30));	
		
		jLabel[0]=new JLabel("label1",JLabel.CENTER);
		jLabel[1]=new JLabel("label2",JLabel.CENTER);
		jLabel[2]=new JLabel("label3",JLabel.CENTER);
		
		jButton[0]=new JButton("100");
		jButton[1]=new JButton("500");
		jButton[2]=new JButton("1000");
		
		jCombo[0]=new JComboBox(comboArr1);
		jCombo[1]=new JComboBox(comboArr2);
		jCombo[2]=new JComboBox(comboArr3);
		
		jList[0]=new JList(listArr1);
		jList[1]=new JList(listArr2);
		jList[2]=new JList(listArr3);
		
		for (int i = 0; i < jLabel.length; i++) {
			add(jLabel[i]);
		}
		for (int i = 0; i < jButton.length; i++) {
			add(jButton[i]);
			jButton[i].addActionListener(this);
		}
		for (int i = 0; i < jCombo.length; i++) {
			add(jCombo[i]);
			jCombo[i].addActionListener(this);
		}
		for (int i = 0; i < jList.length; i++) {
			add(jList[i]);
			jList[i].addListSelectionListener(this);
			jList[i].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		
		this.setSize(700,700);
		this.setVisible(true);
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource()==jList[i]) {
				JOptionPane.showMessageDialog(this, jList[i].getSelectedValue());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource()==jButton[i]) {
				JOptionPane.showMessageDialog(this, jButton[i].getText());
			}
			else if (e.getSource()==jCombo[i]) {
				JOptionPane.showMessageDialog(this, jCombo[i].getSelectedItem());
			}
		}
	}
	
}

public class JList_ExamMainClass {

	public static void main(String[] args) {
		JList_ExamClass jList=new JList_ExamClass();

	}

}
