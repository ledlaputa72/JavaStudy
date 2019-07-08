package java_GUI04;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class AClock extends Frame implements ActionListener{
	//GUI
	private Button b1=new Button("시작");
	
	static int r1,cX,cY,sooX,sooY;
	static int secX,secY, minX, minY, hourX, hourY;
	static int si, boon, cho; //시간 

	//생성자
	public AClock() {
		this.setLayout(null);
		//버튼 레이아웃
		b1.setSize(100, 50);
		b1.setForeground(new Color(0,0,255));
		b1.setBackground(new Color(255,180,100));
		b1.setFont(new Font("돋음",Font.BOLD,20));
		b1.setLocation(50, 50);
		this.add(b1);
		b1.addActionListener(this);
		
		//디스플레이 
		this.setBackground(new Color(255,255,0));
		this.setTitle("자바 시계");
		this.setSize(1100,1000);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}//생성자 종료
	
	//그림 그리기 
	public void paint(Graphics g) {
		//시간 구하기 
		Date d1=new Date();
		si=d1.getHours();
		boon=d1.getMinutes();
		cho=d1.getSeconds();
		
		//시계 타이틀 
		g.setFont(new Font("arial", Font.BOLD,60));
		g.setColor(Color.GRAY);
		g.drawString("JAVA CLOCK", 350, 200);
		g.setColor(new Color(0,0,0));
		g.drawString("JAVA CLOCK", 348, 198); 
		//시계 원 그리기
		Graphics2D g2d0=(Graphics2D)g;
		g2d0.setStroke(new BasicStroke(5)); //굵기2 for 초침
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(300, 300, 500, 500); //x,y,w,h
		g.setColor(Color.WHITE);
		g.fillOval(300, 300, 500, 500); //x,y,w,h
		
		r1=200; //시계원의 중심으로부터의 길이
		cX=300+500/2; //중심 X(실제좌표)
		cY=300+500/2; //중심 Y
		
		g.setFont(new Font("굴림", Font.BOLD,42));
		g.setColor(Color.BLUE);
		
		//둘레 숫자 표시 12/360 = 30도씩 이동 
		for (int i = 1; i <=12; i++) {
			//12숫자 출력을 200보다 작게
			sooX=cX+(int)(180*Math.sin(i*30*Math.PI/180)); //x축값
			sooY=cY-(int)(180*Math.cos(i*30*Math.PI/180)); //y축값 (코사인의 값은 -값이 나온다)
			//radian(중심각의 크기) = (degree * Math.PI) / 180; (Math.PI/180 = 1도의 값)
			//i=1일때 (1*30*Math.PI/180))=30도의 값
			//180*Math.sin 에서 180은 원의 크기인 200보다 작은 값이면 된다. 
			g.drawString(""+i, sooX-10, sooY+10);
		}//for end, x길이 = cos(30/180)*반지름 / Y길이 = sin(30/180)*반지름 
		
		//시계 초 침 선그리기 /////////////////////////////
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(new BasicStroke(2)); //굵기2 for 초침
		//초침은 60/360 = 6도씩 이동
		secX=cX+(int)(180*Math.sin(cho*6*Math.PI/180)); //cho=d1.getSeconds(); 
		secY=cY-(int)(180*Math.cos(cho*6*Math.PI/180)); //180*Math에서 180은 길이(숫자까지)
		g.setColor(Color.BLUE);
		g.drawLine(cX, cY, secX, secY); //원중심(cX,cY)부터 (secX,secY)
		
		//시계 분 침 선그리기 ////////////////////////////
		Graphics2D g2d2=(Graphics2D)g;
		g2d2.setStroke(new BasicStroke(5)); //굵기5 for 분침
		//분침도 60/360 = 6도씩 이동 
		minX=cX+(int)(160*Math.sin((boon*6+cho/10)*Math.PI/180)); 
		minY=cY-(int)(160*Math.cos((boon*6+cho/10)*Math.PI/180)); 
		g.setColor(Color.DARK_GRAY);
		g.drawLine(cX, cY, minX, minY); //원중심(cX,cY)부터 (minX,minY)
		
		//시계 시 침 선그리기 ////////////////////////////
		Graphics2D g2d3=(Graphics2D)g;
		g2d3.setStroke(new BasicStroke(10)); //굵기10 for 분침
		//시침은 12/360 = 30도씩 이동  
		hourX=cX+(int)(110*Math.sin((si*30+boon/2)*Math.PI/180)); 
		hourY=cY-(int)(110*Math.cos((si*30+boon/2)*Math.PI/180));
		g.setColor(Color.RED);
		g.drawLine(cX, cY, hourX, hourY); //원중심(cX,cY)부터 (hourX,hourY)
		
	}//그림 그리기 end

	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1 ) {
			b1.setEnabled(false);
			Timer t1=new Timer();
			t1.scheduleAtFixedRate(new TimerTask(){
				public void run() {
					repaint();
				} 
			},1000,1000); //1초후 1초 간격으로  
		}
	}//이벤트 종료 
	
}//EClock end 


public class AanalogClock_GUI {

	public static void main(String[] args) {
		
		AClock ec1=new AClock();

	}

}
