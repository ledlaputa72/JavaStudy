package Day033_GUI_AWT1;

import java.awt.*;
import java.awt.event.*;

//������ ���� one class ������� ���� 
public class GridLayoutMainClass extends Frame {
	public GridLayoutMainClass() {
		
		this.setLayout(new GridLayout(2,3));
		this.add(new Button("������"));
		this.add(new Button("����"));
		this.add(new Button("����?�帳�ǵ�ġ����"));
		this.add(new Button("�o��"));
		this.add(new Button("�� ����?"));
		this.add(new Button("�ƹ��ų�"));
		this.add(new Button("�ƹ��ų�2"));
		this.setSize(300, 300);
		this.setVisible(true);
		//�ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});		
	}//������ end
	
	public static void main(String[] args) {
		GridLayoutMainClass flc1=new GridLayoutMainClass();
	}

}
