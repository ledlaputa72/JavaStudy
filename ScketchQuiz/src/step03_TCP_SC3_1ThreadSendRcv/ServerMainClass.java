package step03_TCP_SC3_1ThreadSendRcv;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//���� �׽�Ʈ ������ #########################################
class ServerFrame extends JFrame {
	static JPanel contentPane;
	static JPanel panelView;
	 
	final static int w = 800, h = 400;
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
		// â�� �����
//		frame = new JFrame("server");
		setBounds(x, y, w, h); // ��� ũ�� �޾ƿ���
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 60, 800, 400);
		panelView.setVisible(true);
		contentPane.add(panelView);
	}
}//ServerFrame end

//���� <--> Ŭ�� �ޱ� ������ �ϳ��� ���� ###############################################
class ServerRcvSend extends Thread {
	Socket s1;
	ServerFrame sf1;

	static BufferedImage bufferImage1=null; //�߰�)
	static BufferedInputStream bis1=null;
	
	static BufferedImage bufferImage2=null;
	static BufferedOutputStream bos1;
	
	public ServerRcvSend(Socket s1, ServerFrame sf1) throws IOException, InterruptedException {
		this.s1 = s1;
		this.sf1 = sf1;
		
		while (true) {
			//�޾ƿ���////////////////////////////////////////////
			try{
				bis1 = new BufferedInputStream(s1.getInputStream());
			
				bufferImage1= ImageIO.read(bis1); //�߰�) ���� �����͸� ���ۿ� ����
				System.out.println("SR1) ���� �̹��� ����: " + bufferImage1); //�߰�) ���۳��� Ȯ��
				//�ޱ� ����#######################################
				System.out.println("1111################################################");
				sf1.panelView.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 800, 400, sf1.panelView);//���� �׽�Ʈ â�� �׸� �׸��� 
				System.out.println("SR2) ���� �̹��� ��Ʈ�� : " + bis1); //�߰�) ���� ��Ʈ�� ������ Ȯ�� 
				System.out.println("22222################################################");
				
				
				//���ۿ� ����############################################
				bufferImage2=bufferImage1;
				System.out.println("����1 :  " + bufferImage1);
				System.out.println("����2 :  " + bufferImage2 );
				
				
				//������##############################################
				bos1 = new BufferedOutputStream(s1.getOutputStream());
				System.out.println("SS1) ����2 :  " + bufferImage2 );
	
				ImageIO.write(bufferImage2, "bmp", bos1);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				System.out.println("SS2) ������  �̹��� ���� : " + bufferImage2);
				bos1.flush(); // ���ۿ� ���� �̹����� ������ ��
				System.out.println("SS3) ������ �̹��� : " + bos1);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}//ServerRcv end


//���� Ŭ���� #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerFrame sf1 = new ServerFrame();
		sf1.setVisible(true);

		ServerSocket ss1 = new ServerSocket(7777);
		System.out.println("���� ����� ....");

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("������ ���� : " + s1.toString());
			//������ /////////////////////////////
			ServerRcvSend srs1 = new ServerRcvSend(s1,sf1);
			srs1.start();
			System.out.println("�������6 ");

		}
	}
}
