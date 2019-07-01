package java_GUI01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ButtonClass2 extends Frame implements ActionListener{ //â�� ����� ���ؼ� �ʼ� 
	
	private Button b1=new Button("������"); //�Ӽ�����
	private Label la1=new Label("���⿡ ���´�."); //�Ӽ����� 
	
	public ButtonClass2() { //������
		
		this.setLayout(null); //Layout�� ����� ���Ƿ� 
		
		//��ư///////////////////////////////
		b1.setSize(100, 70); //��ư ũ��
		b1.setLocation(200, 300); //��ư ������ġ
		this.add(b1); //��ư�߰� 
		b1.addActionListener(this);//��ư�� �̺�Ʈ �߻� �� �̺�Ʈ �ڵ鷯
		//��ư�� �̺�Ʈ �����ϴٴ� �� /b1.���� �޷������Ƿ� 
		
		//��///////////////////////////////
		la1.setSize(100, 70);
		la1.setLocation(200, 150);//�� ������ġ
		this.add(la1);//���߰�
		
		//���� ������//////////////////////////
		this.setSize(500, 500);//������ ũ��
		this.setVisible(true);
		
		//â�� �ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
		
	}//������ end

	//�̺�Ʈ ó���� ������ ���� �ڸ� 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) { //��ư�� ���������� ó�� (�̺�Ʈ �ڵ鷯)
			la1.setText("�ȳ�~~ �ڹ�");
		}
	} //actionPerformed end
	
	
	
}//ButtonClass2 end

public class ButtonClass {

	public static void main(String[] args) {

		ButtonClass2 bee1=new ButtonClass2(); //���θ���� Ŭ����,two class ���
		
	}
}//main class end
