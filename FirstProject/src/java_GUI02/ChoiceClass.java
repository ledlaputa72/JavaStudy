package java_GUI02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ChoiceClass extends Frame{

	public static void main(String[] args) {
		
		ChoiceClass cc1=new ChoiceClass();
		
		cc1.setTitle("�޺��ڽ�(���̽�");
		Choice c1=new Choice();
		c1.add("����");
		c1.add("���");
		c1.add("��õ");

		c1.remove(0); //index 0�� ������ ���� 
		c1.insert("����", 0); //index 0�� ��ġ�� ������ ���� 
		
		cc1.add(c1); //�����ӿ� �޺� �ֱ� 
		//cc1.pack();
		cc1.setSize(300, 300);
		cc1.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "������ ���� : "+c1.getItemCount()+"\n 0��° ������ : "+c1.getItem(0)); 
		System.out.println("���� ���� : "+c1.getSelectedItem());
		
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�

	}//main end

}//class end
