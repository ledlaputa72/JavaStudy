package Day035_GUI_AWT3;
//one class 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class ListBoxClass extends Frame implements ItemListener {
	
	private Label l1,l2;
	private List lst1,lst2;
	private Frame f1;

	public ListBoxClass() { //������
		
		f1=new Frame();
		f1.setTitle("���� ����");
		f1.setSize(500, 500);
		f1.setLayout(null);
		f1.setVisible(true);
		
		l1=new Label("��� ����");
		l1.setSize(100, 50);
		l1.setLocation(50, 50);
		l1.setVisible(true);
		f1.add(l1);
		
		l2=new Label("���� ����");
		l2.setSize(100, 50);
		l2.setLocation(200, 50);
		l2.setVisible(true);
		f1.add(l2);
		
		lst1=new List();
		lst1.add("��õ1");
		lst1.add("����1");
		lst1.add("�λ�1");
		lst1.add("����1");
		lst1.add("����1");
		lst1.add("�뱸1");
		lst1.add("����1");
		lst1.add("��õ2");
		lst1.add("����2");
		lst1.add("�λ�2");
		lst1.add("����2");
		lst1.add("����2");
		lst1.add("�뱸2");
		lst1.add("����2");
		lst1.select(0); //�����Ҷ� ���õǾ��� index 
		lst1.setSize(100, 100);
		lst1.setLocation(50, 100);
		lst1.setVisible(true);
		f1.add(lst1);
		lst1.addItemListener(this);
		
		lst2=new List();
		lst2.add("����");
		lst2.add("����ī");
		lst2.add("����");
		lst2.add("����");
		lst2.select(0);
		lst2.setSize(100, 100);
		lst2.setLocation(200, 100);
		lst2.setVisible(true);
		f1.add(lst2);
		lst2.addItemListener(this);
	
		//â �ݱ� 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}
	
	public static void main(String[] args) {
		ListBoxClass airport=new ListBoxClass();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		/*//�� ���� Ǯ�� 
		if(e.getSource()==lst1)
		JOptionPane.showMessageDialog(null, "��� ���ô� "+lst1.getSelectedItem());
		else if(e.getSource()==lst2)
		JOptionPane.showMessageDialog(null, "���� ���ô� "+lst2.getSelectedItem());*/
		
		//������ ���� Ǯ�� 
		//��� ����///////////////////////////////////////////////
		if (e.getSource()==lst1) { 
			if (e.getItem().equals(new Integer(0))) {
				JOptionPane.showMessageDialog(null, "���0��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else if(e.getItem().equals(new Integer(1))) {
				JOptionPane.showMessageDialog(null, "���1��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else {
				JOptionPane.showMessageDialog(null, "���0~1���� �ƴϳ�","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}//lst1�� ��������  - ��� ����
		//���� ����/////////////////////////////////////////////////
		else if(e.getSource()==lst2) { 
			if (e.getItem().equals(new Integer(0))) {
				JOptionPane.showMessageDialog(null, "����0��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else if(e.getItem().equals(new Integer(1))) {
				JOptionPane.showMessageDialog(null, "����1��° ��������","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else {
				JOptionPane.showMessageDialog(null, "����0~1���� �ƴϳ�","�޽���",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}//lst2�� �������� - ��������
	}

}
