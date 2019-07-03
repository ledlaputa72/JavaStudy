package java_GUI02;
//������ ���� Ǯ�� 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

class Kaja1 extends Frame implements ActionListener{
	private Button btnJoin=new Button("�����ϱ�");
	private Button btnCancel=new Button("�������");
	private Label label1=new Label("�̸�");
	private Label label2=new Label("��ȭ��ȣ");
	private Label label22=new Label("�ּ�");
	private Label label3=new Label("��ȣ�ϴ�����");
	private Label label4=new Label("����");
	private Label label5=new Label("�����λ縻");
	// ��ü ���̹� btnJoin, lblName, txtName ���·� ���İ��̸��� ���°� ����. 
	private TextField txtName, txtPhone, txtJuso;
	private Checkbox chk1 = new Checkbox("�߱�",true);
	private Checkbox chk2 = new Checkbox("�౸",true);
	private Checkbox chk3 = new Checkbox("����",false);
	private Checkbox chk4 = new Checkbox("�״Ͻ�",false);
	private CheckboxGroup checkboxGroup=new CheckboxGroup();
	private Checkbox chkMan = new Checkbox("��",checkboxGroup,true);
	private Checkbox chkWoman = new Checkbox("��",checkboxGroup,false);
	private TextArea textArea;
	
	public Kaja1() {//������
		this.setLayout(null);
		
		label1.setSize(30,20); //�̸��� ũ�� 
		label1.setLocation(50, 50); //�̸��� ��ġ
		this.add(label1); //���̱�
		
		txtName=new TextField(); //�̸� �ۻ��� ����
		txtName.setSize(100, 30); //�̸� �ۻ��� ũ��
		txtName.setLocation(130, 50); //�̸� �ۻ��� ��ġ
		this.add(txtName); //���̱� 
		
		label2.setSize(50,20); //��ȭ�� ũ�� 
		label2.setLocation(50, 80); //��ȭ�� ��ġ
		this.add(label2); //���̱�
		
		txtPhone=new TextField(); //��ȭ �ۻ��� ����
		txtPhone.setSize(100, 30); //��ȭ �ۻ��� ũ��
		txtPhone.setLocation(130, 80); //��ȭ �ۻ��� ��ġ
		this.add(txtPhone); //���̱� 
		
		label22.setSize(50,20); //�ּҶ� ũ�� 
		label22.setLocation(50, 110); //�ּҶ� ��ġ
		this.add(label22); //���̱�
		
		txtJuso=new TextField(); //�ּ� �ۻ��� ����
		txtJuso.setSize(100, 30); //�ּ� �ۻ��� ũ��
		txtJuso.setLocation(130, 110); //�ּұۻ��� ��ġ
		this.add(txtJuso); //���̱� 
		
		label3.setSize(80,30); 
		label3.setLocation(20, 130);
		this.add(label3); 
		
		chk1.setSize(60,30); 
		chk1.setLocation(20, 160);
		this.add(chk1); 
		
		chk2.setSize(60,30); 
		chk2.setLocation(80, 160);
		this.add(chk2); 
		
		chk3.setSize(60,30); 
		chk3.setLocation(140, 160);
		this.add(chk3); 
		
		chk4.setSize(90,30); 
		chk4.setLocation(200, 160);
		this.add(chk4); 
		
		label4.setSize(50,30); 
		label4.setLocation(20, 200);
		this.add(label4); 
		
		chkMan.setSize(40,30); 
		chkMan.setLocation(20, 230);
		this.add(chkMan); 
		
		chkWoman.setSize(40,30); 
		chkWoman.setLocation(50, 230);
		this.add(chkWoman); 
		
		label5.setSize(70,30); 
		label5.setLocation(50, 270);
		this.add(label5); 
		
		textArea = new TextArea(5,50);
		textArea.setSize(200, 80);
		textArea.setLocation(50, 300);
		this.add(textArea);
		
		btnJoin.setSize(40, 30);
		btnJoin.setLocation(90, 400);
		this.add(btnJoin);
		btnJoin.addActionListener(this);
		
		btnCancel.setSize(40, 30);
		btnCancel.setLocation(150, 400);
		this.add(btnCancel);
		btnCancel.addActionListener(this);
		
		this.setTitle("ȸ������");
		this.setSize(300, 500);
		this.setVisible(true);
		
		//�ݱ�
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});	
		
	}//������ end

	//txtName, txtPhone, txtJuso;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnJoin) {
			
			String info1="\n�Է³����� ������ �����ϴ�. ";
            info1+= "\n�̸� :"+txtName.getText();
            info1+= "\n��ȭ :"+txtPhone.getText();
            info1+= "\n�ּ� :"+txtJuso.getText();
            info1+= "\n�λ縻 :"+textArea.getText();
            
            JOptionPane.showMessageDialog(null,txtName.getText()+"��  ȯ���մϴ�."+info1);
			/*if (chk1.getState()==true) 
				JOptionPane.showMessageDialog(null,"��� : "+chk1.getLabel());
			if (chk2.getState()==true) 
				JOptionPane.showMessageDialog(null,"��� : "+chk2.getLabel());
			if (chk3.getState()==true) 
				JOptionPane.showMessageDialog(null,"��� : "+chk3.getLabel());
			if (chk4.getState()==true) 
				JOptionPane.showMessageDialog(null,"��� : "+chk4.getLabel());
			if (chkMan.getState()==true) 
				JOptionPane.showMessageDialog(null,"���� : "+chkMan.getLabel());
			if (chkWoman.getState()==true) 
				JOptionPane.showMessageDialog(null,"���� : "+chkWoman.getLabel());*/
		}
		else if(e.getSource()==btnCancel) {
			JOptionPane.showMessageDialog(null, "������ �湮���ּ���.");
		}
	}//�̺�Ʈ end
}//class end

public class Member1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kaja1();
	}

}
