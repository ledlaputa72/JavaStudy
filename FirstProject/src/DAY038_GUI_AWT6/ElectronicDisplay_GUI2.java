package DAY038_GUI_AWT6;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class EDislpay extends Frame implements ActionListener{
	//전역변수
	static int sw=0;
	static String s1="             I LOVE YOU";
	Timer t1=new Timer(); //Back Ground Thread 
	
	//GUI
	private Button b1=new Button("시작");
	private Button b2=new Button("끝");
	private TextField tf1=new TextField();
	
	//생성자
	public EDislpay() {
		this.setLayout(null);
		//버튼 레이아웃
		b1.setSize(200, 70);
		b1.setForeground(new Color(0,0,255));
		b1.setBackground(new Color(255,180,100));
		b1.setFont(new Font("돋음",Font.BOLD,20));
		b1.setLocation(130, 200);
		this.add(b1);
		b1.addActionListener(this);
		
		b2.setSize(200, 70);
		b2.setForeground(new Color(0,0,255));
		b2.setBackground(new Color(255,180,100));
		b2.setFont(new Font("돋음",Font.BOLD,20));
		b2.setLocation(130, 300);
		this.add(b2);
		b2.addActionListener(this);
		
		tf1.setSize(400, 50);
		tf1.setForeground(new Color(0,0,255));
		tf1.setBackground(new Color(255,255,0));
		tf1.setFont(new Font("돋음",Font.BOLD,35));
		tf1.setLocation(30, 70);
		this.add(tf1);
		
		this.setBackground(new Color(0,200,200));
		this.setTitle("자바는 펀펀펀");
		this.setSize(460,400);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}//생성자 종료
	
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1 && sw==0) { //시작 버튼 눌러 졌을때
			b1.setEnabled(false);//아이콘을 반투명으로(비활성화)
			//t1.schedule도 좋다
			//t1.scheduleAtFixedRate(할일, 0, 250);
			t1.scheduleAtFixedRate(new TimerTask(){ //일정시간
				public void run() { //t1은 전역  //TimerTask처리할 일 // 쓰레드가 나오면 반드시 run()이 나옴 
				try {s1=s1.substring(1,s1.length())+s1.substring(0,1);
				//1번째부터 s1번까지 뽑아냄 + 0번째부터 1까지 뽑아냄 ==>를 s1에 다시 저장 
					tf1.setText(s1); //화면 출력
				}catch(Exception e) {
					e.printStackTrace();}
				} //run end //new TimerTask(처리할 내용, delay, period)
			},0,250); //0초 delay 후 가동, 250ms단위 일정한 간격으로 반복 
			sw=1;
		}
		
		else if(e.getSource()==b2 && sw==1) {
			b1.setEnabled(true);
			t1.cancel();
			sw=0;
		}
	}//이벤트 종료 
	
}//EDisplay end 


public class ElectronicDisplay_GUI2 {

	public static void main(String[] args) {
		
		EDislpay ed1=new EDislpay();

	}

}
