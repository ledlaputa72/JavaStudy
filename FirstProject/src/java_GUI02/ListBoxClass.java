package java_GUI02;
//one class 
import java.awt.*;
import java.awt.event.*;

public class ListBoxClass extends Frame {
	
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
		lst1.select(0);
		lst1.setSize(100, 100);
		lst1.setLocation(50, 100);
		lst1.setVisible(true);
		f1.add(lst1);
		
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

}
