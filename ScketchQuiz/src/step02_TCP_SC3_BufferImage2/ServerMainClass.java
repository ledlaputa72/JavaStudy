package step02_TCP_SC3_BufferImage2;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

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

}

/*class SendRcvThread extends Thread {
	//Ŭ���̾�Ʈ���� ���� �����͸� �������� �ٽ� Ŭ���̾�Ʈ�� ������ 
	Socket s1;
	ServerFrame sf1=new ServerFrame();
	
	BufferedImage bufferImage1;
	BufferedImage bufferImage2;
	BufferedInputStream bis1; 
	BufferedOutputStream bos1; 
	
	public SendRcvThread(Socket s1) throws IOException {
		this.s1 = s1;
		}
		
		public void run(){
	//���� Rcv	
	try {
		bis1 = new BufferedInputStream(s1.getInputStream());
		while(true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 400, 700, sf1.frame);
			bufferImage1 = ImageIO.read(s1.getInputStream());
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.print("���� : Ŭ�󿡼� �̹��� ����"+"\t");
		System.out.println("���� ���� : " + bufferImage1);
	
		
	//���� Send
	try {	
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			ImageIO.write(bufferImage2, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ��
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.print("���� : Ŭ��� ���� �̹��� ����"+"\t");
		System.out.println("���� ���� : " + bufferImage2);
	}
}*/

class ServerRcv extends Thread {
	Socket s1;
	ServerFrame sf1 = new ServerFrame();

	BufferedImage bufferImage1;
	BufferedInputStream bis1;

	public ServerRcv(Socket s1) throws IOException {
		this.s1 = s1;
		bis1 = new BufferedInputStream(s1.getInputStream());
		while (true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 400, 700, sf1.frame);
			bufferImage1 = ImageIO.read(s1.getInputStream());
			System.out.println("���� �̹��� : " + bis1);
		}
	}

}

class ServerSend extends Thread {
	Socket s1;
	ServerFrame sf1 = new ServerFrame();

	BufferedImage bufferImage2;
	BufferedOutputStream bos1;

	public ServerSend(Socket s1) throws IOException {
		this.s1 = s1;
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		while (true) {
			ImageIO.write(bufferImage2, "bmp", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("������ �̹��� : " + bos1);
			bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
		}
	}
}


public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf = new ServerFrame();
		sf.setVisible(true);

		try {
			ServerSocket ss1 = new ServerSocket(8888);
			System.out.println("���� ����� ....");

			while (true) {
				Socket s1 = ss1.accept();
				System.out.println("������ ���� : " + s1.toString());

				ServerRcv sr1 = new ServerRcv(s1);
				ServerSend sd1 = new ServerSend(s1);
				sr1.start();
				sd1.start();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
