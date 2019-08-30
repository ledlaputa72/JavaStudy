package Day050_ScketchQuizTest4;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ServerFrame extends Frame {
	
	private Frame f2=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	static Color bgColor=Color.WHITE; //bruch color

	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	static Button btnStart=new Button("��ư1");
	
	public ServerFrame() {
		//���� ������ 
		f2.setSize(1280, 720);
		f2.setTitle("Scketch Quiz Server");
		f2.setLayout(blo1);
		f2.setVisible(true);
		f2.add(p1,"North");
		f2.add(p2,"Center");
		f2.add(p3,"South");
		
		//p1���� 
		p1.add(btnStart); //
		
		//p2 �߾� ĵ����
		p2.setBackground(bgColor);
		
		//p3 �ϴ� ���� 
		p3.setBackground(Color.BLUE);
		
		//�ݱ�
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f2.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}
	
	
}

class ThreadSend extends Thread{
	
	Socket socket;
	BufferedImage image;
	Robot robot;
	BufferedOutputStream bos1; 
	
	public ThreadSend(Socket socket) throws IOException, AWTException {
		this.socket = socket;
		robot = new Robot();
		bos1 = new BufferedOutputStream(socket.getOutputStream()); 
		while(true) {
			image = robot.createScreenCapture(new Rectangle(0, 0, 1280, 720));//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}

class ThreadRcv extends Thread{
	
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�)  //������� �ػ󵵸� �޾ƿ��� â����//////////////////
	final int w = 1280, h = 720; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket socket;
	BufferedImage image;
	BufferedInputStream bis1; 
	
	
	public ThreadRcv (Socket socket, ServerFrame sf) throws IOException {
		
		//������ �Է½�Ʈ���� ���۽�Ʈ������
		bis1 = new BufferedInputStream(socket.getInputStream());
		//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�
		while(true) {
			sf.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, w, h, sf.p2);
		}
	}
}

public class Server {

	public static void main(String[] args) throws IOException {

		//��� �غ� 
			ServerSocket socket_s = null;
			Socket socket = null;
			
		//Ŭ���̾�Ʈ�� ������
		socket_s = new ServerSocket(12345); //��Ʈ ���� 
		ServerFrame sf=new ServerFrame();
		
		while (true) {
		socket = socket_s.accept(); // Listen 
		System.out.println(socket.getInetAddress() + "���� ������");
		System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + socket);
		
		//Thread 
		ThreadRcv tr1=new ThreadRcv(socket, sf);
		tr1.start();
		}
	}
}
