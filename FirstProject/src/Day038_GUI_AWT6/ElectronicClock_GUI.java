package Day038_GUI_AWT6;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class EClock extends Frame implements ActionListener{
	//��������

	
	//GUI
	private Button b1=new Button("����");
	private TextField tf1=new TextField();
	private TextField tf2=new TextField();
	private TextField tf3=new TextField();
	private Label lb1=new Label("��");
	private Label lb2=new Label("��");
	private Label lb3=new Label("��");
	
	//������
	public EClock() {
		this.setLayout(null);
		//��ư ���̾ƿ�
		b1.setSize(200, 70);
		b1.setForeground(new Color(0,0,255));
		b1.setBackground(new Color(255,180,100));
		b1.setFont(new Font("����",Font.BOLD,30));
		b1.setLocation(130, 200);
		this.add(b1);
		b1.addActionListener(this);
		
		//���÷��� 
		tf1.setSize(50, 50);
		tf1.setForeground(new Color(0,0,255));
		tf1.setBackground(new Color(255,255,0));
		tf1.setFont(new Font("����",Font.BOLD,30));
		tf1.setLocation(30, 70);
		this.add(tf1);
		
		lb1.setSize(50, 50);
		lb1.setForeground(new Color(0,0,255));
		lb1.setBackground(new Color(255,255,0));
		lb1.setFont(new Font("����",Font.BOLD,30));
		lb1.setLocation(100, 70);
		this.add(lb1);
		
		tf2.setSize(50, 50);
		tf2.setForeground(new Color(0,0,255));
		tf2.setBackground(new Color(255,255,0));
		tf2.setFont(new Font("����",Font.BOLD,30));
		tf2.setLocation(170, 70);
		this.add(tf2);
		
		lb2.setSize(50, 50);
		lb2.setForeground(new Color(0,0,255));
		lb2.setBackground(new Color(255,255,0));
		lb2.setFont(new Font("����",Font.BOLD,30));
		lb2.setLocation(240, 70);
		this.add(lb2);
		
		tf3.setSize(50, 50);
		tf3.setForeground(new Color(0,0,255));
		tf3.setBackground(new Color(255,255,0));;
		tf3.setFont(new Font("����",Font.BOLD,30));
		tf3.setLocation(310, 70);
		this.add(tf3);
		
		lb3.setSize(50, 50);
		lb3.setForeground(new Color(0,0,255));
		lb3.setBackground(new Color(255,255,0));
		lb3.setFont(new Font("����",Font.BOLD,30));
		lb3.setLocation(380, 70);
		this.add(lb3);
		
		this.setBackground(new Color(0,200,200));
		this.setTitle("�ڹ� �ð�");
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

		if(e.getSource()==b1 ) {
			b1.setEnabled(false);
			Timer t1=new Timer(); //Back Ground Thread 
			t1.scheduleAtFixedRate(new TimerTask(){
				public void run() { 
					Date d1=new Date(); //Date�� run������ ���;� ������Ʈ�� �ȴ�. (������ ���� ����)
					tf1.setText(String.valueOf(d1.getHours()));
					tf2.setText(String.valueOf(d1.getMinutes()));
					tf3.setText(String.valueOf(d1.getSeconds()));
				} 
			},1000,1000); //1���� 1�� ��������  
		}
	}//�̺�Ʈ ���� 
	
}//EClock end 


public class ElectronicClock_GUI {

	public static void main(String[] args) {
		
		EClock ec1=new EClock();

	}

}
