package step03_TCP_SC3_1ThreadSendRcv;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//���� �׽�Ʈ ������ #########################################
class ServerFrame extends JFrame {
	JFrame frame;
	final static int w = 800, h = 400;
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
		// â�� �����
		frame = new JFrame("server");
		frame.setBounds(x, y, w, h); // ��� ũ�� �޾ƿ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}//ServerFrame end

//���� <-- Ŭ�� �ޱ� ###############################################
class ServerRcv extends Thread {
	Socket s1;
	JFrame sf1;

	BufferedInputStream bis1=null;
	
	public BufferedInputStream getBis1() {
		return bis1;
	}

	public void setBis1(BufferedInputStream bis1) {
		this.bis1 = bis1;
	}

	public ServerRcv(Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.sf1 = sf1;
		bis1 = new BufferedInputStream(s1.getInputStream());
		while (true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);
			System.out.println("���� �̹��� : " + bis1);
		}
	}
}//ServerRcv end

//���� --> Ŭ�� ������ ###############################################
class ServerSend extends Thread {
	Socket s1;
	ServerRcv rcv; 
	
	BufferedImage bi1;
	BufferedOutputStream bos1;

	public ServerSend(Socket s1) throws IOException {
		this.s1 = s1;
		
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		while (true) {
			bi1= ImageIO.read(rcv.getBis1());;
			ImageIO.write(bi1, "bmp", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("������ �̹��� : " + bos1);
			bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
			System.out.println("������ �̹��� : " + bos1);
		}
	}
}//ServerSend end

//���� Ŭ���� #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf1 = new ServerFrame();
		sf1.setVisible(true);

		ServerSocket ss1 = new ServerSocket(9999);
		System.out.println("���� ����� ....");
		

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("������ ���� : " + s1.toString());
			//������ /////////////////////////////
			ServerRcv sr1 = new ServerRcv(s1,sf1);
			sr1.start();
			
			ServerSend sd1 = new ServerSend(s1);
			sd1.start();
		}
	}
}
