package Day034_GUI_AWT2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ChoiceClass2 extends Frame implements ItemListener{
	
	public static void main(String[] args) {
		
		ChoiceClass2 cc1=new ChoiceClass2();
		cc1.setTitle("�޺��ڽ�(���̽�");
		
		Choice c1=new Choice();
		c1.add("��������� �����ϼ���");
		c1.add("����");
		c1.add("���");
		c1.add("��õ");
		c1.addItemListener(cc1);
		
		cc1.add(c1); //�����ӿ� ���ù�ư �ֱ� 
		cc1.setSize(300, 350);
		cc1.setVisible(true);
		
		//�ݱ�
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�

	}//main end

	//Item�� ���� �̺�Ʈ ó�� 
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals("����"))
		JOptionPane.showMessageDialog(null, "1��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE, null);
		else if(e.getItem().equals("���"))
		JOptionPane.showMessageDialog(null, "2��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE, null);
		else if(e.getItem().equals("��õ"))
		JOptionPane.showMessageDialog(null, "3��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE, null);
	}

}//class end
