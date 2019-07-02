package homestudy;

import java.awt.*;
import java.awt.event.*;

class BookStore extends Frame implements ActionListener{
	
	//Components /////////////////////////////////////////////
	private Frame f1=new Frame();
	
	private Panel p1=new Panel();
	private Panel p2=new Panel();
	private Panel p3=new Panel();
	
	private BorderLayout b1= new BorderLayout();
	private GridLayout g1=new GridLayout(1,2);
	private GridLayout g2=new GridLayout(1,4);
	
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
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		
		//�г� ��ư 
		p1.setLayout(g1);
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		p1.add(bt4);
		
		//�г� Ÿ��Ʋ 
		p2.setLayout(g2);
		p2.add(lb1);
		
		//�г� �ؽ�Ʈ 
		p3.setLayout(g2);
		p3.add(ta1);
		
		//���� ������
		f1.setLayout(b1);
		f1.add("South",p1);
		f1.add("North",p2);
		f1.add("Center",p3);
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
