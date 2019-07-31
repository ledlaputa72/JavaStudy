package step02_TCP_SC3_BufferImage.copy2;

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

//���� <--> Ŭ�� �ޱ� ������ �ϳ��� ���� ###############################################
class ServerRcvSend extends Thread {
	Socket s1;
	JFrame frame;
	
	BufferedImage bufferImage1=null;
	BufferedInputStream bis1;
	
	BufferedImage bufferImage2=null;
	BufferedOutputStream bos1;
	
	public ServerRcvSend(Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.frame = sf1;
		
		// �޾ƿ��� ///////////////////////////////////////
		bis1 = new BufferedInputStream(s1.getInputStream());
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		
		bufferImage1= ImageIO.read(bis1); //���� �����͸� ���ۿ� ����
		System.out.println("���� �̹��� ����: " + bufferImage1); // ���۳��� Ȯ��
		
		while (true) {
			//�ޱ� ����#######################################
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);
			System.out.println("���� �̹��� ��Ʈ�� : " + bis1);
			//������ 
			System.out.println("���� �̹��� :  " + bis1);
			
			//������ ����######################################
			ImageIO.write(bufferImage1, "bmp", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("������  �̹��� ����: " + bufferImage1);
			bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
			System.out.println("������ �̹��� ��Ʈ�� : " + bos1);
		}
	}
}//ServerRcv end


//���� Ŭ���� #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf1 = new ServerFrame();
		sf1.setVisible(true);

		ServerSocket ss1 = new ServerSocket(8888);
		System.out.println("���� ����� ....");

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("������ ���� : " + s1.toString());
			//������ /////////////////////////////
			ServerRcvSend srs1 = new ServerRcvSend(s1,sf1);
			srs1.start();
			System.out.println("������� ");

		}
	}
}
