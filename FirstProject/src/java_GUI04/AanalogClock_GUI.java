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
		//시계 원 그리기 
		g.setColor(new Color(255,255,255));
		g.fillOval(300, 300, 500, 500); //x,y,w,h 
		
		
	}

	public void update(Graphics g) {
		
	}
	
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1 ) {
			b1.setEnabled(false);
			Timer t1=new Timer(); //Back Ground Thread 
			t1.scheduleAtFixedRate(new TimerTask(){
				public void run() { 
					Date d1=new Date(); //Date가 run안으로 들어와야 업데이트가 된다. (밖으로 빼지 말것)
					/*tf1.setText(String.valueOf(d1.getHours()));
					tf2.setText(String.valueOf(d1.getMinutes()));
					tf3.setText(String.valueOf(d1.getSeconds()));*/
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
