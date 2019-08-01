package step03_TCP_SC3_cSend_sRcv_sSend_cRcv2;

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

	static BufferedImage bufferImage1=null; //�߰�)
	static BufferedInputStream bis1=null;
	
	public BufferedInputStream getBis1() {
		return bis1;
	}

	public void setBis1(BufferedInputStream bis1) {
		this.bis1 = bis1;
	}

	public ServerRcv(Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.sf1 = sf1;
		
		while (true) {
			bis1 = new BufferedInputStream(s1.getInputStream());
			
			bufferImage1= ImageIO.read(bis1); //�߰�) ���� �����͸� ���ۿ� ����
			System.out.println("SR1) ���� �̹��� ����: " + bufferImage1); //�߰�) ���۳��� Ȯ��
			
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);//���� �׽�Ʈ â�� �׸� �׸��� 
			System.out.println("SR2) ���� �̹��� ��Ʈ�� : " + bis1); //�߰�) ���� ��Ʈ�� ������ Ȯ�� 
			
			//���ۿ� ����############################################��� �߰� 
			ServerSend.bufferImage2=bufferImage1;
			System.out.println("SR3) ����1 :  " + bufferImage1);
			System.out.println("SR4) ����2 :  " + ServerSend.bufferImage2 );
			
		}
	}
}//ServerRcv end

//���� --> Ŭ�� ������ ###############################################
class ServerSend extends Thread {
	Socket s1;
	ServerRcv rcv; 
	
	static BufferedImage bufferImage2;
	static BufferedOutputStream bos1;

	public ServerSend(Socket s1) throws IOException {
		this.s1 = s1;
		
		
		while (true) {
			bos1 = new BufferedOutputStream(s1.getOutputStream());
			System.out.println("SS1) ����2 :  " + ServerSend.bufferImage2 );
			
			ImageIO.write(bufferImage2, "bmp", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("SS2) ������  �̹��� ���� : " + bufferImage2);
			bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
			System.out.println("SS3) ������ �̹��� : " + bos1);
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
