package step03_ScreenCaptureWindowFix_fullWindow;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//���� ���̾ƿ����� �׸� �׸��� & �����ֱ� ������ ���ؼ� ȭ�� �̵��� �����ϰ� ��ũ������ �����ִ� ��� ����  


class JFramServerLayout extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	static JPanel panelCanvas;
	static JPanel panelView;

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	final int w = 800, h = 700; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	
	public JFramServerLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.CYAN);
		panelTop.setBounds(0, 0, 1184, 60);
		contentPane.add(panelTop);
		panelTop.setLayout(null);
		
		panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 700);
		panelCanvas.setVisible(false);
		contentPane.add(panelCanvas);
		
		panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 60, 800, 700);
		panelView.setVisible(true);
		contentPane.add(panelView);
		
		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.GRAY);
		panelChat.setBounds(800, 60, 384, 700);
		contentPane.add(panelChat);
		panelChat.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 664, 384, 38);
		panelChat.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 384, 664);
		panelChat.add(textArea);
		
		JPanel panelUsers = new JPanel();
		panelUsers.setBackground(Color.ORANGE);
		panelUsers.setBounds(0, 759, 1184, 180);
		contentPane.add(panelUsers);
		
	}
}

//������ ���� 
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
			//��ǥ �ٽ�##################################################################
			JFramTest2.panelCanvasX=(int)JFramTest2.panelCanvas.getLocationOnScreen().getX(); //��ǥ ������ �����  static���� ����
			JFramTest2.panelCanvasY=(int)JFramTest2.panelCanvas.getLocationOnScreen().getY();
			//###########################################################################
			image = robot.createScreenCapture(new Rectangle(JFramTest2.panelCanvasX-4, JFramTest2.panelCanvasY-60, 800, 700));//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
		}
	}
}


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

public class JFrameServer {

	public static void main(String[] args) {
		
		
		JFramServerLayout sc=new JFramServerLayout();
		sc.setVisible(true);
		
		
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
				sc.panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, 800, 700, sc.panelView);
			}

		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
}
