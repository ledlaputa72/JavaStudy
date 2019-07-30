package step01_ScreenCaptureStreamingTest2;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ServerFrame extends JFrame {
	JFrame frame;
	final static int w = 400, h = 400; 
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
	//â�� �����
	frame = new JFrame("server");
	frame.setBounds(x, y, w, h); //��� ũ�� �޾ƿ��� 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
	
}

class ThreadSend extends Thread{
	
	Socket s1;
	BufferedImage bi1;
	Robot r;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket s1) throws IOException, AWTException {
		this.s1 = s1;
		r = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			bi1 = r.createScreenCapture(new Rectangle(0, 0, 400, 400));//��ũ������ �� image�� ������
			ImageIO.write(bi1, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}

class ThreadRcv extends Thread{
	Socket s1;
	BufferedInputStream bin;
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	ServerFrame sf1=new ServerFrame();
	
	public ThreadRcv(Socket s1) throws IOException{
		//������ �Է½�Ʈ���� ���۽�Ʈ������
		bin = new BufferedInputStream(s1.getInputStream());
		//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�
		while(true) {
		sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, 400, 700, sf1.frame);
		}
	}
	
}

public class Server {

	public static void main(String[] args) throws IOException {
		ServerFrame sf=new ServerFrame();
		sf.setVisible(true);
		
		ServerSocket ss1 = null;
		Socket s1 = null;
		ss1 = new ServerSocket(8888); //��Ʈ ���� 
		
		while(true) {
			//Ŭ���̾�Ʈ�� ������
			s1 = ss1.accept(); // Listen 
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + s1);
			
			ThreadRcv tr1=new ThreadRcv(s1);
			tr1.start();
		} 
		


	}
}