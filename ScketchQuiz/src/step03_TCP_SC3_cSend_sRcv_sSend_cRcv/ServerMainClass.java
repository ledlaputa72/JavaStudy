package step03_TCP_SC3_cSend_sRcv_sSend_cRcv;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


//���� �׽�Ʈ ������ #########################################
class ServerFrame extends JFrame {
	static JFrame frame;
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

//���� <--> Ŭ�� �ޱ� ###############################################
class ServerRcvSend extends Thread {
	Socket s1;
	JFrame sf1;
	
	//�ޱ�� �ʵ� 
	static BufferedImage bufferImage1=null; //�߰�)
	static BufferedInputStream bis1;
	//������� �ʵ� 
	static BufferedImage bufferImage2=null;
	static BufferedOutputStream bos1;

	public ServerRcvSend (Socket s1, ServerFrame sf1) throws IOException {
		this.s1 = s1;
		this.sf1 = sf1;
		
		while (true) {
			//###########  �ޱ�  ######################################
			bis1 = new BufferedInputStream(s1.getInputStream());
			System.out.println("SR1) ���� �̹��� ��Ʈ��: " + bis1); //�߰�) ���� ��Ʈ�� ������ Ȯ�� 
			
			bufferImage1= ImageIO.read(bis1); //�߰�) ���� �����͸� ���ۿ� ����
			System.out.println("SR2) ���� �̹��� ����: " + bufferImage1); //�߰�) ���۳��� Ȯ��
			
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.frame);//���� �׽�Ʈ â�� �׸� �׸��� 
			System.out.println("SR3) ���� �̹��� ��Ʈ�� : " + bis1); //�߰�) ���� ��Ʈ�� ������ Ȯ�� 
			System.out.println("##################################");
			
			//���ۿ� ����///////��� �߰� 
			bufferImage2=bufferImage1;
			System.out.println(") ����1 :  " + bufferImage1);
			System.out.println(") ����2 :  " + bufferImage2 );
			
			
			//############  ������   #######################################
			bos1 = new BufferedOutputStream(s1.getOutputStream());
			System.out.println("SS1) ������ �̹���(�������) : " + bos1);
			
			ImageIO.write(bufferImage2, "png", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("SS2) ������  �̹��� ���� : " + bufferImage2);
			System.out.println("SS3) ������ �̹��� : " + bos1);
			bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
			System.out.println("SS4) ������ �̹��� : " + bos1);
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
			ServerRcvSend sr1 = new ServerRcvSend(s1,sf1);
			sr1.start();
			System.out.println("�������6 ");
		}
	}
}
