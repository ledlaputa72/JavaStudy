package java_GUI01;

import java.awt.*;
import java.awt.event.*;

class BMI extends Frame implements ActionListener {
	//컴퍼넌트 작성//////////////////////////////////////////
	private Label bmi_lb00=new Label("*BMI 계산기*");
	private Label bmi_lb01=new Label("당신의 몸무게는 : ");
	private Label bmi_lb02=new Label("당신의 키는 : ");
	private TextField bmi_tf01=new TextField();
	private TextField bmi_tf02=new TextField();
	private TextField bmi_tf03=new TextField();
	private Button bmi_bt01=new Button("BMI 계산");
	private Frame bmi_fr01=new Frame();
	
	//생성자//////////////////////////////////////////////
	public BMI(){
		//타이틀 라벨------------------------------------------
		bmi_lb00.setBounds(0, 50, 500, 50);
		bmi_lb00.setAlignment(Label.CENTER);
		bmi_lb00.setFont(new Font("굴림",Font.BOLD, 28));
		
		//몸무게 입력 라벨과 필드 ----------------------------------
		bmi_lb01.setBounds(100, 120, 100, 30);
		bmi_lb01.setBackground(new Color(255,255,0));
		bmi_tf01.setBounds(200, 120, 200, 30);
		bmi_tf01.setBackground(new Color(0,255,255));
		bmi_tf01.setFont(new Font("굴림",Font.BOLD, 14));
		
		//키 입력 라벨과 필드-------------------------------------
		bmi_lb02.setBounds(100, 150, 100, 30);
		bmi_lb02.setBackground(new Color(255,255,0));
		bmi_tf02.setBounds(200, 150, 200, 30);
		bmi_tf02.setBackground(new Color(0,255,255));
		bmi_tf02.setFont(new Font("굴림",Font.BOLD, 14));
		
		//BMI 계산 버튼---------------------------------------
		bmi_bt01.setBounds(200,300, 100,50);
		bmi_bt01.setBackground(new Color(255,100,255));
		bmi_bt01.setFont(new Font("굴림",Font.BOLD, 20));
		bmi_bt01.addActionListener(this);
		
		//BMI 결과 필드 ---------------------------------------
		bmi_tf03.setBounds(100, 400, 300, 50);
		bmi_tf03.setBackground(new Color(255,255,0));
		bmi_tf03.setFont(new Font("굴림",Font.BOLD, 14));
		
		//메인 프레임------------------------------------------
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
		
		//닫기 버튼 -------------------------------------------
		bmi_fr01.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
		
	}//생성자 종료
	
	//이벤트 핸들러////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//BMI 구하기1
		Double mom=new Double(bmi_tf01.getText());
		Double ki=new Double(bmi_tf02.getText());
		double bmi=mom/(ki/100*ki/100);
		int bmiR=(int)bmi;
		/*
		//BMI 구하기 2 
		int ki=Integer.parseInt(bmi_tf01.getText());
		int mom=Integer.parseInt(bmi_tf02.getText());
		
		double mki=ki/100.0;
		double bmi=mom/Math.pow(mki,2);
		*/
		//BMI 구하기 - 공통
		String result;
	   if ( 30<= bmiR) {
             result = "비만";
       }
       else if (25 <= bmi && bmi < 30)
       {
        result = "과체중";
       }
       else if(20 <= bmi && bmi < 25 )
       {
        result = "정상";
       }
       else
       {
        result = "저체중 ";
       }
		//출력
		if(e.getSource()==bmi_bt01) {
			bmi_tf03.setText("당신의 BMI수치는"+Double.toString(bmiR)+" 이며, "+result+"입니다.");
			//bmi_tf03.setText("당신의 BMI수치는"+Math.round(bmi)+" 이며, "+result+"입니다.");
			System.out.println(bmi_tf03.getText());
		}
		
	}
	
}//클래스 종료 

public class BMI_GUI {

	public static void main(String[] args) {
		BMI bmi01=new BMI();
	}

}
