package java_GUI03;

import java.awt.*;
import java.awt.event.*;

public class My_calculator extends Frame implements ActionListener {
	
	static int num1=0;
	static int num2=0;
	static int result=0;
	static double resultD=0.0;
	static String imsi;
	static int plag=0; //0:초기, 1:+, 2:-, 3:*, 4:/
	
	//컴퍼넌트//////////////////////////////////////////
	//프레임, 레이아웃, 패널
	private Frame f1=new Frame(); 
	private GridLayout g1=new GridLayout(5,1); //5행 (전체 구성) for Frame
	private GridLayout g2=new GridLayout(1,4); //4열 (버튼 구성) for Panel
	private GridLayout g3=new GridLayout(1,1); //1행 (계산디스플레이) for Panel
	
	private Panel p1=new Panel(); //1행
	private Panel p2=new Panel(); //2행
	private Panel p3=new Panel(); //3행
	private Panel p4=new Panel(); //4행
	private Panel p5=new Panel(); //5행
	
	//라벨, 버튼
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
	
	//생성자 ///////////////////////////////////////////
	public My_calculator() {
		//메인 프레임
		f1.setLayout(g1); //5행1열
		f1.setSize(300, 500); 
		f1.setVisible(true);
		f1.add(p1);  //1행
		f1.add(p2);  //2행
		f1.add(p3);  //3행
		f1.add(p4);  //4행
		f1.add(p5);  //5행
		
		//패널 컬러 (패널 구분 디자인을 위해 사용)
		p1.setBackground(Color.BLUE);
		/*p2.setBackground(Color.RED);
		p3.setBackground(Color.YELLOW);
		p4.setBackground(Color.GREEN);
		p5.setBackground(Color.GRAY);*/
		
		//1행 패널 (계산창)
		p1.setLayout(g3);
		p1.add(lblWindow);
		lblWindow.setSize(500, 200);
		lblWindow.setFont(new Font("굴림",Font.BOLD,40));
		lblWindow.setBackground(Color.CYAN);
				
		//2행 
		p2.setLayout(g3);
		p2.add(btn_1);
		p2.add(btn_2);
		p2.add(btn_3);
		p2.add(btn_add);
		
		//3행
		p3.setLayout(g3);
		p3.add(btn_4);
		p3.add(btn_5);
		p3.add(btn_6);
		p3.add(btn_sub);
		
		//4행
		p4.setLayout(g2);
		p4.add(btn_7);
		p4.add(btn_8);
		p4.add(btn_9);
		p4.add(btn_mlt);
		
		//5행
		p5.setLayout(g2);
		p5.add(btn_0);
		p5.add(btn_result);
		p5.add(btn_clear);
		p5.add(btn_div);
		
		//버튼 액션 add
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
		
		//닫기
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}
	//이벤트 핸들러//////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//숫자 키 
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
		
		//연산 버튼
		else if (e.getSource()==btn_add) {
				imsi=lblWindow.getText(); //숫자창의 숫자를 String imsi로 할당
				num1=Integer.parseInt(imsi); //imsi의 숫자를 num1(첫숫자)로 
				plag=1; //더하기 플래그 1 
				lblWindow.setText(""); //숫자창 초기화
		}else if (e.getSource()==btn_sub) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=2; //빼기 플래그 2
				lblWindow.setText("");
		}else if (e.getSource()==btn_mlt) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=3; //곱하기 플래그 3
				lblWindow.setText("");
		}else if (e.getSource()==btn_div) {
				imsi=lblWindow.getText();
				num1=Integer.parseInt(imsi);
				plag=4; //나누기 플래그 4
				lblWindow.setText("");
		}
		
		//결과 구하기 
		else if (e.getSource()==btn_result) {
			//연산 +-*/를 하고 난 뒤에만 결과를 낸다. 
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
			else { //연산이 없는 경우 plag==0
			}
		}
		//화면 클리어
		else if (e.getSource()==btn_clear) {
			lblWindow.setText("");
			num1=0;
			num2=0;
			result=0;
		}
	}
	
	//메인/////////////////////////////////////////////
	public static void main(String[] args) {
		My_calculator mc=new My_calculator();
	}
}
