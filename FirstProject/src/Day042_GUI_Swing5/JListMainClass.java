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
		jlist1.setVisibleRowCount(5); //5개만 보임
		jscrollpane1=new JScrollPane(); //스크롤바
		jscrollpane1.getViewport().setView(jlist1); //리스트박스를 스크롤에 붙임
		getContentPane().add(jscrollpane1);
		setSize(500,500);
		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource()==jlist1) {
			int size1=jlist1.getModel().getSize(); //JList전체 갯수
			int index1=jlist1.getSelectedIndex(); //선택된 index
			String indexElement1=(String)jlist1.getModel().getElementAt(index1);
			JOptionPane.showMessageDialog(null, "전체갯수는"+String.valueOf(size1)+"     선택 element는"+indexElement1);
		}
		
	}
	
}

public class JListMainClass {

	public static void main(String[] args) {
		new JListClass();

	}

}
