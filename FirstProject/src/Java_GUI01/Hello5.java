package Java_GUI01;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class Hello5 extends Frame{

	public static void main(String[] args) {
		//�� : ��� only ��)Ű��?[  ]
		//���� ������////////////////////////////////
		Hello5 lc1=new Hello5(); 
		lc1.setSize(500,500);
		lc1.setTitle("���̶�");
		System.out.println("���� ��~~~");//�ܼ�ȭ�� ���
		
		//awt
		//�� ���۳�Ʈ//////////////////////////////
		Label l1=new Label("���� ��~~~", Label.CENTER);
		l1.setFont(new Font("����", Font.BOLD, 24));
		lc1.add("North",l1); //lc1�� l1�� ���δ�. �������� North�� ���(top����) 
		//lc1.add("South",12);
		l1.setSize(200, 100);
		l1.setVisible(true); //Label ���̱�
		
		//���� ������ ���̱�,�ݱ� //////////////////////
		lc1.setVisible(true); //������ ���̱�
		lc1.addWindowListener(new WindowDada()); //�ݱ� Ŭ���� �ʿ�
	}

}
