package DAY039_GUI_Swing2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JComboEvent2 extends JFrame { //implements���� inner ������� 
	String[] comboStr={"���","��","��"}; //�޺��ڽ��� ���� �迭 
	JComboBox jcb1;
	
	public JComboEvent2() { //������
		this.setLayout(new FlowLayout());
		jcb1=new JComboBox(comboStr);
		this.add(jcb1);
		     //�̺�Ʈ ���                      //�̺�Ʈ ���
		jcb1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				JOptionPane.showMessageDialog(null,(String)jcb1.getSelectedItem());
			}
		});
		this.setSize(500, 500);
		this.setVisible(true);
	}	
}

public class JComboEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JComboEvent2();
	}

}
