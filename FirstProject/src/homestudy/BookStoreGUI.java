package homestudy;

import java.awt.*;
import java.awt.event.*;

//main BookStore Class /////////////////////////////////////////
class BookStore extends Frame implements ActionListener{
	
	//Components /////////////////////////////////////////////
	private Frame mf=new Frame();
	
	private Panel p0=new Panel(); //���� �г�
	private Panel p1=new Panel(); //Ÿ��Ʋ �г�
	private Panel p2=new Panel(); //��ư �г�
	private Panel p3=new Panel(); //�ؽ�Ʈ �г�
	
	private BorderLayout blo= new BorderLayout();
	private FlowLayout flo=new FlowLayout();
	
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
	public BookStore(int frameWeith, int frameHeigth,boolean visBool ) {
		//��
		lb1.setText("���� ���� ���α׷�");
		lb1.setFont(new Font("����",Font.BOLD,20));
		lb1.setAlignment(Label.CENTER);
//		lb1.setBounds(0, 50, 400, 50);
		
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
		mf.setLayout(blo);
		mf.add("North",p0);
		mf.add("Center",p3);
		mf.setSize(frameWeith, frameHeigth);
		mf.setVisible(visBool);
		mf.setResizable(false);
		
		//�ݱ� 
		mf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mf.dispose();
				System.exit(0);
			}
		});
	}//������ end
	
	//�̺�Ʈ �ڵ鷯 /////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource()==bt1) {
			
		}
		if(e1.getSource()==bt2) {
			
		}
		if(e1.getSource()==bt3) {
			
		}
		if(e1.getSource()==bt4) {
			
		}
	}
	
}// BookStore class end


//���� Ŭ���� - BookStore1//////////////////////////////////////////
class BookStore1 extends Frame implements ActionListener{
	private Frame f1=new Frame();
	
	public BookStore1(int subFrameW, int subFrameH, boolean visBool) {

		f1.setTitle("���� �˻�");
		f1.setSize(subFrameW, subFrameH);
		f1.setVisible(visBool);
		f1.setResizable(false);
		
		//�ݱ� 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f1.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//���� Ŭ���� - BookStore1 end


//���� Ŭ���� - BookStore2 //////////////////////////////////////////////
class BookStore2 extends Frame implements ActionListener{
	private Frame f2=new Frame();
	
	public BookStore2(int subFrameW, int subFrameH,boolean visBool) {
		
		f2.setTitle("���� �߰�");
		f2.setSize(subFrameW, subFrameH);
		f2.setVisible(visBool);
		f2.setResizable(false);
		
		//�ݱ� 
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f2.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//���� Ŭ���� - BookStore2 end


//���� Ŭ���� - BookStore3/////////////////////////////////////////////////////
class BookStore3 extends Frame implements ActionListener{
	private Frame f3=new Frame();
	
	public BookStore3(int subFrameW, int subFrameH,boolean visBool) {
		
		f3.setTitle("���� ����");
		f3.setSize(subFrameW, subFrameH);
		f3.setVisible(visBool);
		f3.setResizable(false);
		
		//�ݱ� 
		f3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f3.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//���� Ŭ���� - BookStore3 end


//���� Ŭ���� - BookStore4/////////////////////////////////////////////////////
class BookStore4 extends Frame implements ActionListener{
	private Frame f4=new Frame();
	
	public BookStore4(int subFrameW, int subFrameH,boolean visBool) {

		f4.setTitle("���� ����");
		f4.setSize(subFrameW, subFrameH);
		f4.setVisible(visBool);
		f4.setResizable(false);
		
		//�ݱ� 
		f4.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f4.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//���� Ŭ���� - BookStore3 end


// main ///////////////////////////////////////////////////////////////////
public class BookStoreGUI {

	public static void main(String[] args) {
		BookStore bs=new BookStore(700,700,true);
		BookStore1 bs1=new BookStore1(500,500,false);
		BookStore2 bs2=new BookStore2(500,500,false);
		BookStore3 bs3=new BookStore3(500,500,false);
		BookStore4 bs4=new BookStore4(500,500,false);
		
	}

}
