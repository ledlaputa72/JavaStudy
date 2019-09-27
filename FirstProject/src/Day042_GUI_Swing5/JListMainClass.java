package Day042_GUI_Swing5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JListClass extends JFrame implements ListSelectionListener {
	
	String[] kwamok= {"Java","C","C++","C#","Pyton","Hadoop","Hive"};
	JList jlist1;
	JScrollPane jscrollpane1;
	
	public JListClass () {
		setLayout(new FlowLayout());
		
		jlist1=new JList(kwamok);
		jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist1.addListSelectionListener(this); //implements ListSelectionListener
		jlist1.setVisibleRowCount(5); //5���� ����
		jscrollpane1=new JScrollPane(); //��ũ�ѹ�
		jscrollpane1.getViewport().setView(jlist1); //����Ʈ�ڽ��� ��ũ�ѿ� ����
		getContentPane().add(jscrollpane1);
		setSize(500,500);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource()==jlist1) {
			int size1=jlist1.getModel().getSize(); //JList��ü ����
			int index1=jlist1.getSelectedIndex(); //���õ� index
			String indexElement1=(String)jlist1.getModel().getElementAt(index1);
			JOptionPane.showMessageDialog(null, "��ü������"+String.valueOf(size1)+"     ���� element��"+indexElement1);
		}
		
	}
	
}

public class JListMainClass {

	public static void main(String[] args) {
		new JListClass();

	}

}
