package DAY038_GUI_AWT6;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class EDislpay extends Frame implements ActionListener{
	//��������
	static int sw=0;
	static String s1="             I LOVE YOU";
	Timer t1=new Timer(); //Back Ground Thread 
	
	//GUI
	private Button b1=new Button("����");
	private Button b2=new Button("��");
	private TextField tf1=new TextField();
	
	//������
	public EDislpay() {
		this.setLayout(null);
		//��ư ���̾ƿ�
		b1.setSize(200, 70);
		b1.setForeground(new Color(0,0,255));
		b1.setBackground(new Color(255,180,100));
		b1.setFont(new Font("����",Font.BOLD,20));
		b1.setLocation(130, 200);
		this.add(b1);
		b1.addActionListener(this);
		
		b2.setSize(200, 70);
		b2.setForeground(new Color(0,0,255));
		b2.setBackground(new Color(255,180,100));
		b2.setFont(new Font("����",Font.BOLD,20));
		b2.setLocation(130, 300);
		this.add(b2);
		b2.addActionListener(this);
		
		tf1.setSize(400, 50);
		tf1.setForeground(new Color(0,0,255));
		tf1.setBackground(new Color(255,255,0));
		tf1.setFont(new Font("����",Font.BOLD,35));
		tf1.setLocation(30, 70);
		this.add(tf1);
		
		this.setBackground(new Color(0,200,200));
		this.setTitle("�ڹٴ� ������");
		this.setSize(460,400);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}//������ ����
	
	//�̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1 && sw==0) { //���� ��ư ���� ������
			b1.setEnabled(false);//�������� ����������(��Ȱ��ȭ)
			//t1.schedule�� ����
			//t1.scheduleAtFixedRate(����, 0, 250);
			t1.scheduleAtFixedRate(new TimerTask(){ //�����ð�
				public void run() { //t1�� ����  //TimerTaskó���� �� // �����尡 ������ �ݵ�� run()�� ���� 
				try {s1=s1.substring(1,s1.length())+s1.substring(0,1);
				//1��°���� s1������ �̾Ƴ� + 0��°���� 1���� �̾Ƴ� ==>�� s1�� �ٽ� ���� 
					tf1.setText(s1); //ȭ�� ���
				}catch(Exception e) {
					e.printStackTrace();}
				} //run end //new TimerTask(ó���� ����, delay, period)
			},0,250); //0�� delay �� ����, 250ms���� ������ �������� �ݺ� 
			sw=1;
		}
		
		else if(e.getSource()==b2 && sw==1) {
			b1.setEnabled(true);
			t1.cancel();
			sw=0;
		}
	}//�̺�Ʈ ���� 
	
}//EDisplay end 


public class ElectronicDisplay_GUI2 {

	public static void main(String[] args) {
		
		EDislpay ed1=new EDislpay();

	}

}
