package java_GUI01;

import java.awt.*;
import java.awt.event.*;

class RollDice extends Frame implements ActionListener{
	
	//���۳�Ʈ
	private Button bt001=new Button("�ֻ����� ��������");
	private TextField tf01=new TextField("�ֻ��� ���� ���ɴϴ�. ");
	private Frame mf01=new Frame();
	
	public RollDice() { //������
		//��ư
		bt001.setBounds(100, 100, 300, 50);
		bt001.setFont(new Font("����",Font.BOLD,24));
		bt001.setForeground(new Color(255,0,0));
		bt001.setBackground(new Color(255,255,0));
		bt001.addActionListener(this);
		
		//�ʵ�
		tf01.setBounds(100, 200, 300, 50);
		tf01.setFont(new Font("����",Font.BOLD,24));
		tf01.setForeground(new Color(0,0,255));
		tf01.setBackground(new Color(0,255,255));
		
		//����������
		mf01.setLayout(null);
		mf01.add(bt001);
		mf01.add(tf01);
		mf01.setSize(500, 500);
		mf01.setVisible(true);
		
		//â�� �ݱ� �����/////////////////////////////////////////
		mf01.addWindowListener(new WindowAdapter() {
		//addWindowListener(new WindowAdapter() { //�������� �������� ���� this�ϋ�
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
	}//������ ����
	
	//�̺�Ʈ �ڵ鷯
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bt001) {
			int num=(int)Math.ceil(6*Math.random());
			tf01.setText(num+"");
			System.out.println(tf01.getText());
			
		}
	}//�̺�Ʈ ����
	
}//Ŭ���� ����

public class TextFeildTest2 {

	public static void main(String[] args) {

		RollDice rd=new RollDice();

	}

}//���� Ŭ���� ����
