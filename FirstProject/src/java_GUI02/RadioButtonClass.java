package java_GUI02;

import java.awt.*;
import java.awt.event.*;

public class RadioButtonClass extends Frame {

	public static void main(String[] args) {
		
		RadioButtonClass rbc1=new RadioButtonClass();
		rbc1.setTitle("üũ�ڽ�");
		CheckboxGroup ck1=new CheckboxGroup(); //������ư�� ���鶧 ���
		Checkbox cb1=new Checkbox("���",ck1, false); 
		Checkbox cb2=new Checkbox("��",ck1, true); //����Ʈ ���� 
		Checkbox cb3=new Checkbox("��",ck1, false);
		
		rbc1.setLayout(new FlowLayout());//���� ����
		rbc1.add(cb1);
		rbc1.add(cb2);
		rbc1.add(cb3);
		//cbc1.pack();//������ũ�⸦ ���Ե� ������Ʈ�� ���߶�� �� 
		rbc1.setSize(300, 300);
		rbc1.setVisible(true);
		
		rbc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				rbc1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
		
	}

}
