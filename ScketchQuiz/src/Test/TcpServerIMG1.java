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
	
	//디폴트 생성자
	public ImageSendThread1(Socket s1) throws IOException {
		this.s1 = s1;
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			bi1 = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB ); //파일을 읽어와서 버퍼에
			ImageIO.write(bi1, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			JFrameClass1.jl1 = new JLabel(new ImageIcon(bi1) ); //화면에 그린다. 
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
		}
	}
}

class JFrameClass1 extends JFrame implements MouseMotionListener {
	JFrame frame = new JFrame();
	static JLabel jl1;
	static Brush b;
	
	public JFrameClass1() {
		//기본 프레임
		frame.setSize(240,440);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible( true );
		
	    // 브러쉬라는 클래스를 생성한다. 아래쪽에 정의함.///////////////////////
	    b = new Brush();
	    b.setBounds(20,20,160,160); //크기가 jl1 과 같아야 한다.
	    frame.add(b);
	    
        jl1.setBounds(20,20,160,160);
        frame.add(jl1);
        jl1.addMouseMotionListener(this);

	}
	
// 마우스 모션 이벤트/////////////////////////////////////
    
    public void mouseDragged(MouseEvent e) {
        b.xx=e.getX();
        b.yy=e.getY();
        b.repaint();                            
        b.printAll(ImageSendThread1.bi1.getGraphics() ); //브러쉬를 BufferedImage 에 그린다.                
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
		System.out.println("서버 준비되어 있음....");
		JFrameClass1 jfc=new JFrameClass1();
		
		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");
			
			//쓰레드 구동
			ImageSendThread1 tsendSer1 = new ImageSendThread1(s1);//초기치 주거니, ThreadSend Class  객체 생성 
			tsendSer1.start(); //Thread 실행
		 
			System.out.println("jpg 전송했당~~~");
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
