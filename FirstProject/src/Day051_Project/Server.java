package Day051_Project;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
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
import javax.swing.JPanel;


//������ ������ ////////////////////////////////////////
class ThreadSend extends Thread{
	
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket socket;
	BufferedImage image;
	Robot r;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket s1) throws IOException, AWTException {
		this.socket = s1;
		r = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			image = r.createScreenCapture(new Rectangle(0, 60, 800, 700));//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}////////////////////////////////////////

//�ޱ� ������ ////////////////////////////////////////
class ThreadRcv extends Thread{
	
	Socket socket;
	BufferedInputStream bis1;
	JPanel panelView;
	
	public ThreadRcv(Socket s1,JPanel panelView) throws IOException, AWTException {
		this.socket = s1;
		this.panelView = panelView;
		bis1 = new BufferedInputStream(s1.getInputStream());
		//������ �Է½�Ʈ���� ���۽�Ʈ������
		while(true) {
			panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 700, 800, panelView);
		}
	}
}/////////////////////////////////////////////


//����///////////////////////////////////////
public class Server {
	
	//������� �ػ󵵸� �޾ƿ��� â����
	public static void main(String[] args) throws IOException, AWTException {
		
		ServerSocket ss1=new ServerSocket(9999); //��Ʈ ���� 
		System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����");

		
		while (true) {
			System.out.println("���� ��....");
			Socket s1=ss1.accept(); //����
			System.out.println(s1.getInetAddress()+"���ӵǾ����ϴ�.");
			
			/*ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1 = new ThreadRcv(s1);
			ts1.start();
			tr1.start();*/
		}

	}

}