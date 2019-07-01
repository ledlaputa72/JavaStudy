package java_GUI01;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonClassExam extends Frame {
	
	public ButtonClassExam() { //������
		
		//â�� �ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		//���� ������//////////////////////////////////
		ButtonClassExam bc1=new ButtonClassExam(); 
		bc1.setSize(500, 500);
		//Panel p1=new Panel(); //�г�
		//p1.setSize(300,300); //�г� ũ�� 
		bc1.setTitle("Button�̾�");
		bc1.setLayout(null); //No Layout 
		bc1.setVisible(true);
		
		//Button ��ư///////////////////////////////
		Button b1=new Button("������"); //���� Ŭ����, ����� ���� Ŭ���� 
		b1.setSize(200,200);
		b1.setLocation(100, 100);
		//Button b1=new Button();
		//b1.setLabel("������");
		
		//p1.add(b1);
		b1.setVisible(true);
		bc1.add(b1); //��ư ���̱� 
		
		System.out.println(b1.getLabel());
		//��ư�� title dosâ�� �μ��ϱ� 
	}

}
