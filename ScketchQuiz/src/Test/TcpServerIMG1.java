package Test;

import java.net.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.lang.*;

import java.text.SimpleDateFormat;

class ImageSendThread1 extends Thread {
	
	Socket s1;
	static BufferedImage bi1;
	BufferedOutputStream bos1; 
	
	//����Ʈ ������
	public ImageSendThread1(Socket s1) throws IOException {
		this.s1 = s1;
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			bi1 = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB ); //������ �о�ͼ� ���ۿ�
			ImageIO.write(bi1, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			JFrameClass1.jl1 = new JLabel(new ImageIcon(bi1) ); //ȭ�鿡 �׸���. 
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}

class JFrameClass1 extends JFrame implements MouseMotionListener {
	JFrame frame = new JFrame();
	static JLabel jl1;
	static Brush b;
	
	public JFrameClass1() {
		//�⺻ ������
		frame.setSize(240,440);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible( true );
		
	    // �귯����� Ŭ������ �����Ѵ�. �Ʒ��ʿ� ������.///////////////////////
	    b = new Brush();
	    b.setBounds(20,20,160,160); //ũ�Ⱑ jl1 �� ���ƾ� �Ѵ�.
	    frame.add(b);
	    
        jl1.setBounds(20,20,160,160);
        frame.add(jl1);
        jl1.addMouseMotionListener(this);

	}
	
// ���콺 ��� �̺�Ʈ/////////////////////////////////////
    
    public void mouseDragged(MouseEvent e) {
        b.xx=e.getX();
        b.yy=e.getY();
        b.repaint();                            
        b.printAll(ImageSendThread1.bi1.getGraphics() ); //�귯���� BufferedImage �� �׸���.                
    }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
}

public class TcpServerIMG1 {
	public static void main(String args[]) throws IOException, NullPointerException{
		
        //////////////////////////////////////////////////////////
        
		ServerSocket ss1 = new ServerSocket(9999);
		System.out.println("���� �غ�Ǿ� ����....");
		JFrameClass1 jfc=new JFrameClass1();
		
		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");
			
			//������ ����
			ImageSendThread1 tsendSer1 = new ImageSendThread1(s1);//�ʱ�ġ �ְŴ�, ThreadSend Class  ��ü ���� 
			tsendSer1.start(); //Thread ����
		 
			System.out.println("jpg �����ߴ�~~~");
		}		
	}
}

class Brush2 extends JLabel{
    
    public int xx, yy;
    public Color col=new Color(255,0,0);
    
    public void paint(Graphics g) {     
    
        g.setColor( col );
        g.fillOval( xx-10, yy-10, 20, 20);
        
    }   
}
