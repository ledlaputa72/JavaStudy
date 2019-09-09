package Day035_GUI_AWT3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;;

class Join extends Frame implements ActionListener {
	
	//���۳�Ʈ ///////////////////////////////////////////////////
	private Frame mf=new Frame();
	private Label lb1=new Label("ȸ������");
	private Label lb2=new Label("�̸�");
	private Label lb3=new Label("��ȭ��ȣ");
	private Label lb4=new Label("�ּ�");
	private Label lb5=new Label("����");
	private Label lb6=new Label("��������");
	private Label lb7=new Label("�����λ縻");
	private Label lb8=new Label("");
	private Label lb9=new Label("������ ���ϵ帳�ϴ�.");
	private Label lb10=new Label("");
	private Label lb11=new Label("");
	
	private TextField tf_name=new TextField(); 
	private TextField tf_phone=new TextField();
	private TextField tf_address=new TextField();
	private TextArea ta_welcome=new TextArea("",5,50);
	//������ư
	private CheckboxGroup cbag=new CheckboxGroup();
	private Checkbox cba1=new Checkbox("��",cbag,true);
	private Checkbox cba2=new Checkbox("��",cbag,false);
	//üũ�ڽ�
	private Checkbox cbb1=new Checkbox("�߱�",true);
	private Checkbox cbb2=new Checkbox("�౸");
	private Checkbox cbb3=new Checkbox("����");
	private Checkbox cbb4=new Checkbox("�״Ͻ�");
	
	private Button bt1=new Button("�����ϱ�");
	private Button bt2=new Button("�������");
	
	//������///////////////////////////////////////////////////////
	public Join() {
		
		//ȸ������ 
		lb1.setBounds(200, 50, 300, 50);
		lb1.setFont(new Font("����",Font.BOLD,24));
		
		
		//�̸�
		lb2.setBounds(50, 150, 100, 20);
		lb2.setFont(new Font("����",Font.BOLD,14));
		
		tf_name.setBounds(150, 150, 200, 20);
		tf_name.setFont(new Font("����",Font.BOLD,14));
		
		
		//��ȭ��ȣ
		lb3.setBounds(50, 200, 100, 20);
		lb3.setFont(new Font("����",Font.BOLD,14));
		
		tf_phone.setBounds(150, 200, 200, 20);
		tf_phone.setFont(new Font("����",Font.BOLD,14));
		
		//�ּ�
		lb4.setBounds(50, 250, 100, 20);
		lb4.setFont(new Font("����",Font.BOLD,14));
		
		tf_address.setBounds(150, 250, 200, 20);
		tf_address.setFont(new Font("����",Font.BOLD,14));
		
		//����
		lb5.setBounds(50, 300, 100, 20);
		lb5.setFont(new Font("����",Font.BOLD,14));
		
		cba1.setBounds(150, 300, 50, 20);
		cba2.setBounds(200, 300, 50, 20);
		
		//��������
		lb6.setBounds(50, 350, 100, 20);
		lb6.setFont(new Font("����",Font.BOLD,14));
		
		cbb1.setBounds(150, 350, 50, 20);
		cbb2.setBounds(200, 350, 50, 20);
		cbb3.setBounds(250, 350, 50, 20);
		cbb4.setBounds(300, 350, 50, 20);
		
		//�����λ縻
		lb7.setBounds(50, 400, 100, 20);
		lb7.setFont(new Font("����",Font.BOLD,14));
		
		ta_welcome.setBounds(50, 430, 400, 150);
		ta_welcome.setFont(new Font("����",Font.BOLD,14));

		//���� �޽���
		lb8.setBounds(100, 600, 400, 30);
		lb8.setFont(new Font("����",Font.BOLD,14));
		lb8.setForeground(Color.RED);
		
		//���� ��ư
		bt1.setBounds(100, 620, 100, 40);
		bt1.setFont(new Font("����",Font.BOLD,18));
		bt1.addActionListener(this);
		
		bt2.setBounds(300, 620, 100, 40);
		bt2.setFont(new Font("����",Font.BOLD,18));
		bt2.addActionListener(this);
		
		//����������////////////////////////////////////////////////
		mf.setLayout(null);
		mf.setSize(500, 700);
		mf.setBackground(new Color(100,200,250));
		mf.setVisible(true);
		
		mf.add(lb1);
		mf.add(lb2);
		mf.add(lb3);
		mf.add(lb4);
		mf.add(lb5);
		mf.add(lb6);
		mf.add(lb7);
		mf.add(lb8);
		mf.add(tf_name);
		mf.add(tf_phone);
		mf.add(tf_address);
		mf.add(ta_welcome);
		mf.add(cba1);
		mf.add(cba2);
		mf.add(cbb1);
		mf.add(cbb2);
		mf.add(cbb3);
		mf.add(cbb4);
		mf.add(bt1);
		mf.add(bt2);
		
		//�ݱ�
		mf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				mf.dispose();
				System.exit(0);
			}
		});		
	}//������ ����
	
	//�̺�Ʈ �ڵ鷯 //////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			 try {
				 //���� ���� 
				 lb9.setBounds(100, 50, 200, 40);
				 lb9.setFont(new Font("����",Font.BOLD,20));
				 
				 lb10.setBounds(50, 100, 400, 20);
				 lb10.setFont(new Font("����",Font.BOLD,14));
				 lb10.setText("�̸� : "+tf_name.getText()+", "+"��ȭ : "+tf_phone.getText()+", "+"�ּ� : "+tf_address.getText());
				 
				 lb11.setBounds(50, 130, 400, 20);
				 lb11.setFont(new Font("����",Font.BOLD,14));
				 lb11.setText("�����λ� : "+ta_welcome.getText()); 
				 
				 //����â 
				 Frame subF=new Frame();
				 subF.setSize(400, 200);
				 subF.setBackground(new Color(200,250,100));
				 subF.setVisible(true);
				 subF.setLayout(null);
				 subF.add(lb9);
				 subF.add(lb10);
				 subF.add(lb11);
				 
				//����â �ݱ�&���α׷� ����
				 subF.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							subF.dispose();
//							System.exit(0);
						}
					});
				 
				 //����â �ݱ�
//				 mf.dispose();
				 
				 //�ʵ� ���� ����� 
				 tf_name.setText(null);
				 tf_phone.setText(null);
				 tf_address.setText(null);
				 ta_welcome.setText(null);
				 
			 }catch(NumberFormatException e1) {
				 lb8.setText("��Ȯ�� ������ �Է��� �ּ���"); 
			 }catch(Exception e1){
				lb8.setText(e1.getMessage());
			 }
		}
		if(e.getSource()==bt2) {
			JOptionPane.showMessageDialog(null, "������ �湮���ּ���.");
			mf.dispose();
			System.exit(0);
		}
	}
}//Ŭ���� ����

//main ////////////////////////////////////////////////////////
public class JoinInExam01 {

	public static void main(String[] args) {
		
		Join j1=new Join();
		
	}

}
