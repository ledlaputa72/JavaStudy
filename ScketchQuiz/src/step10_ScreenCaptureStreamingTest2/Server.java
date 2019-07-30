package step10_ScreenCaptureStreamingTest2;

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

class ThreadSend extends Thread{
	
	Socket socket;
	BufferedImage bi1;
	Robot r;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket socket) throws IOException, AWTException {
		this.socket = socket;
		r = new Robot();
		bos1 = new BufferedOutputStream(socket.getOutputStream()); 
		while(true) {
			bi1 = r.createScreenCapture(new Rectangle(0, 0, 400, 400));//��ũ������ �� image�� ������
			ImageIO.write(bi1, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}

public class Server {
	
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	final int w = 400, h = 400; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	JFrame frame;

	//������� �ػ󵵸� �޾ƿ��� â����

	public static void main(String[] args) {

		new Server(); //Ŭ���̾�Ʈ��İ� �Ȱ��� ������ ȣ��

	}

	public Server() {
		
		//â�� �����
		frame = new JFrame("server");
		frame.setBounds(x, y, w, h); //��� ũ�� �޾ƿ��� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		//��� �غ� 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		try {
			//Ŭ���̾�Ʈ�� ������
			socket_s = new ServerSocket(9999); //��Ʈ ���� 
			socket = socket_s.accept(); // Listen 
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + socket);
		
			//������ �Է½�Ʈ���� ���۽�Ʈ������
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
	
			//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�
			while(true) {
			frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, frame);
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}