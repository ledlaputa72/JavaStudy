package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TextField2 extends Frame implements ActionListener {
	
	private Button b1=new Button("���������� ����");
//	private Frame f1=new Frame();
	private TextField tf1=new TextField("�ᳪ����!!!");
	
	public TextField2() {
		
		//��ư
		b1.setFont(new Font("����",Font.BOLD,24));
		b1.setSize(200, 50);
		b1.setLocation(100, 100);
		//b1.setBounds(100,100,200,50); //��ǥ�� ũ�⸦ ��ģ�� (��ǥ,ũ��)
		b1.setBackground(Color.GREEN);
		//b1.setBackground(new Color(255,0,0));
		b1.setForeground(Color.RED);
		//b1.setForeground(new Color(0,255,0));
		b1.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�
		tf1.setFont(new Font("����",Font.BOLD,24));
		tf1.setSize(200, 50);
		tf1.setLocation(100, 200);
		//tf1.setBounds(100,100,200,50);
		tf1.setBackground(new Color(255,255,0));
		
		//���� ������
		this.setLayout(null);
		this.add(b1);
		this.add(tf1);
		this.setSize(400, 400);
		this.setVisible(true);
		
		//â�� �ݱ� �����/////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
	}//������ ��

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			tf1.setText("������");
			System.out.println(tf1.getText());
		}
	}
}//Ŭ���� ��


public class TextFieldTest {

	public static void main(String[] args) {
		TextField2 tf2=new TextField2();
	}

}
