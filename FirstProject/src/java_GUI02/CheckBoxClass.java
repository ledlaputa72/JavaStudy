package java_GUI02;

import java.awt.*;
import java.awt.event.*;

//���ǻ� one class�� main���� �ϰ� ����  
public class CheckBoxClass extends Frame {

	public static void main(String[] args) {

		CheckBoxClass cbc1=new CheckBoxClass();
		cbc1.setTitle("üũ�ڽ�");
		Checkbox cb1=new Checkbox("���",true); //����Ʈ�� üũǥ��
		Checkbox cb2=new Checkbox("��",true);
		Checkbox cb3=new Checkbox("��",true);
		
		cbc1.setLayout(new FlowLayout());//���� ����
		cbc1.add(cb1);
		cbc1.add(cb2);
		cbc1.add(cb3);
		//cbc1.pack();//������ũ�⸦ ���Ե� ������Ʈ�� ���߶�� �� 
		cbc1.setSize(300, 300);
		cbc1.setVisible(true);
		
		cbc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cbc1.dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});	//â �ݱ�
		
	}//main end

}
