package homestudy;

import java.awt.*;
import java.awt.event.*;

class BookStore extends Frame implements ActionListener{
	
	//Components /////////////////////////////////////////////
	private Frame f1=new Frame();
	
	private Panel p0=new Panel(); //���� �г�
	private Panel p1=new Panel(); //Ÿ��Ʋ �г�
	private Panel p2=new Panel(); //��ư �г�
	private Panel p3=new Panel(); //�ؽ�Ʈ �г�
	
	private BorderLayout b1= new BorderLayout();
	private GridLayout g0=new GridLayout(2,1); //���� �гο�
	private GridLayout g1=new GridLayout(1,1); //Ÿ��Ʋ �гο�
	private GridLayout g2=new GridLayout(1,4); //��ư �гο�
	
	private Label lb1=new Label("�Ͻ���� ���� ���α׷�");
	private Label lb2=new Label();
	
	private Button bt1=new Button("���� �˻�");
	private Button bt2=new Button("���� �߰�");
	private Button bt3=new Button("���� ����");
	private Button bt4=new Button("���� ����");
	
	private TextArea ta1=new TextArea("�ؽ�Ʈ �����",5,20);
	
	//������ //////////////////////////////////////////////////////////
	public BookStore(int frameWeith, int frameHeigth) {
		//��
		lb1.setText("���� ���� ���α׷�");
		lb1.setFont(new Font("����",Font.BOLD,20));
		lb1.setAlignment(Label.CENTER);
		lb1.setBounds(0, 50, 400, 50);
		
		//�ؽ�Ʈ ����� 
		ta1.setSize(300, 300);
		ta1.setVisible(true);
		
		
		//��ư
		bt1.setFont(new Font("����",Font.BOLD,18));
		bt2.setFont(new Font("����",Font.BOLD,18));
		bt3.setFont(new Font("����",Font.BOLD,18));
		bt4.setFont(new Font("����",Font.BOLD,18));
		
		bt1.setBackground(new Color(0,255,255));
		bt2.setBackground(new Color(0,255,255));
		bt3.setBackground(new Color(0,255,255));
		bt4.setBackground(new Color(0,255,255));
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		
		//North �г� 
		p0.setLayout(g0);
		p0.add(p1);
		p0.add(p2);
	
		//�г� Ÿ��Ʋ - North 
		p1.setLayout(g1);
		p1.setBackground(new Color(255,255,0));
		p1.add(lb1);
		
		//��ư  �г� - North
		p2.setLayout(g2);
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		
		//�г� �ؽ�Ʈ 
		p3.setLayout(g1);
		p3.add(ta1);
		
		//���� ������
		f1.setLayout(b1);
		f1.add("North",p0);
//		f1.add(p3);
		f1.setSize(frameWeith, frameHeigth);
		f1.setVisible(true);
		f1.setResizable(false);
		
		//�ݱ� 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f1.dispose();
				System.exit(0);
			}
		});
	}//������ end
	
	//�̺�Ʈ �ڵ鷯 /////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource()==bt1) {
			
		}
	}
	
}// BookStore class end

// main 
public class BookStoreGUI {

	public static void main(String[] args) {
		BookStore bs1=new BookStore(700,700);
		
	}

}
