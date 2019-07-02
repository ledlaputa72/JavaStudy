package java_GUI01;

import java.awt.*;
import java.awt.event.*;

class BMI extends Frame implements ActionListener {
	//���۳�Ʈ �ۼ�//////////////////////////////////////////
	private Label bmi_lb00=new Label("*BMI ����*");
	private Label bmi_lb01=new Label("����� �����Դ� : ");
	private Label bmi_lb02=new Label("����� Ű�� : ");
	private TextField bmi_tf01=new TextField();
	private TextField bmi_tf02=new TextField();
	private TextField bmi_tf03=new TextField();
	private Button bmi_bt01=new Button("BMI ���");
	private Frame bmi_fr01=new Frame();
	
	//������//////////////////////////////////////////////
	public BMI(){
		//Ÿ��Ʋ ��------------------------------------------
		bmi_lb00.setBounds(0, 50, 500, 50);
		bmi_lb00.setAlignment(Label.CENTER);
		bmi_lb00.setFont(new Font("����",Font.BOLD, 28));
		
		//������ �Է� �󺧰� �ʵ� ----------------------------------
		bmi_lb01.setBounds(100, 120, 100, 30);
		bmi_lb01.setBackground(new Color(255,255,0));
		bmi_tf01.setBounds(200, 120, 200, 30);
		bmi_tf01.setBackground(new Color(0,255,255));
		bmi_tf01.setFont(new Font("����",Font.BOLD, 14));
		
		//Ű �Է� �󺧰� �ʵ�-------------------------------------
		bmi_lb02.setBounds(100, 150, 100, 30);
		bmi_lb02.setBackground(new Color(255,255,0));
		bmi_tf02.setBounds(200, 150, 200, 30);
		bmi_tf02.setBackground(new Color(0,255,255));
		bmi_tf02.setFont(new Font("����",Font.BOLD, 14));
		
		//BMI ��� ��ư---------------------------------------
		bmi_bt01.setBounds(200,300, 100,50);
		bmi_bt01.setBackground(new Color(255,100,255));
		bmi_bt01.setFont(new Font("����",Font.BOLD, 20));
		bmi_bt01.addActionListener(this);
		
		//BMI ��� �ʵ� ---------------------------------------
		bmi_tf03.setBounds(100, 400, 300, 50);
		bmi_tf03.setBackground(new Color(255,255,0));
		bmi_tf03.setFont(new Font("����",Font.BOLD, 14));
		
		//���� ������------------------------------------------
		bmi_fr01.setLayout(null);
		bmi_fr01.setSize(500, 500);
		bmi_fr01.setBackground(new Color(200,200,255));
		bmi_fr01.add(bmi_lb00);	
		bmi_fr01.add(bmi_lb01);
		bmi_fr01.add(bmi_tf01);
		bmi_fr01.add(bmi_lb02);
		bmi_fr01.add(bmi_tf02);
		bmi_fr01.add(bmi_bt01);
		bmi_fr01.add(bmi_tf03);
		bmi_fr01.setVisible(true);
		
		//�ݱ� ��ư -------------------------------------------
		bmi_fr01.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
		
	}//������ ����
	
	//�̺�Ʈ �ڵ鷯////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//BMI ���ϱ�1
		Double mom=new Double(bmi_tf01.getText());
		Double ki=new Double(bmi_tf02.getText());
		double bmi=mom/(ki/100*ki/100);
		int bmiR=(int)bmi;
		/*
		//BMI ���ϱ� 2 
		int ki=Integer.parseInt(bmi_tf01.getText());
		int mom=Integer.parseInt(bmi_tf02.getText());
		
		double mki=ki/100.0;
		double bmi=mom/Math.pow(mki,2);
		*/
		//BMI ���ϱ� - ����
		String result;
	   if ( 30<= bmiR) {
             result = "��";
       }
       else if (25 <= bmi && bmi < 30)
       {
        result = "��ü��";
       }
       else if(20 <= bmi && bmi < 25 )
       {
        result = "����";
       }
       else
       {
        result = "��ü�� ";
       }
		//���
		if(e.getSource()==bmi_bt01) {
			bmi_tf03.setText("����� BMI��ġ��"+Double.toString(bmiR)+" �̸�, "+result+"�Դϴ�.");
			//bmi_tf03.setText("����� BMI��ġ��"+Math.round(bmi)+" �̸�, "+result+"�Դϴ�.");
			System.out.println(bmi_tf03.getText());
		}
		
	}
	
}//Ŭ���� ���� 

public class BMI_GUI {

	public static void main(String[] args) {
		BMI bmi01=new BMI();
	}

}
