package java_GUI02;
//one class�� ���� 
import java.awt.*;
import java.awt.event.*;

public class CardLayoutClass extends Frame {
	
	//��ü ����
	Frame f1;
	Panel pan1;
	Panel pan2;
	Panel pan3;
	CardLayout clo1;
	
	public CardLayoutClass() { //������
		
		f1=new Frame("���� �������̾�");
		clo1=new CardLayout();
		f1.setLayout(clo1);//ī��� ���̾ƿ� 
		
		pan1=new Panel();
		pan1.setBackground(Color.red);
		f1.add(pan1,"pan1");//pan1�� ������ pan1
		
		//�ݱ�
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}//������ ���� 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}

}
