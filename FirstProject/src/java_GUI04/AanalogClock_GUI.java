package java_GUI04;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class AClock extends Frame implements ActionListener{
	//GUI
	private Button b1=new Button("����");
	
	static int r1,cX,cY,sooX,sooY;
	static int secX,secY, minX, minY, hourX, hourY;
	static int si, boon, cho; //�ð� 

	//������
	public AClock() {
		this.setLayout(null);
		//��ư ���̾ƿ�
		b1.setSize(100, 50);
		b1.setForeground(new Color(0,0,255));
		b1.setBackground(new Color(255,180,100));
		b1.setFont(new Font("����",Font.BOLD,20));
		b1.setLocation(50, 50);
		this.add(b1);
		b1.addActionListener(this);
		
		//���÷��� 
		this.setBackground(new Color(255,255,0));
		this.setTitle("�ڹ� �ð�");
		this.setSize(1100,1000);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}//������ ����
	
	//�׸� �׸��� 
	public void paint(Graphics g) {
		//�ð� ���ϱ� 
		Date d1=new Date();
		si=d1.getHours();
		boon=d1.getMinutes();
		cho=d1.getSeconds();
		
		//�ð� Ÿ��Ʋ 
		g.setFont(new Font("arial", Font.BOLD,60));
		g.setColor(Color.GRAY);
		g.drawString("JAVA CLOCK", 350, 200);
		g.setColor(new Color(0,0,0));
		g.drawString("JAVA CLOCK", 348, 198); 
		//�ð� �� �׸���
		Graphics2D g2d0=(Graphics2D)g;
		g2d0.setStroke(new BasicStroke(5)); //����2 for ��ħ
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(300, 300, 500, 500); //x,y,w,h
		g.setColor(Color.WHITE);
		g.fillOval(300, 300, 500, 500); //x,y,w,h
		
		r1=200; //�ð���� �߽����κ����� ����
		cX=300+500/2; //�߽� X(������ǥ)
		cY=300+500/2; //�߽� Y
		
		g.setFont(new Font("����", Font.BOLD,42));
		g.setColor(Color.BLUE);
		
		//�ѷ� ���� ǥ�� 12/360 = 30���� �̵� 
		for (int i = 1; i <=12; i++) {
			//12���� ����� 200���� �۰�
			sooX=cX+(int)(180*Math.sin(i*30*Math.PI/180)); //x�ప
			sooY=cY-(int)(180*Math.cos(i*30*Math.PI/180)); //y�ప (�ڻ����� ���� -���� ���´�)
			//radian(�߽ɰ��� ũ��) = (degree * Math.PI) / 180; (Math.PI/180 = 1���� ��)
			//i=1�϶� (1*30*Math.PI/180))=30���� ��
			//180*Math.sin ���� 180�� ���� ũ���� 200���� ���� ���̸� �ȴ�. 
			g.drawString(""+i, sooX-10, sooY+10);
		}//for end, x���� = cos(30/180)*������ / Y���� = sin(30/180)*������ 
		
		//�ð� �� ħ ���׸��� /////////////////////////////
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(new BasicStroke(2)); //����2 for ��ħ
		//��ħ�� 60/360 = 6���� �̵�
		secX=cX+(int)(180*Math.sin(cho*6*Math.PI/180)); //cho=d1.getSeconds(); 
		secY=cY-(int)(180*Math.cos(cho*6*Math.PI/180)); //180*Math���� 180�� ����(���ڱ���)
		g.setColor(Color.BLUE);
		g.drawLine(cX, cY, secX, secY); //���߽�(cX,cY)���� (secX,secY)
		
		//�ð� �� ħ ���׸��� ////////////////////////////
		Graphics2D g2d2=(Graphics2D)g;
		g2d2.setStroke(new BasicStroke(5)); //����5 for ��ħ
		//��ħ�� 60/360 = 6���� �̵� 
		minX=cX+(int)(160*Math.sin((boon*6+cho/10)*Math.PI/180)); 
		minY=cY-(int)(160*Math.cos((boon*6+cho/10)*Math.PI/180)); 
		g.setColor(Color.DARK_GRAY);
		g.drawLine(cX, cY, minX, minY); //���߽�(cX,cY)���� (minX,minY)
		
		//�ð� �� ħ ���׸��� ////////////////////////////
		Graphics2D g2d3=(Graphics2D)g;
		g2d3.setStroke(new BasicStroke(10)); //����10 for ��ħ
		//��ħ�� 12/360 = 30���� �̵�  
		hourX=cX+(int)(110*Math.sin((si*30+boon/2)*Math.PI/180)); 
		hourY=cY-(int)(110*Math.cos((si*30+boon/2)*Math.PI/180));
		g.setColor(Color.RED);
		g.drawLine(cX, cY, hourX, hourY); //���߽�(cX,cY)���� (hourX,hourY)
		
	}//�׸� �׸��� end

	//�̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1 ) {
			b1.setEnabled(false);
			Timer t1=new Timer();
			t1.scheduleAtFixedRate(new TimerTask(){
				public void run() {
					repaint();
				} 
			},1000,1000); //1���� 1�� ��������  
		}
	}//�̺�Ʈ ���� 
	
}//EClock end 


public class AanalogClock_GUI {

	public static void main(String[] args) {
		
		AClock ec1=new AClock();

	}

}
