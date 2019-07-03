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
		
		pan2=new Panel();
		pan2.setBackground(Color.yellow);
		f1.add(pan2,"pan2");//pan2�� ������ pan2
		
		pan3=new Panel();
		pan3.setBackground(Color.blue);
		f1.add(pan3,"pan3");//pan3�� ������ pan3
		
		clo1.show(f1, "pan3");
		
		f1.setSize(500, 500);
		f1.setVisible(true);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}//������ ���� 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}

}
