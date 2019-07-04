package java_GUI03;

import java.awt.*;
import java.awt.event.*;

public class My_calculator extends Frame implements ActionListener {
	
	static int num1=0;
	static int num2=0;
	static int result=0;
	static double resultD=0.0;
	static String imsi;
	static int plag=0; //0:�ʱ�, 1:+, 2:-, 3:*, 4:/
	
	//���۳�Ʈ//////////////////////////////////////////
	//������, ���̾ƿ�, �г�
	private Frame f1=new Frame(); 
	private GridLayout g1=new GridLayout(5,1); //5�� (��ü ����) for Frame
	private GridLayout g2=new GridLayout(1,4); //4�� (��ư ����) for Panel
	private GridLayout g3=new GridLayout(1,1); //1�� (�����÷���) for Panel
	
	private Panel p1=new Panel(); //1��
	private Panel p2=new Panel(); //2��
	private Panel p3=new Panel(); //3��
	private Panel p4=new Panel(); //4��
	private Panel p5=new Panel(); //5��
	
	//��, ��ư
	private Label lblWindow=new Label("", Label.RIGHT);
	
	private Button btn_1=new Button("1");
	private Button btn_2=new Button("2");
	private Button btn_3=new Button("3");
	private Button btn_4=new Button("4");
	private Button btn_5=new Button("5");
	private Button btn_6=new Button("6");
	private Button btn_7=new Button("7");
	private Button btn_8=new Button("8");
	private Button btn_9=new Button("9");
	private Button btn_0=new Button("0");
	
	private Button btn_add=new Button("+");
	private Button btn_sub=new Button("-");
	private Button btn_mlt=new Button("x");
	private Button btn_div=new Button("/");
	
	private Button btn_result=new Button("=");
	private Button btn_clear=new Button("CE");
	
	//������ ///////////////////////////////////////////
	public My_calculator() {
		//���� ������
		f1.setLayout(g1); //5��1��
		f1.setSize(300, 500); 
		f1.setVisible(true);
		f1.add(p1);  //1��
		f1.add(p2);  //2��
		f1.add(p3);  //3��
		f1.add(p4);  //4��
		f1.add(p5);  //5��
		
		//�г� �÷� (�г� ���� �������� ���� ���)
		p1.setBackground(Color.BLUE);
		/*p2.setBackground(Color.RED);
		p3.setBackground(Color.YELLOW);
		p4.setBackground(Color.GREEN);
		p5.setBackground(Color.GRAY);*/
		
		//1�� �г� (���â)
		p1.setLayout(g3);
		p1.add(lblWindow);
		lblWindow.setSize(500, 200);
		lblWindow.setFont(new Font("����",Font.BOLD,40));
		lblWindow.setBackground(Color.CYAN);
				
		//2�� 
		p2.setLayout(g3);
		p2.add(btn_1);
		p2.add(btn_2);
		p2.add(btn_3);
		p2.add(btn_add);
		
		//3��
		p3.setLayout(g3);
		p3.add(btn_4);
		p3.add(btn_5);
		p3.add(btn_6);
		p3.add(btn_sub);
		
		//4��
		p4.setLayout(g2);
		p4.add(btn_7);
		p4.add(btn_8);
		p4.add(btn_9);
		p4.add(btn_mlt);
		
		//5��
		p5.setLayout(g2);
		p5.add(btn_0);
		p5.add(btn_result);
		p5.add(btn_clear);
		p5.add(btn_div);
		
		//��ư �׼� add
		btn_1.addActionListener(this);
		btn_2.addActionListener(this);
		btn_3.addActionListener(this);
		btn_4.addActionListener(this);
		btn_5.addActionListener(this);
		btn_6.addActionListener(this);
		btn_7.addActionListener(this);
		btn_8.addActionListener(this);
		btn_9.addActionListener(this);
		btn_0.addActionListener(this);
		btn_add.addActionListener(this);
		btn_sub.addActionListener(this);
		btn_mlt.addActionListener(this);
		btn_div.addActionListener(this);
		btn_result.addActionListener(this);
		btn_clear.addActionListener(this);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}
	//�̺�Ʈ �ڵ鷯//////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//���� Ű 
		if (e.getSource()==btn_1) {
			lblWindow.setText(lblWindow.getText()+"1");
		}else if (e.getSource()==btn_2) {
			lblWindow.setText(lblWindow.getText()+"2");
		}else if (e.getSource()==btn_3) {
			lblWindow.setText(lblWindow.getText()+"3");
		}else if (e.getSource()==btn_4) {
			lblWindow.setText(lblWindow.getText()+"4");
		}else if (e.getSource()==btn_5) {
			lblWindow.setText(lblWindow.getText()+"5");
		}else if (e.getSource()==btn_6) {
			lblWindow.setText(lblWindow.getText()+"6");
		}else if (e.getSource()==btn_7) {
			lblWindow.setText(lblWindow.getText()+"7");
		}else if (e.getSource()==btn_8) {
			lblWindow.setText(lblWindow.getText()+"8");
		}else if (e.getSource()==btn_9) {
			lblWindow.setText(lblWindow.getText()+"9");
		}else if (e.getSource()==btn_0) {
			lblWindow.setText(lblWindow.getText()+"0");
		}
		
		//���� ��ư
		else if (e.getSource()==btn_add) {
				imsi=lblWindow.getText(); //����â�� ���ڸ� String imsi�� �Ҵ�
				num1=Integer.parseInt(imsi); //imsi�� ���ڸ� num1(ù����)�� 
				plag=1; //���ϱ� �÷��� 1 
				lblWindow.setText(""); //����â �ʱ�ȭ
		}else if (e.getSource()==btn_sub) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=2; //���� �÷��� 2
				lblWindow.setText("");
		}else if (e.getSource()==btn_mlt) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=3; //���ϱ� �÷��� 3
				lblWindow.setText("");
		}else if (e.getSource()==btn_div) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=4; //������ �÷��� 4
				lblWindow.setText("");
		}
		
		//��� ���ϱ� 
		else if (e.getSource()==btn_result) {
			//���� +-*/�� �ϰ� �� �ڿ��� ����� ����. 
			if(plag==1) {
				imsi=lblWindow.getText();
				num2=Integer.parseInt(imsi);
				result=num1+num2;
				imsi=Integer.toString(result);
				lblWindow.setText(imsi);
			}else if(plag==2) {
				imsi=lblWindow.getText();
				num2=Integer.parseInt(imsi);
				result=num1-num2;
				imsi=Integer.toString(result);
				lblWindow.setText(imsi);
			}else if(plag==3) {
				imsi=lblWindow.getText();
				num2=Integer.parseInt(imsi);
				result=num1*num2;
				imsi=Integer.toString(result);
				lblWindow.setText(imsi);
			}else if(plag==4) {	
				imsi=lblWindow.getText();
				num2=Integer.parseInt(imsi);
				result=num1/num2;
				imsi=Integer.toString(result);
				lblWindow.setText(imsi);
			}
			else { //������ ���� ��� plag==0
			}
		}
		//ȭ�� Ŭ����
		else if (e.getSource()==btn_clear) {
			lblWindow.setText("");
			num1=0;
			num2=0;
			result=0;
		}
	}
	
	//����/////////////////////////////////////////////
	public static void main(String[] args) {
		My_calculator mc=new My_calculator();
	}
}
